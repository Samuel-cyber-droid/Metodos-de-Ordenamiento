/*Cada línea de un archivo de datos contiene información sobre una compañía de informática. 
La línea contiene el nombre del empleado, las ventas efectuadas por el mismo
y el número de años de antigüedad del empleado en la compañía. Escribir un programa
que lea la información del archivo de datos y, a continuación, se visualiza. 
La información debe ser ordenada por ventas de mayor a menor y visualizada de nuevo.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Empleado {
    String nombre;
    double ventas;
    int antiguedad;

    public Empleado(String nombre, double ventas, int antiguedad) {
        this.nombre = nombre;
        this.ventas = ventas;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ventas: " + ventas + ", Antigüedad: " + antiguedad + " años";
    }
}

public class problema67 {

    public static void main(String[] args) {
        List<Empleado> empleados = leerDatos("datos_companias.txt");

        // Ordenar la lista por ventas de mayor a menor
        Collections.sort(empleados, Comparator.comparingDouble(Empleado::getVentas).reversed());;

        // Mostrar la información ordenada
        System.out.println("Información ordenada por ventas de mayor a menor:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    private static List<Empleado> leerDatos(String archivo) {
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    double ventas = Double.parseDouble(partes[1].trim());
                    int antiguedad = Integer.parseInt(partes[2].trim());
                    empleados.add(new Empleado(nombre, ventas, antiguedad));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }
}