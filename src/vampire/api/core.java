/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire.api;

import java.util.logging.Level;
import java.util.logging.Logger;
import vampire.Vampire;

/**
 *
 * @author student
 */
public class core {
    
    public static void print(String text) {
        System.out.println(text);
    }
    
    public static void startClient() {
        try {
            Vampire.loadClient();
        } catch (Exception ex) {
            Logger.getLogger(core.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean setClientField(String FQDN, Object value) {
        return false;
    }
   
    
}
