public class Nodo {
    private Mascota mascota;
    /** @brief Referencia al siguiente nodo en la lista enlazada */
    private Nodo siguienteNodo;
    /** @brief Referencia al nodo hijo izquierdo en el árbol binario */
    private Nodo izquierdo;
    /** @brief Referencia al nodo hijo derecho en el árbol binario */
    private Nodo derecho;

    /**
     * @brief Constructor de la clase Nodo
     * 
     * Crea un nuevo nodo con la mascota especificada
     * 
     * @param mascota La mascota que se almacenará en este nodo
     */
    public Nodo (Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * @brief Establece el siguiente nodo en la lista enlazada
     * 
     * @param siguienteNodo El nodo que será el siguiente en la lista
     */
    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    /**
     * @brief Establece la mascota almacenada en este nodo
     * 
     * @param mascota La nueva mascota a almacenar
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * @brief Obtiene la mascota almacenada en este nodo
     * 
     * @return La mascota almacenada en este nodo
     */
    public Mascota getMascota() {
        return this.mascota;
    }

    /**
     * @brief Obtiene el siguiente nodo en la lista enlazada
     * 
     * @return El siguiente nodo en la lista, o null si es el último
     */
    public Nodo getSiguienteNodo() {
        return this.siguienteNodo;
    }

    /**
     * @brief Establece un nodo hijo en el árbol binario
     * 
     * @param nodo El nodo hijo a establecer
     * @param lado true para hijo derecho, false para hijo izquierdo
     */
    public void setNodoLado(Nodo nodo , boolean lado) {
        if (lado) {
            this.derecho = nodo;
        } else {
            this.izquierdo = nodo;
        }
    }

    /**
     * @brief Obtiene un nodo hijo del árbol binario
     * 
     * @param lado true para obtener hijo derecho, false para hijo izquierdo
     * @return El nodo hijo correspondiente, o null si no existe
     */
    public Nodo getNodoLado(boolean lado) {
        if (lado) {
            return this.izquierdo;
        }
        return this.derecho;
    }
}