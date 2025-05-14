public class JuegoAhorcado {
    private String palabraSecreta;
    private char[] palabraAdivinada;
    private int intentosRestantes;
    private boolean juegoTerminado;

    public JuegoAhorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.palabraAdivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
        this.intentosRestantes = 6;
        this.juegoTerminado = false;
    }

    // Verifica si la letra está en la palabra secreta
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

    // Actualiza el estado del juego (si ganó o perdió)
    private void actualizarEstadoJuego() {
        if (intentosRestantes <= 0) {
            juegoTerminado = true;
        } else if (String.valueOf(palabraAdivinada).equals(palabraSecreta)) {
            juegoTerminado = true;
        }
    }

    // Muestra el progreso actual (ej: J _ V _)
    public String getProgreso() {
        return String.valueOf(palabraAdivinada);
    }
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}