package recursividad.interfazGrafica.Ordenacion;

import java.util.Arrays;

public class shell {
    // Método para ordenar array[] de acuerdo al algoritmo de ShellSort
    void sort(int array[]) {
        int n = array.length;

        // Comienza con un intervalo granded, luego reduce el intervalo
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Hacer una pasada de gap
            for (int i = gap; i < n; i += 1) {
                // Aquí, array[i] es el elemento actual. Guardamos este valor en temp
                // para poder mover los elementos que son mayores que temp a una posición adelante
                int temp = array[i];

                // Cambia los elementos anteriores mayores que temp a una posición adelante
                // de su posición actual
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Después de mover los elementos mayores que temp a una posición adelante,
                // colocamos temp (el elemento original array[i]) en su posición correcta
                array[j] = temp;
            }
        }
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        // Crea un array de datos
        int[] data = {8, 43, 17, 6, 40, 16, 18, 97, 11, 7};
        // Crea una instancia de ShellSort
        shell ss = new shell();
        // Ordena los datos utilizando ShellSort
        ss.sort(data);
        // Imprime los datos ordenados
        System.out.println(Arrays.toString(data));
    }
}
