public class Nodo {
    private Mascota mascota;

    private Nodo siguienteNodo;


    public Nodo (Mascota mascota) {
        this.mascota = mascota;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Mascota getMascota() {
        return this.mascota;
    }
    public Nodo getSiguienteNodo() {
        return this.siguienteNodo;
    }


    private Nodo izquierdo;
    private Nodo derecho;

    public void setNodoLado(Nodo nodo , boolean lado) {
        if (lado) {
            this.derecho = nodo;
        } else {
            this.izquierdo = nodo;
        }
    }

    public Nodo getNodoLado(boolean lado) {
        if (lado) {
            return this.izquierdo;
        }
        return this.derecho;
    }
}