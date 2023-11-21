/*Las tablas de dispersión (hash tables) en Java se basan en la idea de mapear claves a 
valores utilizando una función hash para determinar el índice donde se almacenará cada 
elemento.

Función Hash: Esta función toma una clave y la convierte en un índice dentro de la tabla. 
La función hash intenta distribuir las claves de manera uniforme en la tabla para minimizar 
las colisiones (cuando dos claves diferentes obtienen el mismo índice). 
En Java, los objetos tienen un método hashCode() que se puede sobrescribir para 
personalizar cómo se genera el código hash para un objeto específico.

Almacenamiento: Una vez que se calcula el índice usando la función hash, el valor 
correspondiente se almacena en ese índice de la tabla. Si dos claves resultan en el mismo 
índice (colisión), la tabla debe manejar estas situaciones. Una forma común de hacerlo es 
utilizando listas enlazadas o técnicas de resolución de colisiones como "separación por 
chaining" o "sondeo lineal".

Acceso y Búsqueda: Para buscar un valor asociado con una clave, se aplica la 
función hash a la clave para encontrar su índice y luego se accede a ese índice en la tabla. 
Si hay colisiones, se sigue un proceso definido para resolverlas y encontrar el valor 
correcto.

BufferedImage: subclase que describe la imagenes*/

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BusquedaHash {

    // Clase interna para representar una imagen
    static class Image {
        private String name;
        private int width;
        private int height;

        // Constructor de la clase Image
        public Image(String name, int width, int height) {
            this.name = name;
            this.width = width;
            this.height = height;
        }

        // Getters para obtener los atributos de la imagen
        public String getName() {
            return name;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        // Método para comparar si dos imágenes son iguales
        public boolean areImagesEqual(Image other) {
            try {
                File file1 = new File(this.name);
                File file2 = new File(other.name);

                BufferedImage img1 = ImageIO.read(file1);
                BufferedImage img2 = ImageIO.read(file2);

                // Verifica si las imágenes tienen el mismo tamaño y contenido de píxeles
                if (img1 == null || img2 == null || img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
                    return false;
                }

                // Compara pixel por pixel para verificar si las imágenes son iguales
                for (int y = 0; y < img1.getHeight(); y++) {
                    for (int x = 0; x < img1.getWidth(); x++) {
                        if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        // Método para generar un índice usando el nombre de la imagen
        public int generateIndex(int tableSize) {
            int sumOfCharacters = 0;
            for (char c : this.name.toCharArray()) {
                sumOfCharacters += (int) c;
            }
            return sumOfCharacters % tableSize;
        }
    }

    // Atributos de la clase App
    Image[] arreglo;
    int tamanio;

    // Constructor de la clase App
    public BusquedaHash(int tam) {
        tamanio = tam;
        arreglo = new Image[tam];
        Arrays.fill(arreglo, null);
    }

    // Método para realizar la función hash e insertar imágenes en la tabla
    public void functionHash(Image[] images, Image[] array) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            if (image != null) {
                int index = image.generateIndex(tamanio);

                // Resuelve colisiones usando sondas lineales
                while (array[index] != null) {
                    index++;
                    index %= tamanio;
                }
                array[index] = image;
            }
        }
    }

    // Método para mostrar la tabla hash
    public void mostrarTabla() {
        int incremento = 0;
        for (int i = 0; i < 1; i++) {
            incremento += 8;
            for (int j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
            for (int j = incremento - 8; j < incremento; j++) {
                System.out.format("|%3s" + "", j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
            for (int j = incremento - 8; j < incremento; j++) {
                if (arreglo[j] == null) {
                    System.out.print("|");
                } else {
                    System.out.print(String.format("|%3s" + "", arreglo[j].getName()));
                }
            }
            System.out.println("|");
            for (int j = 0; j < 71; j++) {
                System.out.print("-");
            }
        }
    }

    // Método para buscar una imagen en la tabla hash
    public void searchImage(Image targetImage) {
        List<Image> foundImages = new ArrayList<>();

        // Recorre las imágenes en el arreglo y verifica si son iguales a la imagen objetivo
        for (Image image : arreglo) {
            if (image != null && image.areImagesEqual(targetImage)) {
                foundImages.add(image);
            }
        }

        // Imprime las imágenes encontradas si hay coincidencias
        if (!foundImages.isEmpty()) {
            System.out.println("\nImágenes similares encontradas:");
            for (Image image : foundImages) {
                System.out.println("- " + image.getName());
            }
        } else {
            System.out.println("\nLa imagen no se encontró.");
        }
    }

    // Método principal (main)
    public static void main(String[] args) {
        // Array de rutas de las imágenes
        String[] paths = {
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\img1.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\img4.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\img5.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\img6.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\img7.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes2\\img1.jpg",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes\\prueba.PNG",
            "C:\\Escuela\\TECNM CLASES\\3ER SEMESTRE\\Estructura de Datos\\Imagenes2\\prueba3.PNG"
        };

        Image[] images = new Image[paths.length];

        try {
            BusquedaHash app = new BusquedaHash(8); // Crear la instancia de App con tamaño de tabla hash 8

            // Carga las imágenes desde las rutas especificadas
            for (int i = 0; i < paths.length; i++) {
                File file = new File(paths[i]);
                BufferedImage bufferedImage = ImageIO.read(file);
                if (bufferedImage == null) {
                    System.out.println("La imagen es nula");
                } else {
                    System.out.println("Imagen leída correctamente: " + paths[i]);
                    int width = bufferedImage.getWidth();
                    int height = bufferedImage.getHeight();
                    System.out.println("Ancho de la imagen: " + width + ", Altura de la imagen: " + height);
                    images[i] = new Image(paths[i], width, height); // Crea una nueva imagen con sus datos
                }
            }

            // Realiza la función hash e inserta las imágenes en la tabla
            app.functionHash(images, app.arreglo);

            // Muestra la tabla hash y las imágenes almacenadas en ella
            app.mostrarTabla();

            // Establece la imagen a buscar (aquí se puede cambiar la imagen a buscar)
            Image imagenABuscar = images[6];
            Image imagenABuscar2 = images[0];
            app.searchImage(imagenABuscar); // Busca la imagen en la tabla hash
            app.searchImage(imagenABuscar2); // Busca la imagen en la tabla hash

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la imagen: " + e.getMessage());
        }
    }
}