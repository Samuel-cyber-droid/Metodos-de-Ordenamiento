package quicksort;

/**
 *
 * @author MASTER66
 */
public class Quicksort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejemplo
        double[] array = {5.2, 9.1, 2.5, 1.7, 5.9, 6.3};
        
        // Llamar al método de ordenación QuickSort
        quicksort(array);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (double element : array) {
            System.out.println(element);
        }
    }

    // Metodo de inicio para ordenar el arreglo utilizando QuickSort
    public static void quicksort(double[] a) {
        quicksort(a, 0, a.length - 1);
    }

    // Metodo recursivo para ordenar por QuickSort
    private static void quicksort(double[] a, int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = a[central];
        i = primero;
        j = ultimo;

        do {
            while (a[i] < pivote) i++;
            while (a[j] > pivote) j--;

            if (i <= j) {
                intercambiar(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j) {
            quicksort(a, primero, j); // mismo proceso con sublista izquierda
        }

        if (i < ultimo) {
            quicksort(a, i, ultimo); // mismo proceso con sublista derecha
        }
    }

    // Metodo para intercambiar elementos en el arreglo
    private static void intercambiar(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    }
