package 6.3;
/*Se desea eliminar todos los números duplicados de una lista o vector (array).
Por ejemplo, si el array toma los valores
4 7 11 4 9 5 11 7 3 5
ha de cambiarse a
4 7 11 9 5 3*/

import java.util.Arrays;

public class 6.3 {
    public static void main(String[] args) {
        int[] array = {4, 7, 11, 4, 9, 5, 11, 7, 3, 5};

        System.out.println("Array original:");
        imprimirArray(array);

        int[] arraySinDuplicados = eliminarDuplicados(array);

        System.out.println("\nArray sin duplicados:");
        imprimirArray(arraySinDuplicados);
    }

    static int[] eliminarDuplicados(int[] array) {
        int n = array.length;

        // Ordenar el array utilizando el algoritmo de ordenación burbuja
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // Intercambiar array[j] y array[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        // Eliminar duplicados mientras se mantiene el orden
        int[] resultado = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] != array[i + 1]) {
                resultado[j++] = array[i];
            }
        }

        // Añadir el último elemento
        resultado[j++] = array[n - 1];

        // Redimensionar el array resultante si es necesario
        return Arrays.copyOf(resultado, j);
    }

    static void imprimirArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

/*Ordenacion por buburja, en este caso es un metodo eficiente al resolver el problema
pero no mantiene el orden inicial ya que como se precisa es un metodo de oredenamiento,
ordena de manera ascendente y elima los elemntos repetidos. A comparacion con el 
ejercicio anterior es mejor ya que es menos complejo y al final muestra un orden y una
eliminacion*/
