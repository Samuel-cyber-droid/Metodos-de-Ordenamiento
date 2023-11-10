public class intercambio {

    public static void intercambiar(int []a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void ordIntercambio (int a[]){
        int i , j;
        for (i = 0; i < a.length-1; i++) {
            for(j = i + 1; j < a.length; j++){
                if (a[i] > a[j]) {
                    intercambiar(a, i, j);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int k[] = {8,4,6,2};

        System.out.println("Arreglo Original: ");
        for (int i = 0; i < k.length; i++) {
            System.out.println("Valor: "  + k[i]);
        }
        
        ordIntercambio(k);
        System.out.println("Arreglo Ordenado: ");

        for (int i = 0; i < k.length; i++) {
            System.out.println("Valor " + i + ": " + k[i]);
        }
    }
}
