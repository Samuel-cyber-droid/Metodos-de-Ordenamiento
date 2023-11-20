/*Escribir una función de búsqueda binaria aplicado a un array ordenado
descendentemente */

public class ejercicio611 {

    public static int binarySearchDescending(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1; // Si el valor está en la mitad izquierda
            } else {
                left = mid + 1; // Si el valor está en la mitad derecha
            }
        }

        return -1; // Si no se encuentra el elemento
    }

    public static void main(String[] args) {
        int[] array = { 20, 15, 10, 7, 5, 3, 1 };
        int target = 7;
        int index = binarySearchDescending(array, target);
        if (index != -1) {
            System.out.println("El elemento " + target + " está en la posición: " + index);
        } else {
            System.out.println("El elemento " + target + " no está en el array.");
        }
    }
}
