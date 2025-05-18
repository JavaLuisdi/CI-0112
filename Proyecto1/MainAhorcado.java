/**
 * @file MainAhorcado.java
 * @brief Clase principal que implementa el juego del ahorcado con 3 rondas consecutivas.
 * 
 * @details Esta clase contiene el método main que controla el flujo completo del juego,
 * coordinando las interacciones entre los jugadores y la lógica del juego.
 * Maneja 3 rondas consecutivas, lleva registro de puntos y determina un ganador final.
 * 
 * @note El juego sigue las siguientes reglas:
 * - Jugador 1 ingresa una palabra secreta en cada ronda
 * - Jugador 2 intenta adivinar la palabra con 6 intentos máximos
 * - Cada ronda otorga 1 punto al ganador
 * - Después de 3 rondas se declara un ganador final
 */
public class MainAhorcado {
    /**
     * @brief Método principal que ejecuta el juego del ahorcado en 3 rondas.
     * 
     * @details Controla el flujo completo del juego:
     * 1. Inicializa los componentes del juego
     * 2. Ejecuta 3 rondas consecutivas
     * 3. Lleva registro de puntos para cada jugador
     * 4. Determina y muestra el ganador final
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta implementación)
     * 
     * @note El flujo de cada ronda es:
     * 1. Jugador 1 ingresa palabra secreta
     * 2. Jugador 2 intenta adivinar
     * 3. Se actualiza el marcador
     * 
     * @warning Asegúrese de cerrar el scanner al finalizar el juego
     */
    public static void main(String[] args) {
        // Inicialización de componentes
        JugadorAhorcado jugador = new JugadorAhorcado();
        int puntosJugador1 = 0; ///< Puntos acumulados por el Jugador 1
        int puntosJugador2 = 0; ///< Puntos acumulados por el Jugador 2
        
        /**
         * @brief Bucle principal que controla las 3 rondas del juego
         * 
         * @details Por cada ronda:
         * 1. Muestra el número de ronda
         * 2. Solicita palabra secreta
         * 3. Inicia el juego de adivinanza
         * 4. Actualiza el marcador
         */
        for (int ronda = 1; ronda <= 3; ronda++) {
            jugador.mostrarMensajeRonda(ronda);
            
            /**
             * @var palabraSecreta Palabra que el Jugador 1 define para que el Jugador 2 adivine
             * @note Solo puede contener letras (A-Z, Ñ)
             */
            String palabraSecreta = jugador.ingresarPalabraSecreta();
            JuegoAhorcado juego = new JuegoAhorcado(palabraSecreta);

            System.out.println("¡Comienza el juego! La palabra tiene " + palabraSecreta.length() + " letras.");

            /**
             * @brief Bucle de adivinanza de la ronda actual
             * 
             * @details Se ejecuta mientras:
             * 1. El juego no haya terminado (por victoria o derrota)
             * 2. Queden intentos disponibles
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

            // Resultado de la ronda
            /**
             * @brief Determina el ganador de la ronda actual
             * 
             * @details Asigna puntos según:
             * - Jugador 2 gana si adivina la palabra completa
             * - Jugador 1 gana si Jugador 2 agota sus intentos
             */
            if (juego.getProgreso().equals(juego.getPalabraSecreta())) {
                System.out.println("¡Jugador 2 adivinó la palabra: " + juego.getPalabraSecreta());
                puntosJugador2++;
            } else {
                System.out.println("¡Jugador 1 gana la ronda! La palabra era: " + juego.getPalabraSecreta());
                puntosJugador1++;
            }
            
            jugador.mostrarParcial(puntosJugador1, puntosJugador2);
        }

        /**
         * @brief Muestra el resultado final del juego
         * 
         * @details Compara los puntos acumulados y declara:
         * - Ganador si hay diferencia de puntos
         * - Empate si ambos tienen los mismos puntos
         */
        jugador.mostrarResultadoFinal(puntosJugador1, puntosJugador2);
        
    } 
}