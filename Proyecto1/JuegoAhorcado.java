/**
 * @class JuegoAhorcado
 * @brief Implementa la lógica principal del juego del ahorcado.
 *
 * Maneja el estado del juego, incluyendo:
 * - La palabra secreta a adivinar
 * - El progreso del jugador
 * - Los intentos restantes
 * - El estado del juego (terminado/no terminado)
 */
public class JuegoAhorcado {
    /**
     * @brief La palabra que debe ser adivinada (en mayúsculas)
     */
    private String palabraSecreta;
    
    /**
     * @brief Arreglo que muestra las letras adivinadas y las faltantes (_)
     */
    private char[] palabraAdivinada;
    
    /**
     * @brief Número de intentos restantes antes de perder
     */
    private int intentosRestantes;
    
    /**
     * @brief Indica si el juego ha terminado (ganado o perdido)
     */
    private boolean juegoTerminado;

    /**
     * @brief Constructor que inicializa el juego
     * @param palabraSecreta La palabra que el jugador debe adivinar
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
     * @param letra La letra que el jugador está adivinando
     * @return true si la letra está en la palabra, false en caso contrario
     * @note Reduce los intentos restantes si la letra no está en la palabra
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
     * @brief Actualiza el estado del juego (verifica victoria/derrota)
     * @private Método interno para controlar el estado del juego
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
     * @return String que muestra letras adivinadas y guiones bajos para las faltantes
     */
    public String getProgreso() {
        return String.valueOf(palabraAdivinada);
    }

    /**
     * @brief Obtiene los intentos restantes
     * @return Número de intentos que quedan
     */
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    /**
     * @brief Verifica si el juego ha terminado
     * @return true si el juego terminó (por victoria o derrota), false si continúa
     */
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    /**
     * @brief Obtiene la palabra secreta
     * @return La palabra que debía ser adivinada
     */
    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}