/**
 * @class JuegoAhorcado
 * @brief Implementa el núcleo lógico del juego del ahorcado.
 *
 * @details Gestiona todo el estado interno del juego incluyendo:
 * - Almacenamiento y manejo de la palabra secreta
 * - Seguimiento del progreso del jugador
 * - Control de intentos restantes
 * - Determinación del estado del juego (activo/finalizado)
 *
 * @note Todas las comparaciones de letras se realizan en mayúsculas
 * @warning La clase no valida inputs externos (debe hacerse antes)
 */
public class JuegoAhorcado {
    /**
     * @brief La palabra objetivo que debe ser adivinada
     * @private
     */
    private String palabraSecreta;
    
    /**
     * @brief Representación del progreso de adivinación
     * @private
     * @details Array de caracteres donde:
     * - '_' indica letra no adivinada
     * - Letra mayúscula indica letra acertada
     */
    private char[] palabraAdivinada;
    
    /**
     * @brief Contador de intentos restantes
     * @private
     * @note Inicializado en 6 intentos (configuración clásica)
     */
    private int intentosRestantes;
    
    /**
     * @brief Bandera de estado del juego
     * @private
     * @details true = juego terminado (victoria/derrota)
     * false = juego en curso
     */
    private boolean juegoTerminado;

    /**
     * @brief Constructor que inicializa el juego con una palabra secreta
     * @param palabraSecreta La palabra que deberá ser adivinada
     * @details Configura:
     * 1. La palabra objetivo (convertida a mayúsculas)
     * 2. El array de progreso inicial (todo '_')
     * 3. Intentos iniciales (6)
     * 4. Estado del juego (activo)
     */
    public JuegoAhorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.palabraAdivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
        this.intentosRestantes = 6;
        this.juegoTerminado = false;
    }

    /**
     * @brief Procesa un intento de adivinar una letra
     * @param letra Letra propuesta por el jugador
     * @return true si la letra está en la palabra, false en caso contrario
     * @details Actualiza:
     * 1. El progreso de la palabra adivinada
     * 2. Los intentos restantes (si falla)
     * 3. El estado del juego
     *
     * @note No distingue mayúsculas/minúsculas (convierte todo a mayúsculas)
     * @warning No valida si la letra ya fue intentada previamente
     */
    public boolean adivinarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }
        if (!acierto) {
            intentosRestantes--;
        }
        actualizarEstadoJuego();
        return acierto;
    }

    /**
     * @brief Actualiza el estado del juego según condiciones de victoria/derrota
     * @private
     * @details Evalúa:
     * 1. Si se agotaron los intentos (derrota)
     * 2. Si se completó la palabra (victoria)
     */
    private void actualizarEstadoJuego() {
        if (intentosRestantes <= 0) {
            juegoTerminado = true;
        } else if (String.valueOf(palabraAdivinada).equals(palabraSecreta)) {
            juegoTerminado = true;
        }
    }

    /**
     * @brief Obtiene el progreso actual de la palabra
     * @return String representando las letras adivinadas y faltantes
     * @details Ejemplo: "A__A_" para palabra "ARBOL" con 'A' y 'B' adivinadas
     */
    public String getProgreso() {
        return String.valueOf(palabraAdivinada);
    }

    /**
     * @brief Obtiene los intentos restantes
     * @return Número de intentos disponibles (0-6)
     */
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    /**
     * @brief Verifica si el juego ha terminado
     * @return true si el juego terminó (victoria o derrota), false si está activo
     */
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    /**
     * @brief Obtiene la palabra secreta original
     * @return La palabra objetivo en mayúsculas
     * @note Normalmente usado al finalizar el juego
     */
    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}