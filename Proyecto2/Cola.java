public class Cola {
    private Nodo primerNodo;

    /**
     * @brief Constructor por defecto de la clase Cola
     * 
     * Inicializa una cola vacía estableciendo el primer nodo como null
     */
    public Cola() {
        this.primerNodo = null;
    }

    /**
     * @brief Establece el primer nodo de la cola
     * 
     * @param primerNodo El nodo que será el nuevo primer nodo de la cola
     */
    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    /**
     * @brief Inserta un nuevo nodo al final de la cola
     * 
     * Si la cola está vacía, el nodo se convierte en el primer nodo.
     * Si no está vacía, se busca el último nodo y se enlaza el nuevo nodo.
     * 
     * @param nodo El nodo que se va a insertar al final de la cola
     */
    public void insertarAlFinal(Nodo nodo) {
        if (this.primerNodo == null) {
            this.primerNodo = nodo;
        } else {
            getUltimoNodo(this.primerNodo).setSiguienteNodo(nodo);
        }
    }

    /**
     * @brief Obtiene el último nodo de la cola de forma recursiva
     * 
     * Recorre la lista enlazada hasta encontrar el nodo que no tiene
     * un nodo siguiente (último nodo).
     * 
     * @param nodo El nodo desde donde comenzar la búsqueda
     * @return El último nodo de la cola, o null si la cola está vacía
     */
    public Nodo getUltimoNodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.getSiguienteNodo() == null) {
            return nodo;
        }
        return getUltimoNodo(nodo.getSiguienteNodo());
    }

    /**
     * @brief Elimina el primer nodo de la cola
     * 
     * Si la cola no está vacía, elimina el primer nodo y establece
     * el segundo nodo como el nuevo primer nodo. Si la cola está vacía,
     * no hace nada.
     */
    public void eliminarPrimerNodo() {
        if (this.primerNodo != null) {
            Nodo nuevoPrimerNodo = this.primerNodo.getSiguienteNodo();
            setPrimerNodo(nuevoPrimerNodo);            
        }
    }
}
