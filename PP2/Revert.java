import java.io.*;
import java.util.Stack;

public class Revert {

    public static void main(String[] args) {
        Stack<Character> pila = new Stack<>();
        String archivoEntrada = "input.txt";
        String archivoSalida = "output.txt";

        try (FileReader lector = new FileReader(archivoEntrada)) {
            int caracter;
            while ((caracter = lector.read()) != -1) {
                pila.push((char) caracter);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo '" + archivoEntrada + "': " + e.getMessage());
            return;
        }

        try (FileWriter escritor = new FileWriter(archivoSalida)) {
            while (!pila.isEmpty()) {
                escritor.write(pila.pop());
            }
            System.out.println("Archivo invertido correctamente: " + archivoSalida);
        } catch (IOException e) {
            System.out.println("Error escribiendo '" + archivoSalida + "': " + e.getMessage());
        }
    }
}