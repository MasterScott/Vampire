/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public static int getIntField(String FQDN) {
        return -1;
    }
    
    public static Field getField(String fieldName, String cName) {
        for(Field f: Vampire.allFields) {
            if(f.getName().equals(Vampire.conf.getObfName(fieldName, cName)) && f.getDeclaringClass().getName().equalsIgnoreCase(cName)) {
                return f;
            }
        }
        return null;
    }
    
    public static Method getMethod(String methodName, String cName) {
        for(Method m: Vampire.allMethods) {
            if(m.getName().equals(Vampire.conf.getObfName(methodName, cName)) && m.getDeclaringClass().getName().equalsIgnoreCase(cName)) {
                return m;
            }
        }
        return null;
    }
    
    public static Object getMemberField(Object grabbedObject, String fieldName) throws Exception {
        Object someObject = grabbedObject;
        Field field;
        field = someObject.getClass().getField(fieldName);
        field.setAccessible(true); // You might want to set modifier to public first.
        Object value = field.get(grabbedObject); 
        if (value != null) {
            return value;
        }
        return null;
    }
    public static int getPlayerX() throws Exception {
        Object playerObj = getField("myPlayer", Vampire.conf.getMainClass()).get(Vampire.mainInstance);
        int pX = (int) getMemberField(playerObj, "x");
        int bX = (int) getField("baseX", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
        return(bX + (pX >> 7));
        //return pX;
    }
    
    public static int getPlayerY() throws Exception {
        Object playerObj = getField("myPlayer", Vampire.conf.getMainClass()).get(Vampire.mainInstance);
        int pY = (int) getMemberField(playerObj, "y");
        int bY = (int) getField("baseY", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
        return(bY + (pY >> 7));
    }
    
    public static int getPlayerZ() throws Exception {
        return getField("plane", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
    }
    
    public static boolean spawnObject(int x, int y, int id, int face, int type, int height) {
        try {
        int mX = getField("anInt1069", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance) - 6;
        int mY = getField("anInt1070", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance) - 6;
        int x2 = x - mX * 8;
        int y2 = y - mY * 8;
        int[] anInt = (int[]) getField("anIntArray1177", Vampire.conf.getMainClass()).get(Vampire.mainInstance);
        int l17 = anInt[10];
        if ((y2 > 0) && (y2 < 103) && (x2 > 0) && (x2 < 103)) {
            getMethod("method130", Vampire.conf.getMainClass())
                .invoke(Vampire.mainInstance, new Object[] { -1, id, face, l17, y2, type, height, x2, 0});
            return true;
        }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean setClientField(String FQDN, Object value) {
        return false;
    }
   
    
}
