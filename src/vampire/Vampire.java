/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
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
    private static clientConfig conf;
    private static mainUI window;
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        conf = clientConfig.loadJson();
        //conf = new clientConfig();
        //conf.dumpConfig();
        window = new mainUI();
        window.setVisible(true);
        loadClient();
    }
    
    public static void loadClient() throws Exception {
        jarURL = conf.getJarURL();
        URL[] javaNeedsAnArray = { jarURL };
        URLClassLoader jarLoader = new URLClassLoader(javaNeedsAnArray);
        Class mainClass = jarLoader.loadClass(conf.getMainClass());
        Object mainInstance = mainClass.newInstance();
        String[] args = conf.getArgs();
        mainClass.getDeclaredMethod(conf.getMainMethod(), new Class[]{String[].class})
                .invoke(mainInstance, new Object[]{args});
    }
    
    public static String handleCommand(String command) throws Exception {
        String scriptPath = clientConfig.getScriptPath() + command + ".js";
        File f = new File(scriptPath);
        if(!f.exists()) {
            return "Error! Invalid command!";
        }
        engine.eval(new FileReader(scriptPath));
        Invocable run = (Invocable) engine;
        Object result = run.invokeFunction("command");
        return (String) result;
    }
    
    
}
