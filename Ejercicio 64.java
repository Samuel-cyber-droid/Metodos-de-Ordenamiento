package 6.4;
/*Un vector contiene los elementos mostrados a continuación. Los primeros dos 
elementos se han ordenado utilizando un algoritmo de inserción. 
¿Cuál será el valor de los elementos del vector después de tres pasadas más del algoritmo?
3 13 8 25 45 23 98*/ 	 



public class 6.4 {
    public static void main(String[] args) {
        int[] arr = {3, 13, 8, 25, 45, 23, 98};
        insertionSort(arr);
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Mover los elementos del arreglo arr[0..i-1] que son mayores que key
            // a una posición adelante de su posición actual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

/*De acuerdo al orden que muestra el metodo queda 3, 8, 13, 23, 25, 45, 98
despues de que se hagan 3 vueltas y los ultimos numeros ya quedan ordenados por
default*/
