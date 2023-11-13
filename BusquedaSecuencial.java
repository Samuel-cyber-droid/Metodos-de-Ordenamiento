public class BusquedaSecuencial {
    //Metodo para buscar un elemento en un arreglo
    public static int buscar(int[] arreglo, int elemento){
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == elemento){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {4, 2, 5, 3, 12, 16, 38, 28};
        int elemento = 16;

        int posicion = buscar(arreglo, elemento);

        if (posicion == -1) 
            System.out.println("El valor: " + elemento + " no esta en el arreglo");
        else
            System.out.println("El valor " + elemento + " si esta en el arreglo");
    }
}
