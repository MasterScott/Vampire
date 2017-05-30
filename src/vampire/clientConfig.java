/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

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
    
    private URL jarURL;
    private String mainClass;
    private String streamClass;
    private String playerClass;
    private Map clientVars = new HashMap();
    
    public clientConfig() {
        loadJson();
    }
    
    public Field getObf(String fieldName) {
        return null;
    }
    
    public void loadJson() {
        
    }
    
    public URL getJarURL() {
        return jarURL;
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
