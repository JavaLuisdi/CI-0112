public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo nodo en el árbol binario.
     * Si el árbol está vacío, el nodo se convierte en la raíz.
     * Si no, busca la posición adecuada en el árbol y coloca el nodo
     * como hijo izquierdo o derecho según el resultado de la comparación de nombres.
     *
     * @param nodo El nodo a insertar en el árbol binario.
     */
    public void insertarNodo(Nodo nodo) {
        if (this.raiz == null) {
            this.raiz = nodo;
        } else {
        posicionAdecuada(nodo , raiz).setNodoLado(nodo, compararNombres(nodo , posicionAdecuada(nodo , raiz) , 0));
        }
    }

    /**
     * Encuentra la posición adecuada en el árbol binario para insertar un nodo dado,
     * comparándolo con otro nodo de referencia.
     *
     * @param nodoPorOrdenar El nodo que se desea insertar o posicionar en el árbol.
     * @param nodoComparacion El nodo actual del árbol con el que se compara para determinar la posición.
     * @return El nodo de comparación si la posición adecuada está vacía, o el nodo hijo correspondiente
     *         donde se debe continuar la búsqueda.
     */
    public Nodo posicionAdecuada(Nodo nodoPorOrdenar , Nodo nodoComparacion) {
        if (nodoComparacion.getNodoLado(compararNombres(nodoPorOrdenar , nodoComparacion , 0)) == null) {
            return nodoComparacion;
        }
        return nodoComparacion.getNodoLado(compararNombres(nodoPorOrdenar , nodoComparacion , 0));
    }

    /**
     * Compara los nombres de las mascotas contenidas en dos nodos carácter por carácter a partir del índice especificado.
     * 
     * @param nodoPorOrdenar     El nodo cuyo nombre de mascota se va a comparar.
     * @param nodoComparacion    El nodo con el que se compara el nombre de la mascota.
     * @param n                  El índice del carácter actual a comparar en los nombres.
     * @return                   {@code true} si el nombre de la mascota en nodoPorOrdenar es mayor o igual al de nodoComparacion
     *                           según el orden lexicográfico, o si ambos nombres son iguales; {@code false} si es menor.
     */
    public boolean compararNombres(Nodo nodoPorOrdenar , Nodo nodoComparacion , int n) {
        if (nodoPorOrdenar.getMascota().getNombre().equals(nodoComparacion.getMascota().getNombre())) {
            return true;
        }
        int indicePrimerLetraNodoPorOrdenar = nodoPorOrdenar.getMascota().getNombre().charAt(n);
        int indicePrimerLetraNodoComparacion = nodoComparacion.getMascota().getNombre().charAt(n);
        if (indicePrimerLetraNodoPorOrdenar < indicePrimerLetraNodoComparacion) {
            return false;
        } else if (indicePrimerLetraNodoPorOrdenar > indicePrimerLetraNodoComparacion) {
            return true;
        }
        return compararNombres(nodoPorOrdenar , nodoComparacion , n + 1);
    }

    /**
     * Busca recursivamente un nodo en el árbol binario cuyo nombre de mascota coincida con el nombre proporcionado.
     *
     * @param nombre El nombre de la mascota a buscar.
     * @param nodoComparacion El nodo actual desde el cual se inicia la búsqueda.
     * @return El nodo que contiene la mascota con el nombre especificado, o {@code null} si no se encuentra.
     */
    public Nodo buscarPorNombre(String nombre , Nodo nodoComparacion) {
        if (nodoComparacion == null) {
            return null;
        }
        if (nodoComparacion.getMascota().getNombre().equals(nombre)) {
            return nodoComparacion;
        }
        Nodo nodoIzquierdo = buscarPorNombre(nombre , nodoComparacion.getNodoLado(false));
        if (nodoIzquierdo != null) {
            return nodoIzquierdo;
        }
        return buscarPorNombre(nombre , nodoComparacion.getNodoLado(true));
    }

    /**
     * Busca y retorna el nodo padre de un nodo hijo específico en un árbol binario.
     *
     * @param nodoHijo El nodo cuyo padre se desea encontrar.
     * @param nodoComparacion El nodo actual desde donde se inicia la búsqueda (normalmente la raíz).
     * @return El nodo padre de nodoHijo si se encuentra; de lo contrario, retorna null.
     */
    public Nodo buscarNodoPadre(Nodo nodoHijo , Nodo nodoComparacion) {
        if (nodoComparacion == null) {
            return null;
        }
        Nodo izquierdo = nodoComparacion.getNodoLado(false);
        Nodo derecho = nodoComparacion.getNodoLado(true);
        boolean esPadreIzquierdo = izquierdo != null && izquierdo.getMascota().getNombre().equals(nodoHijo.getMascota().getNombre());
        boolean esPadreDerecho = derecho != null && derecho.getMascota().getNombre().equals(nodoHijo.getMascota().getNombre());
        if (esPadreIzquierdo || esPadreDerecho) {
            return nodoComparacion;
        }
        Nodo nodoIzquierdo = buscarNodoPadre(nodoHijo , izquierdo);
        if (nodoIzquierdo != null) {
            return nodoIzquierdo;
        }
        return buscarNodoPadre(nodoHijo , derecho);
    }

    /**
     * Elimina un nodo del árbol binario.
     * Si el nodo a eliminar es la raíz, ajusta la raíz según corresponda.
     * Si el nodo tiene dos hijos, lo reemplaza por su sucesor inorden.
     * Si el nodo tiene un solo hijo o ninguno, ajusta el enlace del padre.
     *
     * @param nodo El nodo a eliminar del árbol binario.
     */
    public void eliminarNodo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        Nodo padre = buscarNodoPadre(nodo, raiz);

        // Caso 1: Nodo sin hijos (hoja)
        if (nodo.getNodoLado(false) == null && nodo.getNodoLado(true) == null) {
            if (padre == null) {
                raiz = null;
            } else if (padre.getNodoLado(false) == nodo) {
                padre.setNodoLado(null, false);
            } else {
                padre.setNodoLado(null, true);
            }
        }
        // Caso 2: Nodo con un solo hijo
        else if (nodo.getNodoLado(false) == null || nodo.getNodoLado(true) == null) {
            Nodo hijo = (nodo.getNodoLado(false) != null) ? nodo.getNodoLado(false) : nodo.getNodoLado(true);
            if (padre == null) {
                raiz = hijo;
            } else if (padre.getNodoLado(false) == nodo) {
                padre.setNodoLado(hijo, false);
            } else {
                padre.setNodoLado(hijo, true);
            }
        }
        // Caso 3: Nodo con dos hijos
        else {
            // Buscar sucesor inorden (el más pequeño del subárbol derecho)
            Nodo sucesor = nodo.getNodoLado(true);
            Nodo padreSucesor = nodo;
            while (sucesor.getNodoLado(false) != null) {
                padreSucesor = sucesor;
                sucesor = sucesor.getNodoLado(false);
            }
            // Copiar los datos del sucesor al nodo a eliminar
            nodo.setMascota(sucesor.getMascota());
            // Eliminar el sucesor
            if (padreSucesor.getNodoLado(false) == sucesor) {
                padreSucesor.setNodoLado(sucesor.getNodoLado(true), false);
            } else {
                padreSucesor.setNodoLado(sucesor.getNodoLado(true), true);
            }
        }
    }
}
