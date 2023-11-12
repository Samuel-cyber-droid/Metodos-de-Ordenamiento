/*Se dispone de dos vectores, Maestro y Esclavo, del mismo tipo y número de elementos. Se deben imprimir en dos columnas adyacentes. Se ordena el vector Maestro,
pero siempre que un elemento de Maestro se mueva, el elemento correspondiente
de Esclavo debe moverse también; es decir, cualquier cosa que se haga a Maestro[i]
debe hacerse a Esclavo[i]. Después de realizar la ordenación, se imprimen de nuevo
los vectores. Escribir un programa que realice esta tarea.
Nota: utilizar como algoritmo de ordenación el método Quicksort*/

public class problema66 {

    //Metodo de quicksort con vector esclavo
    public static void quicksortConEsclavo(int[] maestro, int[] esclavo, int izq, int der) {
        if (izq < der) {
            int indiceParticion = particion(maestro, esclavo, izq, der);
            
            quicksortConEsclavo(maestro, esclavo, izq, indiceParticion - 1);
            quicksortConEsclavo(maestro, esclavo, indiceParticion + 1, der);
        }
    }

    //Metodo de particion con vector esclavo
    public static int particion(int[] maestro, int[] esclavo, int izq, int der) {
        int pivote = maestro[der];
        int i = (izq - 1);

        for (int j = izq; j < der; j++) {
            if (maestro[j] <= pivote) {
                i++;
                intercambiar(maestro, i, j);
                intercambiar(esclavo, i, j);
            }
        }

        intercambiar(maestro, i + 1, der);
        intercambiar(esclavo, i + 1, der);

        return i + 1;
    
    }

    //Metodo de intercambio
    public static void intercambiar(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }

    //Metodo para imprimir los vectores
    public static void imprimirVectores(int[] maestro, int[] esclavo) {
        for (int i = 0; i < maestro.length; i++) {
            System.out.println(maestro[i] + "\t" + esclavo[i]);
        }
    }

    public static void main(String[] args) {
        //Definir y llamar los vectores Maestro Y Esclavo
        int[] maestro = {5, 2, 8, 1, 7, 2};
        int[] esclavo = {5, 2, 8, 1, 7, 3};

        //Imprimir los vectores originales
        System.out.println("Vectores originales: ");
        imprimirVectores(maestro, esclavo);

        //Ordenar el vector Maestro y replicar los cambios en el vector Esclavo
        quicksortConEsclavo(maestro, esclavo, 0, maestro.length - 1);

        //Imprimir los vectores ordenados
        System.out.println("\nVectores despues de la ordenacion: ");
        imprimirVectores(maestro, esclavo);
    }
}