package com.ricardobaquero.maquinaturing;

import static com.ricardobaquero.maquinaturing.Maquina.CUALQUIER;
import java.util.HashMap;

/**
 *
 * @author ricardobaquero
 */
public class Funcion {

    private final HashMap<String, Transicion> funciones = new HashMap<>();

    public Funcion add(Estado estado, char caracter, Transicion transicion) {
        funciones.put(estado + "+" + (caracter != CUALQUIER ? caracter : ""), transicion);
        return this;
    }

    public Transicion from(Estado estado, char caracter) {
        Transicion t = funciones.get(estado + "+" + caracter);
        if (t == null) {
            t = funciones.get(estado + "+");
        }
        return t;
    }

}
