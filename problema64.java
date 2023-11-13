/*Escribir un programa de consulta de teléfonos. Leer un conjunto de datos de 1.000
nombres y números de teléfono de un archivo que contenga los números en orden aleatorio. 
Las consultas han de poder realizarse por nombre y por número de teléfono*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problema64 {

    public static void main(String[] args) {
        // Cargar datos desde el archivo
        Map<String, String> telefonos = cargarDatos("datos.txt");

        // Realizar consultas
        realizarConsultas(telefonos);
    }

    private static Map<String, String> cargarDatos(String archivo) {
        Map<String, String> telefonos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    String numero = partes[1].trim();
                    telefonos.put(nombre, numero);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return telefonos;
    }

    private static void realizarConsultas(Map<String, String> telefonos) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Consultar por nombre");
            System.out.println("2. Consultar por número de teléfono");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreConsulta = scanner.nextLine();
                    if (telefonos.containsKey(nombreConsulta)) {
                        System.out.println("Número de teléfono: " + telefonos.get(nombreConsulta));
                    } else {
                        System.out.println("Nombre no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número de teléfono a buscar: ");
                    String numeroConsulta = scanner.nextLine();
                    if (telefonos.containsValue(numeroConsulta)) {
                        for (Map.Entry<String, String> entry : telefonos.entrySet()) {
                            if (entry.getValue().equals(numeroConsulta)) {
                                System.out.println("Nombre asociado: " + entry.getKey());
                                break;
                            }
                        }
                    } else {
                        System.out.println("Número de teléfono no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}