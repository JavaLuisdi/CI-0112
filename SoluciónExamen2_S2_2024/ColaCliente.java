// Clase que implementa una cola simple de clientes usando una lista enlazada.
// Permite agregar clientes al final y sacar clientes del inicio.
public class ColaCliente {
    private NodoCliente primerCliente;

    // Constructor: inicializa la cola vacía.
    public ColaCliente() {
        this.primerCliente = null;
    }

    // Retorna true si la cola está vacía, false en caso contrario.
    public boolean vacia() {
        if (primerCliente == null) {
            return true;
        }
        return false;
    }

    // Agrega un nuevo cliente al final de la cola.
    public void agregarCliente(String nombre) {
        NodoCliente nuevoCliente = new NodoCliente(nombre);
        if (vacia()) {
            this.primerCliente = nuevoCliente;
        } else {
            getUltimoCliente(this.primerCliente).setSiguienteCliente(nuevoCliente);
        }
    }

    // Retorna el último nodo de la cola a partir del nodo dado.
    private NodoCliente getUltimoCliente(NodoCliente cliente) {
        if (cliente.getSiguienteCliente() == null) {
            return cliente;
        }
        return getUltimoCliente(cliente.getSiguienteCliente());
    }

    // Elimina el primer cliente de la cola.
    public void sacar() {
        if (!vacia() && this.primerCliente.getSiguienteCliente() != null) {
            this.primerCliente = this.primerCliente.getSiguienteCliente();
        } else if (!vacia()) {
            this.primerCliente = null;
        }
    }

    // Retorna el primer cliente de la cola.
    public NodoCliente getPrimerCliente() {
        return this.primerCliente;
    }
}
