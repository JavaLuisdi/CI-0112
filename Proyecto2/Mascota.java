public class Mascota {
    private String nombre;

    /**
     * @brief Constructor de la clase Mascota
     * 
     * Crea una nueva mascota con el nombre especificado
     * 
     * @param nombre El nombre de la mascota
     */
    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @brief Obtiene el nombre de la mascota
     * 
     * @return El nombre de la mascota
     */
    public String getNombre() {
        return this.nombre;
    }
}
