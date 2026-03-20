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

                
                String ingles = partes[0].trim();
                String espanol = partes[1].trim();

                
                arbol.insertar(new Asociacion<>(ingles, espanol));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }

        
        System.out.println("Diccionario ordenado:");
        arbol.inOrder();
    }
}
    