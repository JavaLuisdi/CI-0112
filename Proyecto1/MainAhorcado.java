/**
 * @file MainAhorcado.java
 * @brief Clase principal que implementa el juego del ahorcado.
 * 
 * Esta clase contiene el método main que controla el flujo del juego,
 * coordinando las interacciones entre el jugador y la lógica del juego.
 */

public class MainAhorcado {
    /**
     * @brief Método principal que ejecuta el juego del ahorcado.
     * 
     * Controla el flujo completo del juego:
     * 1. Solicita la palabra secreta al jugador
     * 2. Inicializa el juego
     * 3. Gestiona los turnos de adivinación
     * 4. Determina el resultado final
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        JugadorAhorcado jugador = new JugadorAhorcado();
        
        // Jugador 1 ingresa la palabra secreta
        /**
         * @var palabraSecreta La palabra que el jugador debe adivinar
         */
        String palabraSecreta = jugador.ingresarPalabraSecreta();
        JuegoAhorcado juego = new JuegoAhorcado(palabraSecreta);

        System.out.println("¡Comienza el juego! La palabra tiene " + palabraSecreta.length() + " letras.");

        // Bucle principal del juego
        /**
         * @brief Bucle principal del juego que se ejecuta mientras el juego no haya terminado
         * 
         * En cada iteración:
         * 1. Muestra el progreso actual
         * 2. Muestra los intentos restantes
         * 3. Solicita una letra al jugador
         * 4. Procesa la adivinación
         */
        while (!juego.isJuegoTerminado()) {
            System.out.println("Palabra: " + juego.getProgreso());
            System.out.println("Intentos restantes: " + juego.getIntentosRestantes());

            char letra = jugador.adivinarLetra();
            boolean acierto = juego.adivinarLetra(letra);

            if (!acierto) {
                System.out.println("¡Letra incorrecta! Pierdes un intento.");
            }
        }

        // Resultado final
        /**
         * @brief Determina y muestra el resultado final del juego
         * 
         * Verifica si el jugador adivinó la palabra completa o se quedó sin intentos
         */
        if (juego.getProgreso().equals(juego.getPalabraSecreta())) {
            System.out.println("¡Felicidades! Adivinaste la palabra: " + juego.getPalabraSecreta());
        } else {
            System.out.println("¡Perdiste! La palabra era: " + juego.getPalabraSecreta());
        }

        jugador.cerrarScanner();
    } 
}