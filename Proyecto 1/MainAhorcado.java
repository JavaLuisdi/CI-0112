public class MainAhorcado {
    public static void main(String[] args) {
        JugadorAhorcado jugador = new JugadorAhorcado();
        // Jugador 1 ingresa la palabra secreta
        String palabraSecreta = jugador.ingresarPalabraSecreta();
        JuegoAhorcado juego = new JuegoAhorcado(palabraSecreta);

        System.out.println("¡Comienza el juego! La palabra tiene " + palabraSecreta.length() + " letras.");

        // Bucle principal del juego
        while (!juego.isJuegoTerminado()) {
            System.out.println("\nPalabra: " + juego.getProgreso());
            System.out.println("Intentos restantes: " + juego.getIntentosRestantes());

            char letra = jugador.adivinarLetra();
            boolean acierto = juego.adivinarLetra(letra);

            if (!acierto) {
                System.out.println("¡Letra incorrecta! Pierdes un intento.");
            }
        }

        // Resultado final
        if (juego.getProgreso().equals(juego.getPalabraSecreta())) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + juego.getPalabraSecreta());
        } else {
            System.out.println("\n¡Perdiste! La palabra era: " + juego.getPalabraSecreta());
        }

        jugador.cerrarScanner();
    } 
} 