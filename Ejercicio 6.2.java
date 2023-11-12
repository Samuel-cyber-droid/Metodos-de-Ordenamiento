package 6.2;
/*Se desea eliminar todos los números duplicados de una lista o vector (array).
Por ejemplo, si el array toma los valores
4 7 11 4 9 5 11 7 3 5
ha de cambiarse a
4 7 11 9 5 3*/

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 6.2 {
    public static void main(String[] args) {
        // Array original con duplicados
        int[] array = {4, 7, 11, 4, 9, 5, 11, 7, 3, 5};

        // Imprimir el array original
        System.out.println("Array original:");
        imprimirArray(array);

        // Llamar al método eliminarDuplicados para obtener un nuevo array sin duplicados
        int[] arraySinDuplicados = eliminarDuplicados(array);

        // Imprimir el array sin duplicados
        System.out.println("\nArray sin duplicados:");
        imprimirArray(arraySinDuplicados);
    }

    // Método para eliminar duplicados mientras se conserva el orden
    static int[] eliminarDuplicados(int[] array) {
        // Utilizar un LinkedHashSet para mantener el orden de inserción y eliminar duplicados
        Set<Integer> conjunto = new LinkedHashSet<>();

        // Agregar elementos del array al conjunto (se eliminarán automáticamente los duplicados)
        for (int elemento : array) {
            conjunto.add(elemento);
        }

        // Convertir el conjunto a un array de enteros
        int[] arraySinDuplicados = conjunto.stream().mapToInt(Integer::intValue).toArray();

        // Devolver el array resultante sin duplicados
        return arraySinDuplicados;
    }

    // Método para imprimir un array
    static void imprimirArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

/*no utiliza un metodo de ordenacion por elhecho de que guarda el orden inicial,
solo elimina numeros repetidos*/
