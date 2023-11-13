/*Construir un método que permita ordenar por fechas y de mayor a menor un vector
de n elementos que contiene datos de contratos (n <= 50). Cada elemento del vector
debe ser un objeto con los campos día, mes, año y número de contrato. Pueden existir
diversos contratos con la misma fecha, pero no números de contrato repetidos.
Nota. El método a utilizar para ordenar será el de Radixsort.*/

import java.util.Arrays;

class Contrato {
    int dia;
    int mes;
    int anio;
    String numeroContrato;

    public Contrato(int dia, int mes, int anio, String numeroContrato) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.numeroContrato = numeroContrato;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", numeroContrato='" + numeroContrato + '\'' +
                '}';
    }
}

public class problema69 {
    public static void main(String[] args) {
        // Ejemplo de uso
        Contrato[] contratos = {
                new Contrato(10, 5, 2022, "C001"),
                new Contrato(15, 3, 2021, "C002"),
                new Contrato(5, 7, 2022, "C003"),
                // Agrega más contratos según sea necesario
        };

        System.out.println("Contratos sin ordenar:");
        imprimirContratos(contratos);

        // Ordenar por fechas de mayor a menor usando Radixsort
        ordenarContratosPorFecha(contratos);

        System.out.println("\nContratos ordenados por fecha (de mayor a menor):");
        imprimirContratos(contratos);
    }

    // Método para ordenar contratos por fechas usando Radixsort
    private static void ordenarContratosPorFecha(Contrato[] contratos) {
        int n = contratos.length;
        Contrato[] output = new Contrato[n];

        // Obtener la fecha máxima para saber cuántos dígitos hay
        int maxFecha = obtenerMaximaFecha(contratos);

        // Aplicar el algoritmo Radixsort para cada posición de los dígitos de la fecha
        for (int exp = 1; maxFecha / exp > 0; exp *= 10) {
            countingSortPorFecha(contratos, n, exp, output);
            // Copiar el arreglo ordenado de vuelta a contratos
            System.arraycopy(output, 0, contratos, 0, n);
        }
    }

    // Método auxiliar para obtener la máxima fecha en el arreglo de contratos
    private static int obtenerMaximaFecha(Contrato[] contratos) {
        int maxFecha = Integer.MIN_VALUE;
        for (Contrato contrato : contratos) {
            int fecha = contrato.anio * 10000 + contrato.mes * 100 + contrato.dia;
            if (fecha > maxFecha) {
                maxFecha = fecha;
            }
        }
        return maxFecha;
    }

    // Método auxiliar para realizar el Counting Sort por la posición de los dígitos de la fecha
    private static void countingSortPorFecha(Contrato[] contratos, int n, int exp, Contrato[] output) {
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Contar la frecuencia de los dígitos en la posición actual
        for (int i = 0; i < n; i++) {
            int index = (contratos[i].anio * 10000 + contratos[i].mes * 100 + contratos[i].dia) / exp % 10;
            count[index]++;
        }

        // Calcular las posiciones actuales de los dígitos
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            int index = (contratos[i].anio * 10000 + contratos[i].mes * 100 + contratos[i].dia) / exp % 10;
            output[count[index] - 1] = contratos[i];
            count[index]--;
        }
    }

    // Método auxiliar para imprimir el arreglo de contratos
    private static void imprimirContratos(Contrato[] contratos) {
        for (Contrato contrato : contratos) {
            System.out.println(contrato);
        }
    }
}
