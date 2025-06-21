public class Mascota {
    private String nombre;
    private int posicionCola;

    /**
     * @brief Constructor de la clase Mascota
     * 
     * Crea una nueva mascota con el nombre y posición especificados
     * 
     * @param nombre El nombre de la mascota
     * @param posicionCola La posición inicial en la cola de atención
     */
    public Mascota(String nombre , int posicionCola) {
        this.nombre = nombre;
        this.posicionCola = posicionCola;
    }

    /**
     * @brief Establece la posición de la mascota en la cola
     * 
     * @param posicionCola La nueva posición en la cola de atención
     */
    public void setPosicionCola(int posicionCola) {
        this.posicionCola = posicionCola;
    }

    /**
     * @brief Obtiene el nombre de la mascota
     * 
     * @return El nombre de la mascota
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @brief Obtiene la posición de la mascota en la cola
     * 
     * @return La posición actual en la cola de atención
     */
    public int getPosicionCola() {
        return this.posicionCola;
    }
}
