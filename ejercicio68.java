/*Un array de registros se quiere ordenar según el campo clave fecha de nacimiento.
Dicho campo consta de tres subcampos: día, mes y año, de 2, 2 y 4 dígitos respectivamente. 
Adaptar el método de ordenación Radixsort a esta ordenación.*/

class Registro{
    int dia;
    int mes;
    int anio;
    
    public Registro(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
}

public class ejercicio68 {
    public static void main(String[] args) {
        Registro[] registros = {
            new Registro(14, 2, 1990),
            new Registro(8, 5, 1985),
            new Registro(3, 12, 2000),
        };

        radixSort(registros);

        //Imprimit los registros ordenados
        for (Registro registro : registros) {
            System.out.println(registro.dia + "/" + registro.mes + "/" + registro.anio);
        }
    }

    //Metodo para ordenar el array de registros por fecha de nacimiento
    public static void radixSort(Registro[] array) {
        //Ordenar por campo año, luego por mes y por día
        countingSort(array, 10000, 100, 31);
        countingSort(array, 100, 31, 13);
        countingSort(array, 1, 13, 32);
    }

    //Metodo para ordenamiento de conteo para un digito especifico
    public static void countingSort(Registro[] array, int exp, int range, int divisor) {
        Registro[] output = new Registro[array.length];
        int [] count = new int[range];

        //Contar los elementos del array
        for (Registro registro : array){
            count[((registro.anio / exp) % divisor)]++;
        }

        //Actualizar el array de conteo para reflejar la posicion actual
        for (int i = 1; i < range; i++){
            count[i] += count[i - 1];
        }

        //Construir el array ordenado
        for (int i = array.length - 1; i >= 0; i--){
            output[count[((array[i].anio / exp) % divisor)] - 1] = array[i];
            count[((array[i].anio / exp) % divisor)]--;
        }

        //Copiar el array ordenado al array original
        System.arraycopy(output, 0, array, 0, array.length);
    }
}   
