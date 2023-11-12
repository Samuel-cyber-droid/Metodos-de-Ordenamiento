/*Realizar un programa que compare el tiempo de cálculo de las búsquedas secuencial y
binaria. Una lista A se rellena con 2.000 enteros aleatorios en el rango 0 ... 1999 y a continuación se ordena.
Una segunda lista B se rellena con 500 enteros aleatorios en el mismo rango.
Los elementos de B se utilizan como claves de los algoritmos de búsqueda.*/

import java.util.Random;

public class problema65 {

    //Metodo para llenar una lista con enteros aleatorios en el rango 0 ... 1999
    public static void llenarConAleatorios(int[] lista) {
        Random random = new Random();
        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextInt(2000);
        }
    }

    //Metodo para realizar una busqueda secuencial en una lista
    public static int busquedaSecuencial(int[] lista, int clave) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    //Metodo para realizar una busqueda binaria en una lista
    public static int busquedaBinaria(int[] lista, int clave) {
        int inicio = 0;
        int fin = lista.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (lista[medio] == clave) {
                return medio;
            } else if (lista[medio] < clave) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Tamaño de las listas
        int tamListaA = 2000;
        int tamListaB = 500;

        //Crear y llenar las lista A con enteros aleatorios en el rango 0 ... 1999
        int[] listaA = new int[tamListaA];
        llenarConAleatorios(listaA);

        //Crear y llenar la lista B con enteros aleatorios en el mismo rango
        int[] listaB = new int[tamListaB];
        llenarConAleatorios(listaB);

        //Realizar busquedas secuenciales en la lista A
        long tiempoInicio = System.nanoTime();
        for (int clave : listaB) {
            busquedaSecuencial(listaA, clave);
        }
        long tiempoFinSecuencial = System.nanoTime();
        long tiempoTotalSecuencial = tiempoFinSecuencial - tiempoInicio;

        //Realizar busquedas binarias en la lista A
        long tiempoInicioBinaria = System.nanoTime();
        for (int clave : listaB) {
            busquedaBinaria(listaA, clave);
        }
        long tiempoFinBinaria = System.nanoTime();
        long tiempoTotalBinaria = tiempoFinBinaria - tiempoInicioBinaria;

        //Mostrar resultados
        System.out.println("Tiempo total de busqueda secuencial: " + tiempoTotalSecuencial + " nanosegundos");
        System.out.println("Tiempo total de busqueda binaria: " + tiempoTotalBinaria + " nanosegundos");
    }
}