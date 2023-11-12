/*Escribir un programa de consulta de teléfonos. Leer un conjunto de datos de 1.000
nombres y números de teléfono de un archivo que contenga los números en orden aleatorio. 
Las consultas han de poder realizarse por nombre y por número de teléfono*/

import java.io.*;
import java.util.Arrays;

public class problema64 {
    public static void main(String[] args) throws IOException {
        //Leer los datos del archivo
        File file = new File("datos.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] datos = new String[1000];
            for (int i = 0; i < datos.length; i++) {
                datos[i] = reader.readLine();
            }

            // Ordenar los datos por nombre
            Arrays.sort(datos, (a, b) -> a.split(",")[0].compareTo(b.split(",")[0]));

            //Bucle de consulta
            while (true) {
                //Solicitar el tipo de consulta
                System.out.println("¿Que tipo de consulta desea realizar?");
                System.out.println("1. Por nombre");
                System.out.println("2. Por número de teléfono");
                int tipoConsulta = Integer.parseInt(System.console().readLine());

                //Realizar la consulta
                switch (tipoConsulta) {
                    case 1:
                        //Solicitar el nombre
                        System.out.println("Ingrese el nombre");
                        String nombre = System.console().readLine();

                        //Buscar el nombre en el archivo
                        int posicion = Arrays.binarySearch(datos, nombre + ",");

                        //Mostrar el numero de telefono si se encuentra
                        if (posicion > 0) {
                            System.out.println("EL numero de telefono de: " + nombre + " es " + datos[posicion].split(",")[1]);
                        } else {
                            System.out.println("El nombre no se encuentra en la lista");
                        }
                        break;
                
                    case 2:
                        //Solicitar el numero de telefono
                        System.out.println("Ingrese el numero de telefono: ");
                        String numeroTelefono = System.console().readLine();

                        //Buscar el numero de telefono en el archivo
                        int posicion2 = Arrays.binarySearch(datos, numeroTelefono + ",");

                        //Mostrar el nombre si se encuentra
                        if (posicion2 >= 0) {
                            System.out.println("El nombre de " + datos[posicion2].split(",")[0] + " es " + datos[posicion2].split(",")[1]);
                        } else {
                            System.out.println("El numero de telefono no se encuentra en la lista");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}