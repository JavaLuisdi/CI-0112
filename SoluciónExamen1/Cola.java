public class Cola {
    private Mensaje[] mensajes;
    private int cantidadDeMensajes;

    public Cola() {
        this.mensajes = new Mensaje[1000];
        this.cantidadDeMensajes = 0;
    }

    public void añadirMensaje(Mensaje mensaje) {
        this.mensajes[this.cantidadDeMensajes] = mensaje;
        this.cantidadDeMensajes++;
    }

    public boolean verificarId(int id) {
        if (this.mensajes[0] != null && this.mensajes[0].getIdDestinatario() == id) {
            return true;
        }
        return false;
    }

    public Mensaje devolverMensaje(int id) {
        Mensaje mensaje = null;
        if (verificarId(id)) {
            mensaje = this.mensajes[0];
            for (int i = 0 ; i < this.cantidadDeMensajes - 1 ; i++) {
                this.mensajes[i] = this.mensajes[i+1];
            }
            this.mensajes[this.cantidadDeMensajes - 1] = null;
            this.cantidadDeMensajes--;
            return mensaje;
        }
        return mensaje;
    }

    public int getCantidadDeMensajes() {
        return this.cantidadDeMensajes;
    }

    public void mostrarMensajes() {
        for (int i = 0 ; i < this.cantidadDeMensajes ; i++) {
            System.out.println("Mensaje " + (i + 1) + ": " + this.mensajes[i].getContenido()[0] + " " + this.mensajes[i].getContenido()[1] + " " + this.mensajes[i].getContenido()[2] + " " + this.mensajes[i].getIdDestinatario());
        }
    }
}
