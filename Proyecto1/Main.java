/**
 * @file Main.java
 * @brief Clase principal que implementa el menú de selección de juegos.
 * 
 * Esta clase contiene el método main que muestra un menú interactivo
 * para que el usuario seleccione entre diferentes juegos.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     * @brief Método principal que ejecuta el menú de selección de juegos.
     * 
     * Controla el flujo principal del programa:
     * 1. Muestra un menú con opciones de juegos
     * 2. Procesa la selección del usuario
     * 3. Ejecuta el juego seleccionado
     * 4. Maneja excepciones de entrada inválida
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BatallaNaval batallaNaval = new BatallaNaval();

        /**
         * @var menuIndex Almacena la opción seleccionada por el usuario
         * @brief Bucle principal del menú que se ejecuta hasta que el usuario seleccione salir
         */
        int menuIndex = 0;
        while (menuIndex != 3) {
            System.out.println("~ ~ ~ Menú de videojuegos ~ ~ ~");
            System.out.println("1. Batalla naval");
            System.out.println("2. Ahorcado");
            System.out.println("3. Salir");
            
            try {
                menuIndex = scanner.nextInt();
                
                /**
                 * @brief Switch que controla la ejecución de los juegos según la selección
                 */
                switch (menuIndex) {
                    case 1:
                        batallaNaval.initializeGame();
                        batallaNaval.startBattleship();
                        break;
                    case 2:
                        MainAhorcado.main(args);
                        break;
                    default:
                        System.out.println("Digite un número válido.");
                }
                
            } catch (InputMismatchException e) {
                /**
                 * @brief Manejo de excepción para entradas inválidas
                 */
                scanner.nextLine();
                System.out.println();
                System.out.println("Digite un número válido.");
                System.out.println();
            }
        }
        scanner.close();
    }
}