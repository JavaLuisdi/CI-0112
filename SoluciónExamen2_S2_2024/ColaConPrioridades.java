// Clase que implementa una cola con prioridades para clientes de banco.
// Administra cuatro colas internas según la prioridad del cliente y permite atender según el orden de prioridad.
public class ColaConPrioridades {
    private ColaCliente adultoMayor;
    private ColaCliente mujerEmbarazada;
    private ColaCliente personaConNecesidadesEspeciales;
    private ColaCliente clienteRegular;

    // Constructor: inicializa las cuatro colas de prioridad.
    public ColaConPrioridades() {
        this.adultoMayor = new ColaCliente();
        this.mujerEmbarazada = new ColaCliente();
        this.personaConNecesidadesEspeciales = new ColaCliente();
        this.clienteRegular = new ColaCliente();
    }

    // Retorna la cola de adultos mayores.
    public ColaCliente getAdultoMayor() {
        return this.adultoMayor;
    }

    // Agrega un cliente a la cola correspondiente según la prioridad indicada.
    public void agregarCliente(String nombre , int prioridad) {
        switch (prioridad) {
            case 1:
                this.adultoMayor.agregarCliente(nombre);
                break;
            case 2:
                this.mujerEmbarazada.agregarCliente(nombre);
                break;
            case 3:
                this.personaConNecesidadesEspeciales.agregarCliente(nombre);
                break;
            case 4:
                this.clienteRegular.agregarCliente(nombre);
        }
    }

    // Atiende (elimina) al siguiente cliente según el orden de prioridad.
    public void atenderCliente() {
        if (!this.adultoMayor.vacia()) {
            this.adultoMayor.sacar();
        } else if (!this.mujerEmbarazada.vacia()) {
            this.mujerEmbarazada.sacar();
        } else if (!this.personaConNecesidadesEspeciales.vacia()){
            this.personaConNecesidadesEspeciales.sacar();
        } else if (!this.clienteRegular.vacia()) {
            this.clienteRegular.sacar();
        }
    }

    // Retorna true si todas las colas están vacías, false en caso contrario.
    public boolean vacia() {
        if (this.adultoMayor.vacia() && this.mujerEmbarazada.vacia() && this.personaConNecesidadesEspeciales.vacia() && this.clienteRegular.vacia()) {
            return true;
        }
        return false;
    }

    // Retorna el siguiente cliente a ser atendido según prioridad.
    public NodoCliente getSiguienteCliente() {
        if (!this.adultoMayor.vacia()) {
            return this.adultoMayor.getPrimerCliente();
        } else if (!this.mujerEmbarazada.vacia()) {
            return this.mujerEmbarazada.getPrimerCliente();
        } else if (!this.personaConNecesidadesEspeciales.vacia()){
            return this.personaConNecesidadesEspeciales.getPrimerCliente();
        } else if (!this.clienteRegular.vacia()) {
            return this.clienteRegular.getPrimerCliente();
        }
        return null;
    }

    // Retorna un String con los nombres de todos los clientes en la cola, en orden de prioridad.
    public String mostrarClientes(NodoCliente nodo , int i) {
        ColaCliente[] colas = {this.adultoMayor , this.mujerEmbarazada , this.personaConNecesidadesEspeciales , this.clienteRegular};
        String cola = "";
            if (!colas[i].vacia()) {
                if (i == colas.length - 1 && nodo.getSiguienteCliente() == null) {
                    cola += " <- " + nodo.getNombre();
                } else if (nodo.getSiguienteCliente() == null) {
                    cola += " <- " + nodo.getNombre() + mostrarClientes(colas[i + 1].getPrimerCliente() , i + 1);
                } else {
                    cola += " <- " + nodo.getNombre() + mostrarClientes(nodo.getSiguienteCliente() , i);
                }
            } else if (i < colas.length - 1) {
                cola += mostrarClientes(colas[i + 1].getPrimerCliente() , i + 1);
            }
        return cola;
    }
}
