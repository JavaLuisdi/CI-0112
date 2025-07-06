/**
 * Clase que representa una lista de platillos (menú) de un restaurante.
 */
public class ListaMenu {
    private NodoPlatillo primer;

    public ListaMenu(NodoPlatillo primer) {
        this.primer = primer;
    }

    /**
     * Devuelve el primer nodo del menú.
     */
    public NodoPlatillo getPrimer() {
        return this.primer;
    }

    /**
     * Establece el primer nodo del menú.
     */
    public void setPrimer(NodoPlatillo primer) {
        this.primer = primer;
    }

    private Platillo platilloMasCaro;
    /**
     * Devuelve el platillo más caro del menú (con IVA).
     */
    public Platillo platilloMasCaro() {
        platilloMasCaro = new Platillo(null , 0);
        return buscarPlatilloMasCaro(this.primer);
    }
    private Platillo buscarPlatilloMasCaro(NodoPlatillo nodo) {
        if (nodo == null) {
            return platilloMasCaro;
        }
        if (nodo.getPlatillo().getPrecioMasIVA() > platilloMasCaro.getPrecioMasIVA()) {
            platilloMasCaro = nodo.getPlatillo();
        }
        return buscarPlatilloMasCaro(nodo.getSiguienteNodo());
    }

    /**
     * Calcula el precio total del menú (sumando todos los platillos con IVA).
     */
    public float precioTotalDelMenu() {
        return calcularPrecioTotalDelMenu(this.primer);
    }
    private float calcularPrecioTotalDelMenu(NodoPlatillo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getPlatillo().getPrecioMasIVA() + calcularPrecioTotalDelMenu(nodo.getSiguienteNodo());
    }
}
