private char [] palabraOculta; // Representación con guiones(_ _ _)
private int intentosRestantes; //Número de intentos disponibles
private String letrasUsadas; // Letras que el Jugador ya intentó
jbkjbkbjkb




    public JuegoAhorcado() {
        // Inicializa valores por defecto 
        this.palabraSecreta = "";
        this.palabraOculta = new char[0];
        this.intentosRestantes = 6;
        this.letrasUsadas = "";
    }
    // Inicializa el juego con una nueva palabra secreta
    public void inicializarJuego(String palabra){
        this.palabraSecreta = palabra.toLowercase();
        this.palabraOculta = new char[palabra.length()];
        Arrays.fill(this.palabraOculta,'_'); // Llena el arreglo con _
        this.intentosRestantes = 6;
        this.letrasUsadas = "";
    }
    // Procesa una letra ingresada por el jugador 
   public boolean procesarLetra(char letra){
       letra = Character.toLowercase(letra);// Convertir a minúscula para evitar problemas
      
      // Si la letra ya fue usada, no hacer nada 
      if (letrasUsadas.contains(String.valueOf(letra))){
         return false; 
      }
      //Registrar la letra como usada
      letrasUsadas += letra + " ";
      
      boolean letraAdivinada = false;

      //Buscar la letra en la palabra secreta 
      for(int i = 0; i < palabraSecreta.length(); i++){
        if (palabraSecreta.charAt(i) == letra){
            palabraOculta[i] = letra; // Revelar la letra en su posición
            letraAdivinada = true;
        }
      }
      // Si no se adivinó, restar un intento 
      if (!letraAdivinada) {
        intentosRestantes--;
      }
      return letraAdivinada;
   }
// Verificar si el jugador ha adivinado toda la palabra
public boolean esVictoria(){
    return String.valueOf(palabraOculta).equals(palabraSecreta);
      }
// Verificar si el jugador se quedó sin intentos
public boolean esDerrota(){
    return intentosRestantes <= 0;
}
// Obtiene la palabra oculta en formato String

public String getPalabraOculta() {
    return String.valueOf(palabraOculta);
}
// Obtiene las letras que ya se han intentado 
public String getLetrasUsadas(){
    return letrasUsadas;
}
// Obtiene los intentos restantes
public int getIntentosRestantes(){
    return intentosRestantes;
}
// Obtiene la palabra secreta
public String getPalabraSecreta() {
    return palabraSecreta;
}

}