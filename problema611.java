/*Se leen dos listas de números enteros, A y B, de 100 y 60 elementos, respectivamente.
Se desea resolver las siguientes tareas:
a)	 Ordenar aplicando el método de Quicksort cada una de las listas A y B.
b)	 Crear una lista C por intercalación o mezcla de las listas A y B.
c)	 Visualizar la lista C ordenada.*/

import java.util.Arrays;
import java.util.Random;

public class problema611 {

    //Metodo Quicksort
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int particionIndex = particion(arr, low, high);
            quicksort(arr, low, particionIndex - 1);
            quicksort(arr, particionIndex + 1, high);
        }
    }

    //Metodo de particion
    private static int particion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //Implementacion de la intercalacion o mezcla de las listas A y B
    public static int[] merge(int[] listaA, int[] listaB) {
        int[] mergedArray = new int[listaA.length + listaB.length];
        int i = 0, j = 0, k = 0;

        while (i < listaA.length && j < listaB.length) {
            if (listaA[i] <= listaB[j]) {
                mergedArray[k++] = listaA[i++];
                i++;
            } else {
                mergedArray[k++] = listaB[j++];
                j++;
            }
        }

        while (i < listaA.length) {
            mergedArray[k++] = listaA[i++];
        }

        while (i < listaB.length) {
            mergedArray[k++] = listaB[j++];
        }

        return mergedArray;
    }

    //Generar una lista de numeros aleatorios
    public static int[] generarListaAleatoria(int tamano) {
        int[] lista = new int[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            lista[i] = random.nextInt(1000); //Rango
        }
        return lista;
    }

    public static void main(String[] args) {
        //Crear las listas A y B
        int[] listaA = generarListaAleatoria(100);
        int[] listaB = generarListaAleatoria(60);

        //Ordenar las listas A y B con Quicksort
        quicksort(listaA, 0, listaA.length - 1);
        quicksort(listaB, 0, listaB.length - 1);

        //Crear la lista C por intercalación o mezcla de las listas A y B
        int[] listaC = merge(listaA, listaB);

        //Visualizar la lista C ordenada
        System.out.println("Lista A ordenada: " + Arrays.toString(listaA));
        System.out.println("Lista B ordenada: " + Arrays.toString(listaB));
        System.out.println("Lista C ordenada: " + Arrays.toString(listaC));
    }
}