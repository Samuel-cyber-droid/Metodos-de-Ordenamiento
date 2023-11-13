/*Este programa es una extencion del problema 6.4 para que pueda generar 1000 nombres y numeros aleatorios*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarDatosFalsos {

    public static void main(String[] args) {
        generarDatosFalsos("datos.txt", 1000);
    }

    private static void generarDatosFalsos(String archivo, int cantidad) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            //Random random = new Random();

            for (int i = 0; i < cantidad; i++) {
                String nombre = generarNombreAleatorio();
                String numero = generarNumeroAleatorio();
                String linea = nombre + "," + numero;

                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Datos falsos generados con éxito en el archivo: " + archivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generarNombreAleatorio() {
        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Pedro", "Laura", "David", "Sofía", "Diego", "Elena"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }

    private static String generarNumeroAleatorio() {
        // Generar un número de teléfono ficticio de 9 dígitos
        Random random = new Random();
        StringBuilder numero = new StringBuilder("9"); // Comienza con el código de país de Perú (cambiar según la necesidad)
        
        for (int i = 0; i < 8; i++) {
            numero.append(random.nextInt(10));
        }

        return numero.toString();
    }
}
