package net.javainthebox.caraibe;

import java.util.HashMap;
import java.util.Map;
import net.javainthebox.caraibe.pagetransition.PageTransition;

public class Constants {
    private static Constants instance;
    
    private Configuration configuration;
    private Map<String, Object> map = new HashMap<>();
            
    private Constants() {}
    
    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        
        return instance;
    }
    
    public void init(Configuration configuration) {
        if (this.configuration != null) {
            throw new IllegalAccessError("Constatnts has initialized already.");
        }
        
        this.configuration = configuration;
    }
    
    public String[] getFactories() {
        return configuration.factories;
    }
    
    public double getWidth() {
        return configuration.width;
    }
    
    public double getHeight() {
        return configuration.height;
    }
    
    public PageTransition defaultPageTransition() {
        return configuration.defaultPageTransition;
    }
    
    public void add(String key, Object value) {
        map.put(key, value);
    }
    
    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }
}
