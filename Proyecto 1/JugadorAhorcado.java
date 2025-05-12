
import java.util.Scanner;

public class JugadorAhorcado{
     private Scanner scanner;

     public JugadorAhorcado(){
        scanner = new Scanner(System.in);
     }

// Metodo para que el jugador ingrese la palabra secreta
public String ingresarPalabraSecreta() {
    Scanner scanner = new Scanner(System.in);
    String palabra;
    do {
        System.out.print("Jugador 1, ingrese palabra secreta (solo letras): ");
        palabra = scanner.nextLine().toUpperCase();
    } while (!palabra.matches("[A-ZÑ]+"));  //solo permite letras
    
    return palabra;
}

// Método para que el jugador 2 adivine una letra
public char adivinarLetra(){
    System.out.println(" Jugador 2, ingrese una letra: ");
    return scanner.nextLine().toUpperCase().charAt(0);

}

public void cerrarScanner() {
        scanner.close();
    }
    
}