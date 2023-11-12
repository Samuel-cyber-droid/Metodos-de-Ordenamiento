/*Escribir un programa que genere un vector de 10.000 números aleatorios del 1 al 500.
Realizar la ordenación del vector por dos métodos:
•	 Binsort.
•	 Radixsort.
Escriba el tiempo empleado en la ordenación de cada método.*/

public class problema610{

    //Metodo de ordenacion Binsort
    public static void binsort(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    int aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }
    }

    //Metodo de ordenacion Radixsort
    public static void radixsort(int[] vector) {
        int n = vector.length;
        int max = vector[0];
        for (int i = 1; i < n; i++) {   
            if (vector[i] > max) {
                max = vector[i];
            }
        }

        int exp = 1;
        while (max / exp > 0) {
            bucketSort(vector, exp);
            exp *= 10;
        }
    }

    //Metodos de ordenacion bucketSort
    public static void bucketSort(int[] vector, int exp) {
        int[] buckets = new int[10];

        for(int i = 0; i < vector.length; i++){
            buckets[(vector[i] / exp) % 10]++;
        }

        int i = 0;
        for(int j = 0; j < buckets.length; j++){
            for(int k = 0; k < buckets[j]; k++){
                vector[i++] = (j * exp) + k;
            }
        }
    }

    public static void main(String[] args) {
        //Generamos un vector de 10000 números aleatorios del 1 al 500
        int[] vector = new int[10000];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 500) + 1;
        }

        //Ordenamos los vectores por Binsort
        long tiempoInicial = System.currentTimeMillis();
        binsort(vector);
        long tiempoFinal = System.currentTimeMillis();

        //Ordenamos los vectores por Radixsort
        long tiempoInicial2 = System.currentTimeMillis();
        radixsort(vector);
        long tiempoFinal2 = System.currentTimeMillis();

        //Imprimir los tiempos de ordenacion
        System.out.println("Tiempo de ordenacion de Binsort: " + (tiempoFinal - tiempoInicial) + " milisegundos");
        System.out.println("Tiempo de ordenacion por Radixsort: " + (tiempoFinal2 - tiempoInicial2) + " milisegundos");
    }
}