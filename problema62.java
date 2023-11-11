/*Dado un vector x de n elementos reales, donde n es impar, diseñar un método que
calcule y devuelva la mediana de ese vector. La mediana es el valor tal que la mitad
de los números son mayores que él y la otra mitad son menores. Escribir un programa
de prueba.*/

import java.util.Arrays;

public class problema62 {

    public static double cacularMedia(double[] vector){
        //Ordenar el vector
        Arrays.sort(vector);

        //Obtener la posicion de la mediana
        int posicionMed = vector.length / 2;

        //Devolver la mediana
        return vector[posicionMed];
    }
    
    public static void main(String[] args) {
        
        //Crear el vector de ejemplo
        double[] miVector = {1,2,3,4,5,6,7,8,9};

        //Validar si el tamaño del vector es impar
        if (miVector.length % 2 == 0) {
            System.out.println("El tamaño del vector debe ser impar para calcular la mediana.");
        } else {

            //Calcular la mediana del vector
            double mediana = cacularMedia(miVector);
            System.out.println("El vector original: " + Arrays.toString(miVector));
            System.out.println("La mediana del vector es: " + mediana);
        }
    }
}