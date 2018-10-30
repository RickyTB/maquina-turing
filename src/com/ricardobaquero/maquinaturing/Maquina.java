package com.ricardobaquero.maquinaturing;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ricardobaquero
 */
public class Maquina {

    public static final char BLANCO = '~';
    public static final char CUALQUIER = 'ª';

    private Estado[] estados;
    private char[] alfabeto;
    private char[] simbolos;
    private Funcion funcion;
    private Estado estadoInicial;
    private char blanco;
    private Estado[] estadosFinales;

    private Cinta cinta;
    private Estado estadoActual;

    public Maquina(Estado[] estados, char[] alfabeto, char[] simbolos, Funcion funcion, Estado estadoInicial, char blanco, Estado[] estadosFinales) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.simbolos = simbolos;
        this.funcion = funcion;
        this.estadoInicial = estadoInicial;
        this.blanco = blanco;
        this.estadosFinales = estadosFinales;
    }

    public Maquina(Estado[] estados, char[] alfabeto, Funcion funcion, Estado estadoInicial, Estado[] estadosFinales) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.simbolos = Arrays.copyOf(alfabeto, alfabeto.length + 1);
        this.simbolos[this.alfabeto.length] = BLANCO;
        this.funcion = funcion;
        this.estadoInicial = estadoInicial;
        this.blanco = BLANCO;
        this.estadosFinales = estadosFinales;
    }

    public void addCinta(String cadena) {
        this.cinta = new Cinta(cadena, blanco);
    }

    public String evaluar() throws UnrecognizedStringException {
        this.estadoActual = estadoInicial;
        List<Estado> eList = Arrays.asList(estadosFinales);
        while (!eList.contains(estadoActual)) {
            Transicion transicion = funcion.from(estadoActual, cinta.getCaracter());
            if (transicion == null) {
                throw new UnrecognizedStringException();
            }
            if (transicion.getCaracter() != CUALQUIER) {
                cinta.setCharacter(transicion.getCaracter());
            }
            if (transicion.getDireccion() == Direccion.DERECHA) {
                cinta.avanzar();
            }
            if (transicion.getDireccion() == Direccion.IZQUIERDA) {
                cinta.retroceder();
            }
            estadoActual = transicion.getEstado();
        }

        return cinta.getCadena();
    }

    public String getCinta() {
        return cinta.getCadena();
    }

}
