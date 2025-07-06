/**
 * Nodo para el árbol de restaurantes, contiene nombre, menú y referencias a hijos.
 */
public class NodoRestaurante {
    private String nombre;
    private ListaMenu menu;
    private NodoRestaurante izquierdo;
    private NodoRestaurante derecho;

    public NodoRestaurante(String nombre , ListaMenu menu) {
        this.nombre = nombre;
        this.menu = menu;
        this.izquierdo = null;
        this.derecho = null;
    }

    public void setIzquierdo(NodoRestaurante izquierdo) {
        this.izquierdo = izquierdo;
    }
    public void setDerecho(NodoRestaurante derecho) {
        this.derecho = derecho;
    }

    /**
     * Devuelve el nombre del restaurante.
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el menú del restaurante.
     */
    public ListaMenu getMenu() {
        return this.menu;
    }
    /**
     * Devuelve el hijo izquierdo.
     */
    public NodoRestaurante getIzquierdo() {
        return this.izquierdo;
    }
    /**
     * Devuelve el hijo derecho.
     */
    public NodoRestaurante getDerecho() {
        return this.derecho;
    }
}
