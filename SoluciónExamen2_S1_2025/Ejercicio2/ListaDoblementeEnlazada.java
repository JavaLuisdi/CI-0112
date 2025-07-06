import java.util.Random;

public class ListaDoblementeEnlazada {
    private Nodo primero;

    /**
     * Constructor de la lista doblemente enlazada.
     * @param primero Nodo inicial de la lista.
     */
    public ListaDoblementeEnlazada(Nodo primero) {
        this.primero = primero;
    }

    /**
     * Agrega un nodo al final de la lista.
     * @param nodo Nodo a agregar.
     */
    public void agregarNodo(Nodo nodo) {
        if (this.primero == null) {
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
            this.primero = nodo;
        } else {
            Nodo ultimoNodo = getUltimo();
            ultimoNodo.setSiguiente(nodo);
            nodo.setAnterior(ultimoNodo);
            nodo.setSiguiente(null);
        }
    }

    /**
     * Devuelve el último nodo de la lista.
     * @return Nodo final de la lista.
     */
    public Nodo getUltimo() {
        return buscarUltimo(this.primero);
    }

    /**
     * Busca recursivamente el último nodo a partir de uno dado.
     * @param nodo Nodo desde donde buscar.
     * @return Nodo final.
     */
    private Nodo buscarUltimo(Nodo nodo) {
        if (nodo.getSiguiente() == null) {
            return nodo;
        }
        return buscarUltimo(nodo.getSiguiente());
    }
    
    /**
     * Extrae los nodos que rompen el orden ascendente y los coloca en una nueva lista.
     * @return ListaDoblementeEnlazada con los nodos extraídos.
     */
    public ListaDoblementeEnlazada hacerListaAscendente() {
        ListaDoblementeEnlazada listaExtraida = extraerListaNoAscendente(this.primero , new ListaDoblementeEnlazada(null));
        return listaExtraida;
    }

    /**
     * Recursivamente extrae nodos que no cumplen el orden ascendente.
     * @param nodoComparar Nodo actual a comparar.
     * @param listaExtraida Lista donde se agregan los nodos extraídos.
     * @return ListaDoblementeEnlazada con los nodos extraídos.
     */
    private ListaDoblementeEnlazada extraerListaNoAscendente(Nodo nodoComparar , ListaDoblementeEnlazada listaExtraida) {
        if (nodoComparar == null || nodoComparar.getSiguiente() == null) {
            return listaExtraida;
        } else if (nodoComparar.getElemento() > nodoComparar.getSiguiente().getElemento()) {
            Nodo nodoEliminado = nodoComparar.getSiguiente();
            if (nodoComparar.getSiguiente().getSiguiente() != null) {
                nodoComparar.setSiguiente(nodoComparar.getSiguiente().getSiguiente());
                nodoComparar.getSiguiente().setAnterior(nodoComparar);
            } else {
                nodoComparar.setSiguiente(null);
            }
            listaExtraida.agregarNodo(nodoEliminado);
            return extraerListaNoAscendente(nodoComparar , listaExtraida);
        }
        return extraerListaNoAscendente(nodoComparar.getSiguiente() , listaExtraida);
    }

    /**
     * Ordena la lista de forma descendente (de mayor a menor).
     */
    private void ordenarDescendientemente() {
        posicionarNodosDescendientemente(this.primero);
    }

    /**
     * Reubica nodos para ordenar la lista de forma descendente.
     * @param nodo Nodo actual a comparar.
     */
    private void posicionarNodosDescendientemente(Nodo nodo) {
        if (nodo.getSiguiente() == null) {
            return;
        } else if (nodo.getElemento() < nodo.getSiguiente().getElemento()) {
            Nodo nodoMenor = nodo;
            Nodo nodoMayor = nodo.getSiguiente();
            if (nodo.getAnterior() != null && nodo.getSiguiente().getSiguiente() != null) {  
                nodoMenor.setSiguiente(nodoMayor.getSiguiente());
                nodoMenor.getAnterior().setSiguiente(nodoMayor);
                nodoMayor.setAnterior(nodoMenor.getAnterior());
                nodoMayor.getSiguiente().setAnterior(nodoMenor);
                nodoMenor.setAnterior(nodoMayor);
                nodoMayor.setSiguiente(nodoMenor);
            } else if (nodo.getAnterior() == null) {
                nodoMenor.setSiguiente(nodoMayor.getSiguiente());
                nodoMayor.setAnterior(null);
                nodoMayor.getSiguiente().setAnterior(nodoMenor);
                nodoMenor.setAnterior(nodoMayor);
                nodoMayor.setSiguiente(nodoMenor);
                this.primero = nodoMayor;
            } else {
                nodoMenor.setSiguiente(null);
                nodoMenor.getAnterior().setSiguiente(nodoMayor);
                nodoMayor.setAnterior(nodoMenor.getAnterior());
                nodoMenor.setAnterior(nodoMayor);
                nodoMayor.setSiguiente(nodoMenor);
            }
            posicionarNodosDescendientemente(this.primero);
        }
        if (nodo.getSiguiente() == null || nodo.getSiguiente().getSiguiente() == null) {
            return;
        }
        posicionarNodosDescendientemente(nodo.getSiguiente());
    }

    /**
     * Muestra la lista en consola.
     */
    public void mostrarLista() {
        System.out.println(escribirLista(this.primero));
    }

    /**
     * Construye una representación en texto de la lista desde un nodo dado.
     * @param nodo Nodo desde donde escribir.
     * @return String con los elementos de la lista.
     */
    private String escribirLista(Nodo nodo) {
        if (nodo.getSiguiente() == null) {
            return String.valueOf(nodo.getElemento());
        }
        return String.valueOf(nodo.getElemento()) + " , " + escribirLista(nodo.getSiguiente());
    }

    /**
     * Método principal de prueba para la lista doblemente enlazada.
     */
    public static void main(String[] args) {
        Random random = new Random();
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada(new Nodo(random.nextInt(11)));
        for (int i = 0 ; i < 9 ; i++) {
            Nodo nodoNuevo = new Nodo(random.nextInt(11));
            lista.getUltimo().setSiguiente(nodoNuevo);
        }
        System.out.print("Lista original: ");
        lista.mostrarLista();
        ListaDoblementeEnlazada listaExtraida = lista.hacerListaAscendente();
        System.out.print("Lista ascendente: ");
        lista.mostrarLista();
        System.out.print("Lista extraida: ");
        listaExtraida.mostrarLista();
        listaExtraida.ordenarDescendientemente();
        System.out.print("Lista extraida ordenada descendientemente: ");
        listaExtraida.mostrarLista();
    }
}