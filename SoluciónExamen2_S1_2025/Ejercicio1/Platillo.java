/**
 * Clase que representa un platillo con nombre, precio y precio con IVA.
 */
public class Platillo {
    private String nombre;
    private float precio;
    private float precioMasIVA;

    public Platillo(String nombre , float precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioMasIVA = (float)(precio * 1.13);
    }

    /**
     * Devuelve el nombre del platillo.
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el precio sin impuestos.
     */
    public float getPrecio() {
        return this.precio;
    }
    /**
     * Devuelve el precio con IVA.
     */
    public float getPrecioMasIVA() {
        return this.precioMasIVA;
    }
}