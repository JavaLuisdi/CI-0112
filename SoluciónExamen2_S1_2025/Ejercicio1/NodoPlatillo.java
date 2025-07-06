/**
 * Nodo para la lista de platillos del menú.
 */
public class NodoPlatillo {
    private Platillo platillo;
    private NodoPlatillo siguiente;

    /**
     * Constructor del nodo.
     * @param platillo El platillo a almacenar en el nodo.
     */
    public NodoPlatillo(Platillo platillo) {
        this.platillo = platillo;
        this.siguiente = null;
    } 

    /**
     * Establece el siguiente nodo en la lista.
     * @param siguiente El siguiente nodo a enlazar.
     */
    public void setSiguienteNodo(NodoPlatillo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Devuelve el platillo almacenado en este nodo.
     */
    public Platillo getPlatillo() {
        return this.platillo;
    }
    /**
     * Devuelve el siguiente nodo en la lista.
     */
    public NodoPlatillo getSiguienteNodo() {
        return this.siguiente;
    }
}
