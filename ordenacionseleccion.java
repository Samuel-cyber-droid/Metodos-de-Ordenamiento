package recursividad.interfazGrafica.Ordenacion;
// Importamos las clases necesarias para manejar listas y comparadores
import java.util.*;

// Definimos la clase Racional
class Racional {
    // Declaramos los campos numerador y denominador como privados para mantener la encapsulación
    private int numerador, denominador;

    // Constructor por defecto que inicializa un número racional como 0/1
    public Racional() {
        numerador = 0;
        denominador = 1;
    }

    // Constructor con parámetros que permite crear un número racional con un numerador y denominador específicos
    public Racional(int n, int d) throws Exception {
        super();
        numerador = n;
        // Comprobamos que el denominador no sea 0 para evitar una división por cero
        if (d == 0)
            throw new Exception("Denominador == 0");
        denominador = d;
    }

    // Método para calcular el valor real del número racional, es decir, la división del numerador entre el denominador
    public double valorReal() {
        return (double) numerador / denominador;
    }
}

// Clase principal donde se ejecuta el programa
public class ordenacionseleccion {
    public static void main(String[] args) throws Exception {
        // Creamos una lista de objetos Racional
        List<Racional> lista = new ArrayList<>();
        // Añadimos algunos números racionales a la lista
        lista.add(new Racional(5, 7));
        lista.add(new Racional(2, 3));
        lista.add(new Racional(8, 9));

        // Ordenamos la lista usando un comparador personalizado
        // El comparador compara los valores reales de los números racionales
        Collections.sort(lista, new Comparator<Racional>() {
            @Override
            public int compare(Racional r1, Racional r2) {
                // Comparamos los valores reales de los números racionales
                // Si el valor real de r1 es menor que el de r2, devuelve un número negativo
                // Si son iguales, devuelve 0
                // Si el valor real de r1 es mayor que el de r2, devuelve un número positivo
                return Double.compare(r1.valorReal(), r2.valorReal());
            }
        });

        // Recorremos la lista ordenada e imprimimos los valores reales de los números racionales
        for (Racional r : lista) {
            System.out.println(r.valorReal());
        }
    }
}
