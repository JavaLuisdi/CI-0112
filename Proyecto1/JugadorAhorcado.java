/**
 * @class JugadorAhorcado
 * @brief Clase que gestiona todas las interacciones con los jugadores en el juego del ahorcado.
 *
 * @details Esta clase actúa como interfaz entre los jugadores y la lógica del juego,
 * manejando:
 * - La entrada de la palabra secreta por parte del Jugador 1
 * - Los intentos de adivinación del Jugador 2
 * - La validación de todas las entradas de usuario
 * - La visualización de información del juego (rondas, resultados)
 *
 * @note Todos los inputs se convierten automáticamente a mayúsculas para estandarización.
 * @warning El scanner debe cerrarse explícitamente al terminar el juego.
 */
import java.util.Scanner;

public class JugadorAhorcado {
    /**
     * @brief Scanner para leer la entrada del usuario desde consola.
     * @private
     */
    private Scanner scanner;

    /**
     * @brief Constructor que inicializa el Scanner para entrada de datos.
     * 
     * @details Prepara el sistema para recibir inputs de los jugadores
     * creando una nueva instancia de Scanner asociada a System.in.
     */
    public JugadorAhorcado() {
        scanner = new Scanner(System.in);
    }

    /**
     * @brief Solicita y valida la palabra secreta al Jugador 1.
     * 
     * @details Pide repetidamente la palabra hasta que se ingrese una válida
     * (solo letras mayúsculas sin números ni caracteres especiales).
     * 
     * @return La palabra secreta validada en mayúsculas.
     * 
     * @note Usa expresión regular [A-ZÑ]+ para validar solo letras.
     * @warning No acepta espacios en la palabra secreta.
     */
    public String ingresarPalabraSecreta() {
        String palabra;
        do {
            System.out.print("Jugador 1, ingrese palabra secreta (solo letras): ");
            palabra = scanner.nextLine().toUpperCase();
        } while (!palabra.matches("[A-ZÑ]+"));
        
        return palabra;
    }

    /**
     * @brief Solicita al Jugador 2 que adivine una letra.
     * 
     * @details Muestra un prompt y captura el intento de adivinación.
     * 
     * @return La primera letra del input convertida a mayúscula.
     * 
     * @note Solo considera el primer carácter ingresado.
     * @warning No realiza validación de tipo de dato (acepta cualquier input).
     */
    public char adivinarLetra() {
        System.out.print("Jugador 2, ingrese una letra: ");
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    /**
     * @brief Muestra el encabezado de la ronda actual.
     * 
     * @param ronda Número de la ronda actual (1-3).
     * 
     * @details Formato visual:
     * \n=== RONDA X ===
     * \nJugador 1: Elige una palabra...
     */
    public void mostrarMensajeRonda(int ronda) {
        System.out.println("\n=== RONDA " + ronda + " ===");
        System.out.println("Jugador 1: Elige una palabra para que el Jugador 2 adivine");
    }

    /**
     * @brief Muestra el marcador después de cada ronda.
     * 
     * @param puntosJ1 Puntos acumulados por el Jugador 1.
     * @param puntosJ2 Puntos acumulados por el Jugador 2.
     * 
     * @details Formato visual:
     * \n=== MARCADOR PARCIAL ===
     * \nJugador 1: X puntos
     * \nJugador 2: Y puntos
     */
    public void mostrarParcial(int puntosJ1, int puntosJ2) {
        System.out.println("\n=== MARCADOR PARCIAL ===");
        System.out.println("Jugador 1: " + puntosJ1 + " puntos");
        System.out.println("Jugador 2: " + puntosJ2 + " puntos");
    }

    /**
     * @brief Muestra el resultado final del juego después de 3 rondas.
     * 
     * @param puntosJ1 Puntos finales del Jugador 1.
     * @param puntosJ2 Puntos finales del Jugador 2.
     * 
     * @details Muestra:
     * 1. Encabezado "RESULTADO FINAL"
     * 2. Puntos de ambos jugadores
     * 3. Declaración del ganador o empate
     * 
     * @note Se considera ganador quien tenga más puntos.
     * En empate, se declara como tal.
     */
    public void mostrarResultadoFinal(int puntosJ1, int puntosJ2) {
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Jugador 1: " + puntosJ1 + " puntos");
        System.out.println("Jugador 2: " + puntosJ2 + " puntos");
        
        if (puntosJ1 > puntosJ2) {
            System.out.println("¡Jugador 1 es el ganador!");
        } else if (puntosJ2 > puntosJ1) {
            System.out.println("¡Jugador 2 es el ganador!");
        } else {
            System.out.println("¡Empate!");
        }
    }

    
}