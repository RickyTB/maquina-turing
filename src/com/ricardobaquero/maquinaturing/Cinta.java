package com.ricardobaquero.maquinaturing;

/**
 *
 * @author ricardobaquero
 */
public class Cinta {

    private static class Nodo {

        private char caracter;
        private Nodo ant;
        private Nodo sig;
    }

    private Nodo top;
    private char blanco;

    private Cinta(char blanco) {
        this.blanco = blanco;
    }
    
    public Cinta(int n, char blanco) {
        this(blanco);
        top = null;
        Nodo ultimo = top;
        for (int i = 1; i <= n; i++) {
            Nodo temp = new Nodo();
            temp.caracter = blanco;
            temp.sig = null;
            if (top == null) {
                temp.ant = null;
                top = temp;
            } else {
                ultimo.sig = temp;
                temp.ant = ultimo;
            }
            ultimo = temp;
            ultimo.sig = top;
            top.ant = ultimo;
        }
    }

    public Cinta(int n) {
        this(n, Maquina.BLANCO);
    }

    public Cinta(String cadena, char blanco) {
        this(blanco);
        char[] caracteres = cadena.toCharArray();
        top = null;
        Nodo ultimo = top;
        for (int i = 0; i < caracteres.length + 4; i++) {
            Nodo temp = new Nodo();
            temp.caracter = i < caracteres.length ? caracteres[i] : blanco;
            temp.sig = null;
            if (top == null) {
                temp.ant = null;
                top = temp;
            } else {
                ultimo.sig = temp;
                temp.ant = ultimo;
            }
            ultimo = temp;
            ultimo.sig = top;
            top.ant = ultimo;
        }
    }
    
    public Cinta(String cadena) {
        this(cadena, Maquina.BLANCO);
    }

    public void avanzar() {
        top = top.sig;
    }

    public void retroceder() {
        top = top.ant;
    }

    public char getCaracter() {
        return top.caracter;
    }
    
    public void setCharacter(char caracter) {
        top.caracter = caracter;
    }
    
    public String getCadena() {
        StringBuilder resultado = new StringBuilder();
        Nodo temp = top;
        boolean continuar = true;
        while (continuar) {
            resultado.append(temp.caracter != blanco ? temp.caracter : "");
            temp = temp.sig;
            if (temp == top) {
                continuar = false;
            }
        }
        return resultado.toString();
    }

}
