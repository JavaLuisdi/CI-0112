public class Mascota {
    private String nombre;
    private int posicionCola;

    public Mascota(String nombre , int posicionCola) {
        this.nombre = nombre;
        this.posicionCola = posicionCola;
    }

    public void setPosicionCola(int posicionCola) {
        this.posicionCola = posicionCola;
    }

    public String getNombre() {
        return this.nombre;
    }
    public int getPosicionCola() {
        return this.posicionCola;
    }
}
