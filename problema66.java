/*Se dispone de dos vectores, Maestro y Esclavo, del mismo tipo y número de elementos. Se deben imprimir en dos columnas adyacentes. Se ordena el vector Maestro,
pero siempre que un elemento de Maestro se mueva, el elemento correspondiente
de Esclavo debe moverse también; es decir, cualquier cosa que se haga a Maestro[i]
debe hacerse a Esclavo[i]. Después de realizar la ordenación, se imprimen de nuevo
los vectores. Escribir un programa que realice esta tarea.
Nota: utilizar como algoritmo de ordenación el método Quicksort*/

public class problema66 {

    //Metodo de 
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