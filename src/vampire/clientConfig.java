/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Machiavelli
 */
public class clientConfig {
    
    private static final String jsonPath = "./data/conf.json";
    private static final String scriptPath = "./data/scripts/";
    
    private URL jarURL;
    private String mainClass;
    private String streamClass;
    private String playerClass;
    private String objDefClass;
    private String[] clientArgs;
    private String mainMethod;
    
    private Map clientVars = new HashMap();
    private Map playerVars = new HashMap();
    private Map streamVars = new HashMap();
    private Map objDefVars = new HashMap();
    
    private Map clientMethods = new HashMap();
    private Map playerMethods = new HashMap();
    private Map streamMethods = new HashMap();
    private Map objDefMethods = new HashMap();

    
    public clientConfig() throws Exception {
        jarURL = new File("./client.jar").toURI().toURL();
        mainClass = "Client";
        streamClass = "Stream";
        playerClass = "Player";
        objDefClass = "ObjectDef";
        clientVars.put("baseX", "baseX");
        clientArgs = new String[] {"a", "a"};
    }
    
    public String getMainMethod() {
        return mainMethod;
    }
    
    public String[] getArgs() {
        return clientArgs;
    }
    
    public String getObfName(String fieldName, String cName) {
            if(cName == mainClass) {
                if(clientVars.get(fieldName) != null) {
                   return (String) clientVars.get(fieldName);
                }
            }
            if(cName == streamClass) {
                if(streamVars.get(fieldName) != null) {
                   return (String) streamVars.get(fieldName);
                }
            }
            if(cName == playerClass) {
                if(playerVars.get(fieldName) != null) {
                   return (String) playerVars.get(fieldName);
                }
            }
            if(cName == objDefClass) {
                if(objDefVars.get(fieldName) != null) {
                   return (String) objDefVars.get(fieldName);
                }
            }
        return fieldName; //if no obfuscation map is found, we just return the original name for compatibility.
    }
    
    public String getObfMethod(String methodName, String cName) {
        switch(cName.toLowerCase()) {
            case "client":
                if(clientMethods.get(methodName) != null) {
                   return (String) clientMethods.get(methodName);
                }
                break;
            case "stream":
                if(streamMethods.get(methodName) != null) {
                   return (String) clientMethods.get(methodName);
                }
                break;
            case "player":
                if(playerMethods.get(methodName) != null) {
                   return (String) clientMethods.get(methodName);
                }
                break;
            case "objectdef":
                if(objDefMethods.get(methodName) != null) {
                   return (String) objDefMethods.get(methodName);
                }
                break;
        }
        return methodName; //if no obfuscation map is found, we just return the original name for compatibility.
    }
    
    public void dumpConfig() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(jsonPath);
        gson.toJson(this, writer);
        writer.close();
    }
    
    public static clientConfig loadJson() throws Exception {
        Gson gson = new Gson();
        clientConfig conf;
        try {
            conf = gson.fromJson(new FileReader(jsonPath), clientConfig.class);
        } catch (FileNotFoundException ex) {
            return new clientConfig();
        }
        return conf;
    }

    
    public URL getJarURL() {
        return jarURL;
    }
    
    public static String getScriptPath() {
        return scriptPath;
    }
    
    public String getMainClass() {
        return mainClass;
    }
    
    public String getPlayerClass() {
        return playerClass;
    }
    
    public String getObjDefClass() {
        return objDefClass;
    }
        
    public String getStreamClass() {
        return streamClass;
    }
    
}
