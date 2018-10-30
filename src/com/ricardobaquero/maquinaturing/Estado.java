package com.ricardobaquero.maquinaturing;

/**
 *
 * @author ricardobaquero
 */
public class Estado {
    private final String name;

    public Estado(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
