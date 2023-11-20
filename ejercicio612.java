/*Supongamos que se tiene una secuencia de n números que deben ser clasificados:
1. Utilizando el método de Shell, ¿cuántas comparaciones y cuántos intercambios se
requieren para clasificar la secuencia si
• ya está clasificado?
• está en orden inverso?
2. Repetir el paso 1 para el método de Quicksort. */

import java.util.Arrays;

public class ejercicio612 {

    // Método de Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    // Método de Quicksort
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
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

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        int[] reverseSortedArray = {7, 6, 5, 4, 3, 2, 1};

        // Para el método de Shell Sort
        int[] sortedArrayCopy = Arrays.copyOf(sortedArray, sortedArray.length);
        shellSort(sortedArrayCopy);
        int comparisonsSortedShell = sortedArray.length * (int) (Math.log(sortedArray.length) / Math.log(2));
        int exchangesSortedShell = 0;

        int[] reverseSortedArrayCopy = Arrays.copyOf(reverseSortedArray, reverseSortedArray.length);
        shellSort(reverseSortedArrayCopy);
        int comparisonsReverseSortedShell = reverseSortedArray.length * (int) (Math.log(reverseSortedArray.length) / Math.log(2));
        int exchangesReverseSortedShell = 0;

        // Para el método de Quicksort
        int[] sortedArrayCopy2 = Arrays.copyOf(sortedArray, sortedArray.length);
        quicksort(sortedArrayCopy2, 0, sortedArray.length - 1);
        int comparisonsSortedQuick = sortedArray.length * (int) (Math.log(sortedArray.length) / Math.log(2));
        int exchangesSortedQuick = sortedArray.length - 1;

        int[] reverseSortedArrayCopy2 = Arrays.copyOf(reverseSortedArray, reverseSortedArray.length);
        quicksort(reverseSortedArrayCopy2, 0, reverseSortedArray.length - 1);
        int comparisonsReverseSortedQuick = (int) (Math.pow(reverseSortedArray.length, 2));
        int exchangesReverseSortedQuick = (int) (0.5 * Math.pow(reverseSortedArray.length, 2));

        // Resultados para Shell Sort
        System.out.println("Para Shell Sort:");
        System.out.println("Secuencia ya ordenada - Comparaciones: " + comparisonsSortedShell + ", Intercambios: " + exchangesSortedShell);
        System.out.println("Secuencia en orden inverso - Comparaciones: " + comparisonsReverseSortedShell + ", Intercambios: " + exchangesReverseSortedShell);

        // Resultados para Quicksort
        System.out.println("\nPara Quicksort:");
        System.out.println("Secuencia ya ordenada - Comparaciones: " + comparisonsSortedQuick + ", Intercambios: " + exchangesSortedQuick);
        System.out.println("Secuencia en orden inverso - Comparaciones: " + comparisonsReverseSortedQuick + ", Intercambios: " + exchangesReverseSortedQuick);
    }
}

