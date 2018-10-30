package com.ricardobaquero.maquinaturing;

import static com.ricardobaquero.maquinaturing.Direccion.DERECHA;
import static com.ricardobaquero.maquinaturing.Maquina.BLANCO;
import java.util.Scanner;

/**
 *
 * @author Ricardo Baquero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejemplo de uso
        // Complemento 1
        
        // Declarar estados:
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado[] estados = {q0, q1};
        // Declarar alfabeto:
        char[] alfabeto = {'0', '1'};
        // Crear la función de transición:
        Funcion funcion = new Funcion()
                .add(q0, '1', new Transicion(q0, '0', DERECHA))
                .add(q0, '0', new Transicion(q0, '1', DERECHA))
                .add(q0, BLANCO, new Transicion(q1, BLANCO, DERECHA));
        // Definir estado inicial:
        Estado estadoInicial = q0;
        // Definir los estados finales:
        Estado[] estadosFinales = {q1};
        // Crear máquina:
        Maquina maquina = new Maquina(estados, alfabeto, funcion, estadoInicial, estadosFinales);
        // Pedir la cadena al usuario:
        String cadena = pedirCadena();
        // Agregar la cadena como una cinta a la máquina:
        maquina.addCinta(cadena);
        try {
            // Comenzar la evaluación:
            maquina.evaluar();
        } catch (UnrecognizedStringException ex) {
            // En caso de un error, lanzar la excepción:
            throw ex;
        }
        // Obtener el resultado de la máquina:
        String resultado = maquina.getCinta();
        // Imprimir el resultado:
        System.out.println("El resultado es: " + resultado);
    }
    
    private static String pedirCadena() {
        System.out.println("Ingrese la cadena de 0 y 1s que desea calcular su complemento:");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        return cadena;
    }
    
}
