import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Arbol<Asociacion<String, String>> arbol = new Arbol<>();

    
        try {
            BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {

                linea = linea.replace("(", "").replace(")", "");

                String[] partes = linea.split(",");

                String ingles = partes[0].trim().toLowerCase();
                String espanol = partes[1].trim();

                arbol.insertar(new Asociacion<>(ingles, espanol));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer diccionario.txt");
        }

        
        System.out.println("Diccionario ordenado:");
        arbol.inOrder();

       
        System.out.println("\nTraduccion:");

        try {
            BufferedReader br2 = new BufferedReader(new FileReader("texto.txt"));
            String linea;

            while ((linea = br2.readLine()) != null) {

                String[] palabras = linea.split(" ");

                for (String palabra : palabras) {

                    String limpia = palabra.replaceAll("[^a-zA-Z]", "");
                    String buscar = limpia.toLowerCase();

                    Asociacion<String, String> resultado =
                        arbol.buscar(new Asociacion<>(buscar, null));

                    if (resultado != null) {
                        System.out.print(resultado.getValor() + " ");
                    } else {
                        System.out.print("*" + palabra + "* ");
                    }
                }
            }

            br2.close();

        } catch (IOException e) {
            System.out.println("Error al leer texto.txt");
        }

        
        // Pruebas simples
        
        System.out.println("\n\nPruebas:");

        Arbol<Asociacion<String, String>> test = new Arbol<>();

        test.insertar(new Asociacion<>("dog", "perro"));
        test.insertar(new Asociacion<>("cat", "gato"));

        Asociacion<String, String> res1 =
            test.buscar(new Asociacion<>("dog", null));

        if (res1 != null && res1.getValor().equals("perro")) {
            System.out.println("Busqueda correcta");
        } else {
            System.out.println("Error en busqueda");
        }

        Asociacion<String, String> res2 =
            test.buscar(new Asociacion<>("bird", null));

        if (res2 == null) {
            System.out.println("Busqueda inexistente correcta");
        } else {
            System.out.println("Error en busqueda inexistente");
        }
    }
}
    