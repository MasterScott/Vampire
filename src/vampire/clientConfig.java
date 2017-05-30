/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Map clientVars = new HashMap();
    
    public clientConfig() throws Exception {

    }
    
    public Field getObf(String fieldName) {
        return (Field) clientVars.get(fieldName);
    }
    
    public static clientConfig loadJson() throws Exception {
        Gson gson = new Gson();
        clientConfig conf = gson.fromJson(new FileReader(jsonPath), clientConfig.class);
        return conf;
    }

    
    public URL getJarURL() {
        return jarURL;
    }
    
    public String getScriptPath() {
        return scriptPath;
    }
    
    public String getMainClass() {
        return mainClass;
    }
    
    public String getPlayerClass() {
        return playerClass;
    }
        
    public String getStreamClass() {
        return streamClass;
    }
    
}
