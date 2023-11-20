/*Escribir la función de ordenación correspondiente al método Radixsort para poner en
orden alfabético una lista de n nombres. */

import java.util.Arrays;

public class ejercicio610 {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Eve", "David", "Carol", "Frank", "Grace"};

        System.out.println("Nombres sin ordenar:");
        System.out.println(Arrays.toString(names));

        radixSort(names);

        System.out.println("\nNombres ordenados:");
        System.out.println(Arrays.toString(names));
    }

    public static void radixSort(String[] arr) {
        final int RADIX = 256; // El alfabeto en ASCII tiene 256 caracteres

        int maxLength = getMaxStringLength(arr);

        for (int digit = maxLength - 1; digit >= 0; digit--) {
            String[] temp = new String[arr.length];
            int[] count = new int[RADIX]; // Aquí se cambia el tamaño del array count

            for (String s : arr) {
                int charIndex = digit < s.length() ? s.charAt(digit) : 0;
                count[charIndex]++;
            }

            for (int i = 1; i < RADIX; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int charIndex = digit < arr[i].length() ? arr[i].charAt(digit) : 0;
                temp[count[charIndex] - 1] = arr[i];
                count[charIndex]--;
            }

            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }

    public static int getMaxStringLength(String[] arr) {
        int max = 0;
        for (String s : arr) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}