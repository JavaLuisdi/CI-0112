// Clase que representa un nodo de cliente en la lista enlazada de la cola.
// Almacena el nombre del cliente y una referencia al siguiente nodo.
public class NodoCliente {
    private String nombre;
    private NodoCliente siguienteCliente;

    // Constructor: inicializa el nodo con el nombre del cliente y sin siguiente nodo.
    public NodoCliente(String nombre) {
        this.nombre = nombre;
        this.siguienteCliente = null;
    }

    // Asigna el siguiente nodo de la lista.
    public void setSiguienteCliente(NodoCliente siguienteCliente) {
        this.siguienteCliente = siguienteCliente;
    }

    // Retorna el nombre almacenado en el nodo.
    public String getNombre() {
        return this.nombre;
    }

    // Retorna la referencia al siguiente nodo de la lista.
    public NodoCliente getSiguienteCliente() {
        return this.siguienteCliente;
    }
}
