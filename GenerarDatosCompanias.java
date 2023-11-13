import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarDatosCompanias {

    public static void main(String[] args) {
        generarDatos("datos_companias.txt", 100);
    }

    private static void generarDatos(String archivo, int cantidad) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            Random random = new Random();

            for (int i = 0; i < cantidad; i++) {
                String nombre = generarNombreAleatorio();
                double ventas = generarVentasAleatorias();
                int antiguedad = random.nextInt(20) + 1; // Antigüedad entre 1 y 20 años

                String linea = nombre + "," + ventas + "," + antiguedad;

                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Datos generados con éxito en el archivo: " + archivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generarNombreAleatorio() {
        String[] nombres = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hank", "Ivy", "Jack"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }

    private static double generarVentasAleatorias() {
        // Generar ventas aleatorias entre 1000 y 100000
        Random random = new Random();
        return 1000 + (100000 - 1000) * random.nextDouble();
    }
}
