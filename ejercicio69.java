/*Un array contiene los elementos indicados más abajo. Utilizando el algoritmo de
búsqueda binaria, trazar las etapas necesarias para encontrar el número 88.
8	 	 13	 	 17	 	 26	 	 44	 	 56	 	 88	 	 97
Hacer la misma búsqueda pero para el número 20. */

public class ejercicio69 {
    public static void main(String[] args) {
        int[] array = {8, 13, 17, 26, 44, 56, 88, 97};

        int target1 = 88;
        int target2 = 20;

        int resultadoIndex = BusquedaBinaria(array, target1);
        if (resultadoIndex != -1) {
            System.out.println("El número " + target1 + " se encuentra en la posición " + resultadoIndex);
        } else {
            System.out.println("El número " + target1 + " no se encontró en el array");
        }

        int resultadoIndex2 = BusquedaBinaria(array, target2);
        if (resultadoIndex2 != -1) {
            System.out.println("El número " + target2 + " se encontró en la posición " + resultadoIndex2);
        } else {
            System.out.println("El número " + target2 + " no se encontró en el array");
        }
    }

    //Metodo de busqueda binaria
    public static int BusquedaBinaria(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid;//Se encontro el elemento
            } else if (array[mid] < target) {
                low = mid + 1;//Descarta la mitad izquierda
            } else {
                high = mid - 1;//Descarta la mitad derecha
            }
        }
        return -1;//El elemento no se encontro
    }
}
