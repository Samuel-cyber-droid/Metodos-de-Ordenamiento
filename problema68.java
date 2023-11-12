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

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class problema68 {

    //Metodo para generar lista de numeros reales aleatorios
    public static double[] generarLista() {
        double[] lista = new double[999];
        Random random = new Random();
        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextDouble() * 2000; //numeros aleatorios entre 0 y 2000
        }
        return lista;
    }

    //Metodo para imprimir lista
    public static void imprimirLista(double[] lista) {
        for (double elemento : lista) {
            System.out.println(elemento + " ");
        }
        System.out.println();
    }

    //Metodo para ordenar lista por el metodo burbuja
    public static void ordenarBurbuja(double[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    //Intercambiar elementos si estan desordenados
                    double temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    //Ordenacion por el metodo Shell
    public static void ordenarShell(double[] lista) {
        int n = lista.length;
        for (int brecha = n / 2; brecha > 0; brecha /= 2){
            for (int i = brecha; i < n; i++){
                double temp = lista[i];
                int j;
                for (j = i; j >= brecha && temp < lista[j - brecha]; j -= brecha){
                    lista[j] = lista[j - brecha];
                }
                lista[j] = temp;
            }
        }
    }

    //Ordenacion por el metodo Radixsort
    public static void ordenarRadixsort(double[] lista) {
        //Convertir la lista de double a int para usar Radixsort
        int[] listaInt = new int[lista.length];
        for (int i = 0; i < lista.length; i++) {
            listaInt[i] = (int) lista[i];
        }

        //Encontrar el número máximo 
        int max = Arrays.stream(listaInt).max().getAsInt();
        int dig = contarDigitos(max);

        //Aplicamos Radixsort
        for (int digito = 1; digito <= dig; digito++){
            listaInt = contarSort(listaInt, digito);
        }

        //Convertir la lista de int a double para mostrar en pantalla
        for (int i = 0; i < lista.length; i++) {
            lista[i] = listaInt[i];
        }
    }

    //Metodo para contar el número de digitos en un número
    public static int contarDigitos(int numero) {
        int cont = 0;
        while (numero != 0) {
            numero /= 10;
            cont++;
        }
        return cont;
    }

    public static int[] contarSort(int[] lista, int digito) {
        int n = lista.length;
        int[] salida = new int[n];
        int[] contador = new int[10];

        Arrays.fill(contador, 0);

        for (int i = 0; i < n; i++) {
            contador[(lista[i] / digito) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }

        for (int i = n -1; i >= 0; i--){
            salida[contador[(lista[i] / digito) % 10] - 1] = lista[i];
            contador[(lista[i] / digito) % 10]--;
        }

        for (int i = 0; i < n; i++){
            lista[i] = salida[i];
        }
        return lista;
    }

    //Metodo para busqueda binaria
    public static int busquedaBinaria(double[] lista, double x) {
        int izq = 0;
        int der = lista.length - 1;

        while (izq <= der) {
            int medio = izq + (der - izq) / 2;
            if (lista[medio] == x) {
                return medio; //Elemento encontrado
            } else if (lista[medio] < x) {
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }
        return -1; //Elemento no encontrado
    }

    //Metodo para ordenar lista inversamente
    public static void ordenarInversamente(double[] lista) {
        int izq = 0;
        int der = lista.length - 1;

        while (izq < der) {
            double temp = lista[izq];
            lista[izq] = lista[der];
            lista[der] = temp;
            
            izq++;
            der--;
        
        }
    }

    public static void main(String[] args) {
        //Generar lista de 999 numeros reales aleatorios en el rango de 0 a 2000
        double[] lista = generarLista();

        //Imprimir lista original
        System.out.println("Lista Original: ");
        imprimirLista(lista);

        //Copiar la lista originar para usar en los calculo de tiempo
        double[] listaCopia = Arrays.copyOf(lista, lista.length);

        //Medir timepo de ordenacion por el metodo burbuja
        long inicioBurbuja = System.nanoTime();
        ordenarBurbuja(listaCopia);
        long finBurbuja = System.nanoTime();
        long tiempoBurbuja = finBurbuja - inicioBurbuja;

        //Medir tiempo de ordenacion por el método Shell
        listaCopia = Arrays.copyOf(lista, lista.length); //Restauracion de lista
        long inicioShell = System.nanoTime();
        ordenarShell(listaCopia);
        long finShell = System.nanoTime();
        long tiempoShell = finShell - inicioShell;

        //Pedir un numero a buscar en la lista (Busqueda Binaria)
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Ingresa el número a buscar: ");
            double x = sc.nextDouble();

            //Medir tiempo de busqueda binaria
            listaCopia = Arrays.copyOf(lista, lista.length); //Restauracion de lista
            long tiempoInicioBusqueda = System.nanoTime();
            int indice = busquedaBinaria(listaCopia, x);
            long tiempoFinBusqueda = System.nanoTime();
            long tiempoBusqueda = tiempoFinBusqueda - tiempoInicioBusqueda;

            //Imprimir lista binaria
            if (indice != -1) {
                System.out.println("El número " + x + " fue encontrado en la posicion " + indice);
            } else {
                System.out.println("El numero: " + x + " no fue encontrado en la lista");
            }

            //Medir tiempo de ordenacion de lista ya ordenada
            Arrays.sort(listaCopia);
            long timepoInicioOrdenada = System.nanoTime();
            Arrays.sort(listaCopia);
            long timepoFinOrdenada = System.nanoTime();
            long tiempoOrdenada = timepoFinOrdenada - timepoInicioOrdenada;

            //Medir tiempo de ordenacion de lista ordenada en orden inverso
            listaCopia = Arrays.copyOf(lista, lista.length); //Restauracion de lista
            Arrays.sort(listaCopia);
            ordenarInversamente(listaCopia);
            long timepoInicioOrdenInverso = System.nanoTime();
            Arrays.sort(listaCopia);
            long timepoFinOrdenInverso = System.nanoTime();
            long tiempoOrdenInverso = timepoFinOrdenInverso - timepoInicioOrdenInverso;

            //Imprimir resultados de tiempos
            System.out.println("\nTiempos: ");
            System.out.println("t1. Tiempo de ordenacion de burbuja: " + tiempoBurbuja + "nanosegundos");
            System.out.println("t2. Tiempo de ordenacion de lista ya ordenada: " + tiempoOrdenada + "nanosegundos");
            System.out.println("t3. Tiempo de ordenacion de lista ordenada en orden inverso: " + tiempoOrdenInverso + "nanosegundos");
            System.out.println("t4. Tiempo de busqueda binaria: " + tiempoBusqueda + "nanosegundos");
        }
        System.out.println("t5. Tiempo de ordenacion de shell: " + tiempoShell + "nanosegundos");    
    }
}