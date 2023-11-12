/*Construir un método que permita ordenar por fechas y de mayor a menor un vector
de n elementos que contiene datos de contratos (n <= 50). Cada elemento del vector
debe ser un objeto con los campos día, mes, año y número de contrato. Pueden existir
diversos contratos con la misma fecha, pero no números de contrato repetidos.
Nota. El método a utilizar para ordenar será el de Radixsort.*/

import java.util.Arrays;

public class problema69 {
    int dia;
    int mes;
    int año;
    int numeroContrato;

    // Constructor y otros métodos de la clase Contrato

    public problema69(int i, int j, int k, int l) {
    }

    // Método para imprimir los datos del contrato (puedes personalizar según tus necesidades)
    public void imprimirContrato() {
        System.out.println("Contrato #" + numeroContrato + " - Fecha: " + dia + "/" + mes + "/" + año);
    }
}

class RadixSortContratos {

    // Función para obtener el dígito en la posición especificada
    private static int obtenerDigito(int numero, int posicion) {
        return (numero / posicion) % 10;
    }

    // Método principal para ordenar los contratos por fechas usando Radixsort
    public static void radixSortContratos(problema69[] contratos) {
        // Encontrar el contrato con la fecha máxima para determinar el número de dígitos
        int maxFecha = Arrays.stream(contratos)
                             .mapToInt(c -> c.año * 10000 + c.mes * 100 + c.dia)
                             .max()
                             .orElse(0);

        // Aplicar Radixsort para cada dígito (de las unidades a las decenas de miles)
        for (int posicion = 1; maxFecha / posicion > 0; posicion *= 10) {
            contarYSumarDígitos(contratos, posicion);
            aplicarConteoYSuma(contratos, posicion);
        }
    }

    // Método auxiliar para contar y sumar los dígitos en la posición especificada
    private static void contarYSumarDígitos(problema69[] contratos, int posicion) {
        int n = contratos.length;
        problema69[] salida = new problema69[n];
        int[] conteo = new int[10];

        // Contar la frecuencia de cada dígito en la posición actual
        for (problema69 contrato : contratos) {
            int digito = obtenerDigito(contrato.año * 10000 + contrato.mes * 100 + contrato.dia, posicion);
            conteo[digito]++;
        }

        // Sumar el conteo acumulado
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        // Construir la matriz de salida
        for (int i = n - 1; i >= 0; i--) {
            int digito = obtenerDigito(contratos[i].año * 10000 + contratos[i].mes * 100 + contratos[i].dia, posicion);
            salida[conteo[digito] - 1] = contratos[i];
            conteo[digito]--;
        }

        // Copiar la matriz de salida al arreglo original
        System.arraycopy(salida, 0, contratos, 0, n);
    }

    // Método auxiliar para aplicar el conteo y la suma a los contratos
    private static void aplicarConteoYSuma(problema69[] contratos, int posicion) {
        int n = contratos.length;
        problema69[] salida = new problema69[n];
        int[] conteo = new int[10];

        // Contar la frecuencia de cada dígito en la posición actual
        for (problema69 contrato : contratos) {
            int digito = obtenerDigito(contrato.año * 10000 + contrato.mes * 100 + contrato.dia, posicion);
            conteo[digito]++;
        }

        // Sumar el conteo acumulado
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        // Construir la matriz de salida (en orden inverso)
        for (int i = n - 1; i >= 0; i--) {
            int digito = obtenerDigito(contratos[i].año * 10000 + contratos[i].mes * 100 + contratos[i].dia, posicion);
            salida[conteo[digito] - 1] = contratos[i];
            conteo[digito]--;
        }

        // Copiar la matriz de salida al arreglo original
        System.arraycopy(salida, 0, contratos, 0, n);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        problema69[] contratos = {
                new problema69(1, 1, 2023, 101),
                new problema69(15, 6, 2022, 102),
                new problema69(5, 3, 2023, 103),
                // ... más contratos ...
        };

        System.out.println("Contratos sin ordenar:");
        for (problema69 contrato : contratos) {
            contrato.imprimirContrato();
        }

        // Ordenar los contratos por fechas usando Radixsort
        radixSortContratos(contratos);

        System.out.println("\nContratos ordenados por fechas (de mayor a menor):");
        for (problema69 contrato : contratos) {
            contrato.imprimirContrato();
        }
    }
}