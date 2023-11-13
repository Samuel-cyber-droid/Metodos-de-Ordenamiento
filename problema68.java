/*Se desea realizar un programa que realice las siguientes tareas:
a) Generar, aleatoriamente, una lista de 999 de números reales en el rango de 0 a
2000.
b)	 Ordenar en modo creciente por el método de la burbuja.
c)	 Ordenar en modo creciente por el método Shell.
d)	 Ordenar en modo creciente por el método Radixsort.
e)	 Buscar si existe el número x (leído del teclado) en la lista. La búsqueda debe ser
binaria.
Ampliar el programa anterior de modo que pueda obtener y visualizar en el programa
principal los siguientes tiempos:
t1.	 Tiempo empleado en ordenar la lista por cada uno de los métodos.
t2.	Tiempo que se emplearía en ordenar la lista ya ordenada.
t3.	 Tiempo empleado en ordenar la lista ordenada en orden inverso.*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class problema68 {
    public static void main(String[] args) {
        // a) Generar lista de números aleatorios
        double[] lista = generarLista();
        System.out.println("Lista generada: " + Arrays.toString(lista));

        // b) Medir el tiempo empleado en ordenar por el método de la burbuja
        long startTimeBurbuja = System.currentTimeMillis();
        ordenarBurbuja(lista.clone());
        long endTimeBurbuja = System.currentTimeMillis();
        long tiempoBurbuja = endTimeBurbuja - startTimeBurbuja;
        System.out.println("Tiempo empleado en ordenar por el método de la burbuja: " + tiempoBurbuja + " milisegundos");

        // c) Medir el tiempo empleado en ordenar por el método Shell
        long startTimeShell = System.currentTimeMillis();
        ordenarShell(lista.clone());
        long endTimeShell = System.currentTimeMillis();
        long tiempoShell = endTimeShell - startTimeShell;
        System.out.println("Tiempo empleado en ordenar por el método Shell: " + tiempoShell + " milisegundos");

        // d) Medir el tiempo empleado en ordenar por el método Radixsort
        long startTimeRadixSort = System.currentTimeMillis();
        ordenarRadixSort(lista.clone());
        long endTimeRadixSort = System.currentTimeMillis();
        long tiempoRadixSort = endTimeRadixSort - startTimeRadixSort;
        System.out.println("Tiempo empleado en ordenar por el método Radixsort: " + tiempoRadixSort + " milisegundos");

        // e) Medir el tiempo que se emplearía en ordenar la lista ya ordenada
        Arrays.sort(lista);
        long startTimeOrdenada = System.currentTimeMillis();
        Arrays.sort(lista);
        long endTimeOrdenada = System.currentTimeMillis();
        long tiempoOrdenada = endTimeOrdenada - startTimeOrdenada;
        System.out.println("Tiempo empleado en ordenar la lista ya ordenada: " + tiempoOrdenada + " milisegundos");

        // f) Medir el tiempo empleado en ordenar la lista ordenada en orden inverso
        Arrays.sort(lista);
        double[] listaInversa = new double[lista.length];
        for (int i = 0, j = lista.length - 1; i < lista.length; i++, j--) {
            listaInversa[i] = lista[j];
        }
        long startTimeInversa = System.currentTimeMillis();
        Arrays.sort(listaInversa);
        long endTimeInversa = System.currentTimeMillis();
        long tiempoInversa = endTimeInversa - startTimeInversa;
        System.out.println("Tiempo empleado en ordenar la lista ordenada en orden inverso: " + tiempoInversa + " milisegundos");

        // g) Buscar un número x en la lista utilizando búsqueda binaria y medir el tiempo
        buscarNumero(lista.clone());
    }

    // Generar lista de números aleatorios
    private static double[] generarLista() {
        double[] lista = new double[999];
        Random random = new Random();

        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextDouble() * 2000;
        }

        return lista;
    }

    // Ordenar por el método de la burbuja
    private static void ordenarBurbuja(double[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    double temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    // Ordenar por el método Shell
    private static void ordenarShell(double[] lista) {
        int n = lista.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                double temp = lista[i];
                int j;
                for (j = i; j >= gap && lista[j - gap] > temp; j -= gap) {
                    lista[j] = lista[j - gap];
                }
                lista[j] = temp;
            }
        }
    }

    // Ordenar por el método Radixsort
    private static void ordenarRadixSort(double[] lista) {
        int n = lista.length;
        double max = Arrays.stream(lista).max().getAsDouble();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(lista, n, exp);
        }
    }

    private static void countingSort(double[] lista, int n, int exp) {
        double output[] = new double[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(int) (lista[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(int) (lista[i] / exp) % 10] - 1] = lista[i];
            count[(int) (lista[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            lista[i] = output[i];
        }
    }

    // Buscar un número x en la lista utilizando búsqueda binaria
    private static void buscarNumero(double[] lista) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el número a buscar en la lista: ");
            double numeroBuscar = scanner.nextDouble();

            Arrays.sort(lista); // Asegurarse de que la lista está ordenada para la búsqueda binaria

            long startTimeBusqueda = System.currentTimeMillis();
            int resultado = binarySearch(lista, numeroBuscar);
            long endTimeBusqueda = System.currentTimeMillis();
            long tiempoBusqueda = endTimeBusqueda - startTimeBusqueda;

            if (resultado >= 0) {
                System.out.println("El número " + numeroBuscar + " está en la lista en la posición " + resultado + ".");
            } else {
                System.out.println("El número " + numeroBuscar + " no está en la lista.");
            }

            System.out.println("Tiempo empleado en la búsqueda binaria: " + tiempoBusqueda + " milisegundos");
        }
    }

    private static int binarySearch(double[] arr, double x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
