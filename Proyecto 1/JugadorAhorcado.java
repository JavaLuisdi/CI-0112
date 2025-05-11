
import java.util.Scanner;

public class JugadorAhorcado{
     private Scanner scanner;

     public JugadorAhorcado(){
        scanner = new Scanner(System.in);
     }

// Metodo para que el jugador ingrese la palabra secreta
public String ingresarPalabraSecreta(){
    System.out.println(" Jugador 1, ingrese palabra secreta: ");
    return scanner.nextLine().toUpperCase();
}

// Método para que el jugador 2 adivine una letra
public char adivinarLetra(){
    System.out.println(" Jugador 2, ingrese una letar: ");
    return scanner.nextLine().toUpperCase().charAt(0);

}

public void cerrarScanner() {
        scanner.close();
    }
    
}