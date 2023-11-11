/*Se trata de resolver el siguiente problema escolar: dadas las notas de los alumnos
de un colegio en el primer curso de bachillerato en las diferentes asignaturas (5,
por comodidad), se trata de calcular la media de cada alumno, la media de cada
asignatura, la media total de la clase y ordenar los alumnos por orden decreciente
de notas medias individuales.
Nota: utilizar como algoritmo de ordenación el método Shell.*/

import java.util.Arrays;

public class problema63 {

    //Metodo para calcular las medias individuales de los alumnos
    public static double[] calcularMediasAlumnos(double[][] notas) {
        int numAlumnos = notas.length;
        double[] medias = new double[numAlumnos];

        for (int i = 0; i < numAlumnos; i++) {
            double suma = 0;
            for (double nota : notas[i]) {
                suma += nota;
            }
            medias[i] = suma / notas[i].length;
        }
        
        return medias;
    }

    //Metodo para calcular las medias de las asignaturas
    public static double[] calcularMediasAsignaturas(double[][] notas) {
        int numAsignaturas = notas[0].length;
        double[] medias = new double[numAsignaturas];

        for (int j = 0; j < numAsignaturas; j++) {
            double suma = 0;
            for (double[] alumno : notas) {
                suma += alumno[j];
            }
            medias[j] = suma / notas.length;
        }
        return medias;
    }

    //Metodo para calcular la media total de la clase
    public static double calcularMediaTotal(double[] mediasAlumnos) {
        double suma = 0;
        for (double media : mediasAlumnos) {
            suma += media;
        }
        return suma / mediasAlumnos.length;
    }

    //Método para ordenar los alumnos por notas medias individuales usando el método Shell
    public static void ordenarAlumnos(double[][] notas, double[] mediasAlumnos) {
        int n = mediasAlumnos.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double temp = mediasAlumnos[i];
                double[] tempNotas = notas[i];
                int j;
                for (j = i; j >= gap && mediasAlumnos[j - gap] > temp; j -= gap) {
                    mediasAlumnos[j] = mediasAlumnos[j - gap];
                    notas[j] = notas[j - gap];
                }
                mediasAlumnos[j] = temp;
                notas[j] = tempNotas;
            }
        }
    }

    //Método para mostrar las notas de los alumnos ordenadas por notas medias individuales
    public static void mostrarNotasAlumnos(double[][] notas) {
        for (double [] alumno : notas) {
            System.out.println(Arrays.toString(alumno));
        }
    }

    public static void main(String[] args) {

        // Se definen las notas de los alumnos
        double[][] notas = {
                {75, 80, 90, 85, 88},
                {85, 65, 85, 70, 85},
                {75, 90, 88, 90, 85},
        };

        // Calcular la media de cada alumno
        double[] mediasAlumnos = calcularMediasAlumnos(notas);

        //Calcular la media de cada asignatura
        double[] mediasAsignaturas = calcularMediasAsignaturas(notas);

        // Calcular la media total de la clase
        double mediaTotal = calcularMediaTotal(mediasAlumnos);

        //Ordenar los alumnos por orden decreciente de notas medias individuales
        ordenarAlumnos(notas, mediasAlumnos);

        //Mostrar resultados
        System.out.println("Medias individuales de los alumnos: " + Arrays.toString(mediasAlumnos));
        System.out.println("Medias de cada asignatura: " + Arrays.toString(mediasAsignaturas));
        System.out.println("Medias total de la clase: " + mediaTotal);
        System.out.println("Alumnos ordenados por notas medias individuales: ");
        mostrarNotasAlumnos(notas);
    }
}