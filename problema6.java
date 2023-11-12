/*Un método de ordenación muy simple, pero no muy eficiente, de elementos x1, x2,
x3,...xn en orden ascendente es el siguiente:
Paso 1: Localizar el elemento más pequeño de la lista x1 a xn; intercambiarlo con x1.
Paso 2: Localizar el elemento más pequeño de la lista x2 a xn, intercambiarlo con x2.
Paso 3: Localizar el elemento más pequeño de la lista x3 a xn, intercambiarlo con xn.
En el último paso, los dos últimos elementos se comparan e intercambian, si es neecesario, y la ordenación se termina.
Escribir un programa para ordenar una lista de elementos, siguiendo este método.*/

import java.util.Arrays;

public class problema6 {

    //Metodo Seleccion
    public static void ordenarSeleccion(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[min] > lista[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int aux = lista[i];
                lista[i] = lista[min];
                lista[min] = aux;
            }
        }
    }
    public static void main(String[] args) {
        int [] lista = {8,4,6,2};
        System.out.println("Lista original: " + Arrays.toString(lista));
        ordenarSeleccion(lista);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }

}