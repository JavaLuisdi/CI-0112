public class Cola {
    private Nodo primerNodo;

    public Cola() {
        this.primerNodo = null;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public void insertarAlFinal(Nodo nodo) {
        if (this.primerNodo == null) {
            this.primerNodo = nodo;
        } else {
            getUltimoNodo(this.primerNodo).setSiguienteNodo(nodo);
        }
    }

    public Nodo getUltimoNodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.getSiguienteNodo() == null) {
            return nodo;
        }
        return getUltimoNodo(nodo.getSiguienteNodo());
    }

    public void eliminarPrimerNodo() {
        if (this.primerNodo != null) {
            Nodo nuevoPrimerNodo = this.primerNodo.getSiguienteNodo();
            setPrimerNodo(nuevoPrimerNodo);            
        }
    }
}
