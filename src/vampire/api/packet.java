/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vampire.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import vampire.api.core;
import vampire.Vampire;
import static vampire.api.core.getField;
import static vampire.api.core.getMethod;
import static vampire.Vampire.streamInstance;

/**
 *
 * @author Machiavelli
 */
public class packet {
    
    public static void createFrame(int paramInt) {
        try {
            Method cF = getMethod("createFrame", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex.getCause());
        } 
    }
    
    public static void method403(int paramInt) {
        try {
            Method cF = getMethod("method403", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void method424(int paramInt) {
        try {
            Method cF = getMethod("method424", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void method425(int paramInt) {
        try {
            Method cF = getMethod("method425", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void method431(int paramInt) {
        try {
            Method cF = getMethod("method431", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void method432(int paramInt) {
        try {
            Method cF = getMethod("method432", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void method433(int paramInt) {
        try {
            Method cF = getMethod("method433", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeWord(int paramInt) {
        try {
            Method cF = getMethod("writeWord", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeWordBigEndian(int paramInt) {
        try {
            Method cF = getMethod("writeWordBigEndian", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        public static void writeDWord(int paramInt) {
        try {
            Method cF = getMethod("writeDWord", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeDWordBigEndian(int paramInt) {
        try {
            Method cF = getMethod("writeDWordBigEndian", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramInt});
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeQWord(long paramLong) {
        try {
            Method cF = getMethod("writeQWord", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramLong });
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeQWordBigEndian(long paramLong) {
        try {
            Method cF = getMethod("writeQWordBigEndian", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramLong });
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void writeString(String paramStr) {
        try {
            Method cF = getMethod("writeString", Vampire.conf.getStreamClass());
            cF.invoke(streamInstance, new Object[] { paramStr });
        } catch (Exception ex) {
            Logger.getLogger(packet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
}
