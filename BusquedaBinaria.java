public class BusquedaBinaria {
    //Metodo para busqueda binaria
    static int busquedaBinaria(int[] arreglo, int valor){
        int inicio = 0, fin = arreglo.length - 1;
        
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            //Verificamos si el valor es igual al valor del medio
            if (arreglo[medio] == valor) 
                return medio;

            //Si el valos buscado es mayor , ignora el lado izquierdo
            if (arreglo[medio] < valor)
                inicio = medio + 1;
            
            //Si el valor buscado es menor, ignora el lado derecho
            else
                fin = medio - 1;
        
        }
        //Si el valor no se encuentra en el arreglo
        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 5, 8, 12, 16, 23, 38, 42, 50};
        int valor = 16;
        
        int resultado = busquedaBinaria(arreglo, valor);

        if(resultado == -1)
            System.out.println("El valor " + valor + " no esta en el arreglo");
        else
            System.out.println("El valor " + valor + " si esta en el arreglo");
    }
}
