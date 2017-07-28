/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import vampire.api.core;
import vampire.ui.mainUI;

/**
 *
 * @author Machiavelli
 */
public class Vampire {

    /**
     * @param args the command line arguments
     */
    private static URL jarURL;
    public static clientConfig conf;
    private static mainUI window;
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    public static ArrayList<Method> allMethods = new ArrayList<>();
    public static ArrayList<Field> allFields = new ArrayList<>();
    public static Object mainInstance;
    public static    Class mainClass;
    public static    Class playerClass;
    public static    Class streamClass;
    public static    Class objDefClass;
    
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        conf = clientConfig.loadJson();
        //conf = new clientConfig();
        //conf.dumpConfig();
        window = new mainUI();
        window.setVisible(true);
        //loadClient();
    }
    
    public static void loadClient() throws Exception {
        jarURL = conf.getJarURL();
        URL[] javaNeedsAnArray = { jarURL };
        URLClassLoader jarLoader = new URLClassLoader(javaNeedsAnArray);
        mainClass = jarLoader.loadClass(conf.getMainClass());
        playerClass = jarLoader.loadClass(conf.getPlayerClass());
        streamClass = jarLoader.loadClass(conf.getStreamClass());
        objDefClass = jarLoader.loadClass(conf.getObjDefClass());
        makeAccessible(mainClass);
        makeAccessible(streamClass);
        makeAccessible(playerClass);
        makeAccessible(objDefClass);
        mainInstance = null;
        String[] args = conf.getArgs();
        mainClass.getDeclaredMethod(conf.getMainMethod(), new Class[]{String[].class})
                .invoke(mainInstance, new Object[]{args});
    }
    
    public static void makeAccessible(Class toProcess) {
        for(Method m: toProcess.getDeclaredMethods()) {
            m.setAccessible(true);
            allMethods.add(m);
        }
        for(Field f: toProcess.getDeclaredFields()) {
            f.setAccessible(true);
            allFields.add(f);
        }
    }
    
    public static String handleCommand(String command) throws Exception {
        String args = "";
        if(command.contains(" ")) {
            args = command.split(" ", 2)[1];
            command = command.split(" ", 2)[0];
        }
        
        String scriptPath = clientConfig.getScriptPath() + command + ".js";
        File f = new File(scriptPath);
        if(!f.exists()) {
            return "Error! Invalid command!";
        }
        engine.eval(new FileReader(scriptPath));
        Invocable run = (Invocable) engine;
        Object result = run.invokeFunction("command", args);
        return (String) result;
    }
    
    
}
