package com.ricardobaquero.maquinaturing;

/**
 *
 * @author ricardobaquero
 */
public class Transicion {
    private final Estado estado;
    private final char caracter;
    private final Direccion direccion;

    public Transicion(Estado estado, char caracter, Direccion direccion) {
        this.estado = estado;
        this.caracter = caracter;
        this.direccion = direccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public char getCaracter() {
        return caracter;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
}
