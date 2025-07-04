public class Veterinaria {
    /**
     * Cola de mascotas en espera de ser atendidas
     */
    private Cola fila;
    /**
     * Cola de mascotas que ya han sido atendidas (historial)
     */
    private Cola historial;
    /**
     * Árbol binario que almacena el registro de todas las mascotas
     */
    private ArbolBinario registro;

    /**
     * Constructor de la clase Veterinaria
     * Inicializa la fila, el historial y el registro de mascotas
     */
    public Veterinaria() {
        this.fila = new Cola();
        this.historial = new Cola();
        this.registro = new ArbolBinario();
    }

    /**
     * Obtiene la cola de mascotas en espera
     * @return la cola de mascotas en espera
     */
    public Cola getFila() {
        return fila;
    }

    /**
     * Obtiene la cola de mascotas atendidas (historial)
     * @return la cola de mascotas atendidas
     */
    public Cola getHistorial() {
        return historial;
    }

    /**
     * Obtiene el árbol binario de registro de mascotas
     * @return el árbol binario de registro
     */
    public ArbolBinario getRegistro() {
        return registro;
    }
}
