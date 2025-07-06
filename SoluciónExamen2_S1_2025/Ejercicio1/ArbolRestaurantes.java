import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArbolRestaurantes {
    private NodoRestaurante raiz;

    /**
     * Constructor de la clase ArbolRestaurantes.
     * @param raiz Nodo raíz del árbol.
     */
    public ArbolRestaurantes(NodoRestaurante raiz) {
        this.raiz = raiz;
    }

    /**
     * Devuelve la raíz del árbol de restaurantes.
     * @return NodoRestaurante raíz.
     */
    public NodoRestaurante getRaiz() {
        return this.raiz;
    }

    /**
     * Agrega un nodo de restaurante al árbol en la posición correspondiente.
     * @param nodoAgregar NodoRestaurante a agregar.
     */
    public void agregarNodo(NodoRestaurante nodoAgregar) {
        NodoRestaurante nodoPadre = posicionParaAgregarNodo(nodoAgregar , this.raiz);
        boolean lado = compararNombres(nodoAgregar , nodoPadre);
        if (lado) {
            nodoPadre.setDerecho(nodoAgregar);
        } else {
            nodoPadre.setIzquierdo(nodoAgregar);
        }
    }

    /**
     * Busca la posición donde se debe agregar un nuevo nodo en el árbol.
     * @param nodoAgregar NodoRestaurante a agregar.
     * @param nodoEnArbol Nodo actual en el árbol.
     * @return NodoRestaurante donde se debe agregar el nuevo nodo.
     */
    private NodoRestaurante posicionParaAgregarNodo(NodoRestaurante nodoAgregar , NodoRestaurante nodoEnArbol) {
        boolean lado = compararNombres(nodoAgregar , nodoEnArbol);
        if (lado) {
            if (nodoEnArbol.getDerecho() == null) {
                return nodoEnArbol;
            }
            return posicionParaAgregarNodo(nodoAgregar , nodoEnArbol.getDerecho());
        } else {
            if (nodoEnArbol.getIzquierdo() == null) {
                return nodoEnArbol;
            }
            return posicionParaAgregarNodo(nodoAgregar , nodoEnArbol.getIzquierdo());
        }
    }

    /**
     * Compara los nombres de dos nodos restaurante para decidir su posición en el árbol.
     * @param nodoAgregar Nodo a agregar.
     * @param nodoEnArbol Nodo actual en el árbol.
     * @return true si va a la derecha, false si va a la izquierda.
     */
    private boolean compararNombres(NodoRestaurante nodoAgregar , NodoRestaurante nodoEnArbol) {
        final boolean IZQUIERDA = false;
        final boolean DERECHA = true;
        int indiceLetraNodoAgregar , indiceLetraNodoEnArbol;
        for (int i = 0 ; i < nodoAgregar.getNombre().length() && i < nodoEnArbol.getNombre().length() ; i++) {
            indiceLetraNodoAgregar = nodoAgregar.getNombre().charAt(i);
            indiceLetraNodoEnArbol = nodoEnArbol.getNombre().charAt(i);
            if (indiceLetraNodoAgregar < indiceLetraNodoEnArbol) {
                return IZQUIERDA;
            } else if (indiceLetraNodoAgregar > indiceLetraNodoEnArbol) {
                return DERECHA;
            }
        }
        if (nodoAgregar.getNombre().length() < nodoEnArbol.getNombre().length()) {
            return IZQUIERDA;
        }
        return DERECHA;
    }

    /**
     * Busca y retorna el menú más barato entre todos los restaurantes del árbol.
     * @return ListaMenu con el menor precio total.
     */
    private ListaMenu menuMasBarato;
    public ListaMenu menuMasBarato() {
        if (this.raiz == null) {
            return null;
        }
        menuMasBarato = new ListaMenu(this.raiz.getMenu().getPrimer());
        buscarMenuMasBarato(this.raiz);
        return menuMasBarato;
    }

    /**
     * Recorre el árbol para encontrar el menú más barato.
     * @param nodo Nodo actual del árbol.
     */
    private void buscarMenuMasBarato(NodoRestaurante nodo) {
        if (nodo.getMenu().precioTotalDelMenu() < menuMasBarato.precioTotalDelMenu()) {
            menuMasBarato = nodo.getMenu();
        }
        if (nodo.getIzquierdo() != null) {
            buscarMenuMasBarato(nodo.getIzquierdo());
        }
        if (nodo.getDerecho() != null) {
            buscarMenuMasBarato(nodo.getDerecho());
        }
    }

    /**
     * Carga los restaurantes y sus menús desde un archivo de texto.
     * @param rutaArchivo Ruta al archivo de texto.
     * @return ArbolRestaurantes construido a partir del archivo.
     */
    public static ArbolRestaurantes cargarDesdeArchivo(String rutaArchivo) {
        ArbolRestaurantes arbol = null;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            java.util.Map<String, ListaMenu> mapaMenus = new java.util.HashMap<>();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("/");
                if (partes.length != 3) continue;
                String nombreRest = partes[0].trim();
                String nombreItem = partes[1].trim();
                float precio = Float.parseFloat(partes[2].trim());
                Platillo platillo = new Platillo(nombreItem, precio);
                NodoPlatillo nodoPlatillo = new NodoPlatillo(platillo);
                if (!mapaMenus.containsKey(nombreRest)) {
                    mapaMenus.put(nombreRest, new ListaMenu(null));
                }
                ListaMenu menu = mapaMenus.get(nombreRest);
                // Insertar al final de la lista
                if (menu.getPrimer() == null) {
                    menu.setPrimer(nodoPlatillo);
                } else {
                    NodoPlatillo actual = menu.getPrimer();
                    while (actual.getSiguienteNodo() != null) {
                        actual = actual.getSiguienteNodo();
                    }
                    actual.setSiguienteNodo(nodoPlatillo);
                }
            }
            NodoRestaurante raiz = null;
            for (String nombreRest : mapaMenus.keySet()) {
                NodoRestaurante nodo = new NodoRestaurante(nombreRest, mapaMenus.get(nombreRest));
                if (raiz == null) {
                    raiz = nodo;
                    arbol = new ArbolRestaurantes(raiz);
                } else {
                    arbol.agregarNodo(nodo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arbol;
    }

    /**
     * Método principal para demostrar funcionalidades:
     * - Llenar restaurantes desde archivo
     * - Obtener platillo más caro de un restaurante
     * - Calcular menú más barato entre todos los restaurantes
     */
    public static void main(String[] args) {
        String rutaArchivo = "restaurantes.txt";
        ArbolRestaurantes arbol = ArbolRestaurantes.cargarDesdeArchivo(rutaArchivo);
        if (arbol == null) {
            System.out.println("No se pudo cargar el árbol de restaurantes.");
            return;
        }
        // Buscar restaurante específico
        String nombreRestBuscado = "Restaurante A";
        NodoRestaurante actual = arbol.getRaiz();
        NodoRestaurante encontrado = buscarRestaurantePorNombre(actual, nombreRestBuscado);
        if (encontrado != null) {
            Platillo caro = encontrado.getMenu().platilloMasCaro();
            System.out.println("Platillo más caro (con IVA) de " + nombreRestBuscado + ": " + caro.getNombre() + " - ¢" + caro.getPrecioMasIVA());
        } else {
            System.out.println("Restaurante no encontrado: " + nombreRestBuscado);
        }
        // Menú más barato entre todos los restaurantes
        ListaMenu menuBarato = arbol.menuMasBarato();
        System.out.println("Precio total del menú más barato: ¢" + menuBarato.precioTotalDelMenu());
    }

    /**
     * Busca un restaurante por nombre en el árbol (búsqueda binaria).
     * @param nodo Nodo actual del árbol.
     * @param nombre Nombre del restaurante a buscar.
     * @return NodoRestaurante encontrado o null si no existe.
     */
    public static NodoRestaurante buscarRestaurantePorNombre(NodoRestaurante nodo, String nombre) {
        if (nodo == null) return null;
        int cmp = nombre.compareTo(nodo.getNombre());
        if (cmp == 0) return nodo;
        if (cmp < 0) return buscarRestaurantePorNombre(nodo.getIzquierdo(), nombre);
        return buscarRestaurantePorNombre(nodo.getDerecho(), nombre);
    }
}
