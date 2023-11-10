import java.util.Scanner;

public class ordenacion {

    // Función para intercambiar dos elementos en un arreglo
    public static void intercambiar(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    // Función de ordenacion para intercambio
    public static void ordIntercambio(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            // Bucle externo para recorrer el arreglo
            // Sitúa el mínimo de a[i+1]...a[n-1] en a[i]
            for (int j = i + 1; j < n; j++) {
                
                // Bucle interno para comparar elementos
                if (a[i] > a[j]) {
                    
                    // Intercambia elementos si están en el orden incorrecto
                    intercambiar(a, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Crear un arreglo de enteros con 10 elementos
        int[] k = new int[10];
        try (Scanner leer = new Scanner(System.in)) {
            // Leer 10 valores enteros desde el usuario y almanecarlos en el arreglo
            for (int i = 0; i < 10; i++) {
                System.out.print("Valor " + i + ": ");
                k[i] = leer.nextInt();
            }
        }

        // Llamar a la función de ordenación por intercambio para ordenar el arreglo
        ordIntercambio(k);

        System.out.println("Arreglo ordenado:");

        // Imprimir el arreglo ordenado
        for (int i = 0; i < 10; i++) {
            System.out.println("Valor " + i + ": " + k[i]);
        }
    }
}
