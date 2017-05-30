/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire;

import java.net.URL;
import java.net.URLClassLoader;
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
    
    public static void main(String[] args) {
        conf = new clientConfig();
        window = new mainUI();
        window.setVisible(true);
    }
    
    public static void loadClient() throws Exception {
        jarURL = conf.getJarURL();
        URL[] javaNeedsAnArray = { jarURL };
        URLClassLoader jarLoader = new URLClassLoader(javaNeedsAnArray);
        Class mainClass = jarLoader.loadClass(conf.getMainClass());
        Object mainInstance = mainClass.newInstance();
        mainClass.getMethod("main").invoke(mainInstance);
    }
    
    
}
