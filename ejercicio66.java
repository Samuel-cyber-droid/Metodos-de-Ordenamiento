/*Un array contiene los elementos indicados más abajo. Utilizando el algoritmo de
ordenación Shell, encuentre las pasadas y los intercambios que se realizan para su
ordenación.
8	 	 43	 	 17	 	 6	 	 40	 	 16	 	 18	 	 97	 	 11	 	 7 */

public class ejercicio66 {
    public static void main(String[] args) {
        int[] array = {8, 43, 17, 6, 40, 16, 18, 97, 11, 7};
        shellSort(array);
    }

    public static void shellSort(int[] array) {
        int n = array.length;

        //Inicializar el gap
        for(int gap = n / 2; gap > 0 ; gap /= 2){
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    //Realizar intercambios
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            //Mostrar los intercambios
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
