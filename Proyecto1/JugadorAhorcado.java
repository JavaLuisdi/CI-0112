
/**
 * @class JugadorAhorcado
 * @brief Maneja las interacciones con los jugadores en el juego del ahorcado.
 * 
 * Esta clase se encarga de:
 * - Recibir la palabra secreta del Jugador 1
 * - Gestionar los intentos de adivinación del Jugador 2
 * - Validar las entradas de los usuarios
 */
import java.util.Scanner;

public class JugadorAhorcado {
    /**
     * @brief Scanner para leer la entrada del usuario
     */
    private Scanner scanner;

    /**
     * @brief Constructor que inicializa el Scanner
     */
    public JugadorAhorcado() {
        scanner = new Scanner(System.in);
    }

    /**
     * @brief Solicita y valida la palabra secreta al Jugador 1
     * 
     * Pide repetidamente la palabra hasta que se ingrese una válida (solo letras)
     * 
     * @return La palabra secreta en mayúsculas
     * @note Usa expresión regular [A-ZÑ]+ para validar solo letras
     */
    public String ingresarPalabraSecreta() {
        Scanner scanner = new Scanner(System.in);
        String palabra;
        do {
            System.out.print("Jugador 1, ingrese palabra secreta (solo letras): ");
            palabra = scanner.nextLine().toUpperCase();
        } while (!palabra.matches("[A-ZÑ]+"));  //solo permite letras
        
        return palabra;
    }

    /**
     * @brief Solicita al Jugador 2 que adivine una letra
     * 
     * @return La letra ingresada convertida a mayúscula
     * @warning Solo toma el primer carácter ingresado
     */
    public char adivinarLetra() {
        System.out.println("Jugador 2, ingrese una letra: ");
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    /**
     * @brief Cierra el scanner para liberar recursos
     * 
     * @important Debe llamarse al finalizar el uso del objeto
     */
    public void cerrarScanner() {
        scanner.close();
    }
}