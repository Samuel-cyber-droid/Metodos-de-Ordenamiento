public class Ordenacioninsercion {

   
    public static void main(String[] args) {
        // Crear un arreglo desordenado
        int[] array = {5, 2, 9, 1, 5, 6};

        // Llamar al método de ordenación por inserción
        ordInsercion(array);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int element : array) {
            System.out.println(element);
        }
    }

    // Método para ordenar un arreglo por inserción
    public static void ordInsercion(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int aux = a[i];  // Almacena el elemento a[i] que se insertará en la posición correcta

            // Mientras j sea mayor que 0 y el elemento aux sea menor que el elemento anterior, desplaza el elemento anterior hacia arriba
            while (j > 0 && aux < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }

            // Coloca el elemento aux en la posición correcta
            a[j] = aux;
        }
    }
}
