/*Cada línea de un archivo de datos contiene información sobre una compañía de informática. 
La línea contiene el nombre del empleado, las ventas efectuadas por el mismo
y el número de años de antigüedad del empleado en la compañía. Escribir un programa
que lea la información del archivo de datos y, a continuación, se visualiza. 
La información debe ser ordenada por ventas de mayor a menor y visualizada de nuevo.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class problema67 {

    //Metodo para leer datos
    public static Compania[] leerDatosDesdeArchivo(String nombreArchivo) {
        //Lista para almacenar la informacion
        Compania[] companias = null;

        try (BufferedReader br = new BufferedReader(new FileReader("datos_compañias.txt"))){
            String linea;
            int contador = 0;

            //Contar el numero de lineas
            while (br.readLine() != null) {
                contador++;
            }

            //Inicializar el arreglo de compañias
            companias = new Compania[contador];

            //Volver a leer el archivo para almacenar la informacion en el array
            br.close();
            //br = new BufferedReader(new FileReader("compañias.txt"));

            for (int i = 0; i < contador; i++) {
                linea = br.readLine();
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                double  ventas = Double.parseDouble(partes[1].trim());
                int antigedad = Integer.parseInt(partes[2].trim());
                companias[i] = new Compania(nombre, ventas, antigedad);
            } 
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return companias;
    }

    //Metodo para quicksort
    public static void quicksortPorVentas(Compania[] companias, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particionPorVentas(companias, inicio, fin);

            quicksortPorVentas(companias, inicio, indiceParticion - 1);
            quicksortPorVentas(companias, indiceParticion + 1, fin);
        }
    }

    //Metodo para particionar
    public static int particionPorVentas(Compania[] companias, int inicio, int fin) {
        double pivote = companias[fin].getVentas();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (companias[j].getVentas() >= pivote) {
                i++;
                intercambiar(companias, i, j);
            }
        }
        intercambiar(companias, i + 1, fin);

        return i + 1;
    }

    //Metrodo para intercambiar
    public static void intercambiar(Compania[] companias, int i, int j) {
        Compania temp = companias[i];
        companias[i] = companias[j];
        companias[j] = temp;
    }

    //Metodo para imprimir la informacion
    public static void imprimirInformacion(Compania[] companias) {
        for (Compania compania : companias) {
            System.out.println(compania);
        }
    }

    public static void main(String[] args) {
        //Nombre del archivo
        String nombreArchivo = "datos_compañias.txt";

        //Leer el archivo
        Compania[] companias = leerDatosDesdeArchivo(nombreArchivo);

        //Imprimir los datos
        System.out.println("Informacion Original: ");
        imprimirInformacion(companias);

        //Ordenar los datos
        quicksortPorVentas(companias, 0, companias.length - 1);

        //Imprimir las informacion ordenada
        System.out.println("\nInformacion Ordenada por ventas de mayor a menor: ");
        imprimirInformacion(companias);
    }
}

class Compania {
    private String nombre;
    private double ventas;
    private int antigedad;

    public Compania(String nombre, double ventas, int antigedad) {
        this.nombre = nombre;
        this.ventas = ventas;
        this.antigedad = antigedad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVentas() {
        return ventas;
    }

    public int getAntigedad() {
        return antigedad;
    }
    
    @Override
    public String toString() {
        return "Compañia{"+
                "nombre='" + nombre + '\'' +
                ", ventas=" + ventas +
                ", antigedad=" + antigedad +
                '}';
    }
}