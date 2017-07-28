/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import vampire.Vampire;
import static vampire.Vampire.mainInstance;

/**
 *
 * @author student
 */
public class core {
    
    public static void print(String text) {
        System.out.println(text);
    }
    
    public static void setInstance() {
        try {
            if(mainInstance == null) {
                mainInstance = Vampire.objDefClass.getDeclaredField("clientInstance").get(null);
            }
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(core.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(core.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(core.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(core.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        setInstance();
        for(Field f: Vampire.allFields) {
            if(f.getName().equals(Vampire.conf.getObfName(fieldName, cName)) && f.getDeclaringClass().getName().equalsIgnoreCase(cName)) {
                return f;
            }
        }
        System.out.println("FAILURE! Could not get field " + fieldName);
        return null;
    }
    
    public static Method getMethod(String methodName, String cName) {
        setInstance();
        for(Method m: Vampire.allMethods) {
            if(m.getName().equals(Vampire.conf.getObfName(methodName, cName)) && m.getDeclaringClass().getName().equals(cName)) {
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
        int pX = (int) getMemberField(playerObj, Vampire.conf.getObfName("x", Vampire.conf.getPlayerClass()));
        int bX = getField("baseX", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
        System.out.println(bX);
        return (pX >> 7) + bX;
    }
    
    public static int getPlayerY() throws Exception {
        Object playerObj = getField("myPlayer", Vampire.conf.getMainClass()).get(Vampire.mainInstance);
        int pY = (int) getMemberField(playerObj, Vampire.conf.getObfName("y", Vampire.conf.getPlayerClass()));
        int bY = getField("baseY", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
        System.out.println(bY);
        return (pY >> 7) + bY;
        
    }
    
    public static int getPlayerZ() throws Exception {
        return getField("plane", Vampire.conf.getMainClass()).getInt(Vampire.mainInstance);
    }
    
    public static boolean openInterface(int interfaceID) {
        try {
            Field openInterfaceID = getField("openInterfaceID", Vampire.conf.getMainClass());
            Field invOverlayInterfaceID = getField("invOverlayInterfaceID", Vampire.conf.getMainClass());
            Field needDrawTabArea = getField("needDrawTabArea", Vampire.conf.getMainClass());
            Field tabAreaAltered = getField("tabAreaAltered", Vampire.conf.getMainClass());
            Field backDialogID = getField("backDialogID", Vampire.conf.getMainClass());
            Field inputTaken = getField("inputTaken", Vampire.conf.getMainClass());
            Field inputDialogState = getField("inputDialogState", Vampire.conf.getMainClass());
            Method m = getMethod("method60", Vampire.conf.getMainClass());
            m.invoke(mainInstance, new Object[] { Integer.valueOf(interfaceID) });
            
            if (((Integer)invOverlayInterfaceID.get(mainInstance)).intValue() != -1) {
                invOverlayInterfaceID.set(mainInstance, Integer.valueOf(-1));
                needDrawTabArea.set(mainInstance, Boolean.valueOf(true));
                tabAreaAltered.set(mainInstance, Boolean.valueOf(true));
            }
            if (((Integer)backDialogID.get(mainInstance)).intValue() != -1) {
                backDialogID.set(mainInstance, Integer.valueOf(-1));
                inputTaken.set(mainInstance, Boolean.valueOf(true));
            }
            if (((Integer)inputDialogState.get(mainInstance)).intValue() != 0) {
                inputDialogState.set(mainInstance, Integer.valueOf(0));
                inputTaken.set(mainInstance, Boolean.valueOf(true));
            }
            openInterfaceID.set(mainInstance, Integer.valueOf(interfaceID));
            getField("aBoolean1149", Vampire.conf.getMainClass()).set(mainInstance, Boolean.valueOf(false));
            getField("pktType", Vampire.conf.getMainClass()).set(mainInstance, Integer.valueOf(-1));
            openInterfaceID.set(mainInstance, Integer.valueOf(interfaceID));
            return true;
        } catch (Exception ex) {
            return false;
        } 
    }
    
    public static boolean setSidebar(int menuId, int form) {
        try {
            int l1 = form;
            int j10 = menuId;
            int[] f = (int[])getField("tabInterfaceIDs", Vampire.conf.getMainClass()).get(mainInstance);
            f[j10] = l1;
            getField("tabInterfaceIDs", Vampire.conf.getMainClass()).set(mainInstance, f);
            getField("needDrawTabArea", Vampire.conf.getMainClass()).setBoolean(mainInstance, true);
            getField("tabAreaAltered", Vampire.conf.getMainClass()).setBoolean(mainInstance, true);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return true; //even if we get an exception, it probably worked anyway. Just java freaking out about final fields.
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
                .invoke(Vampire.mainInstance, new Object[] { -1, id, face, 117, y2, type, height, x2, 0});
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
