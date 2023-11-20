/*Partiendo del mismo array que en el Ejercicio 6.6, encuentre las particiones e 
intercambios que realiza el algoritmo de ordenación Quicksort para su ordenación */

public class ejercicio67 {
    public static void main(String[] args) {
        int[] array = {8, 43, 17, 6, 40, 16, 18, 97, 11, 7};
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int particionIndex = particion(array, low, high);

            //Mostrar el array después de la partición
            printArray(array);

            quickSort(array, low, particionIndex - 1);
            quickSort(array, particionIndex + 1, high);
        }
    }

    public static int particion(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                //Intercambio array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //Intercambio array[i + 1] y array[high]
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
