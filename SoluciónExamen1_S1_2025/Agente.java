public class Agente {
    private Mensaje[] mensajes;
    private int cantidadDeMensajes;
    private int id;
    private static Cola cola = new Cola();
    private int[] ultimaCasillaReportada;

    private int coordX;
    private int coordY;
    private int coordXPrevia;
    private int coordYPrevia;
    private static Plato plato = new Plato();
    private int[] casillaConMayorComidaReportada;

    public Agente(int id , int coordX , int coordY) {
        this.mensajes = new Mensaje[50];
        this.cantidadDeMensajes = 0;
        this.id = id;
        this.ultimaCasillaReportada = new int[3];

        this.coordX = coordX;
        this.coordY = coordY;
        this.coordXPrevia = -1;
        this.coordYPrevia = -1;
        this.casillaConMayorComidaReportada = new int[3];
        for (int i = 0 ; i < this.casillaConMayorComidaReportada.length ; i++) {
            this.casillaConMayorComidaReportada[i] = -1;
        }
    }

    public void setCasillaConMayorComidaReportada(int[] casillaConMayorComidaReportada) {
        this.casillaConMayorComidaReportada = casillaConMayorComidaReportada;
    }

    public boolean recibirMensaje() {
        Mensaje mensajeRecibido = cola.devolverMensaje(this.id);
        if (mensajeRecibido != null) {
            this.mensajes[this.cantidadDeMensajes] = mensajeRecibido;
            this.cantidadDeMensajes++;
            return true;
        }
        return false;
    }

    public void crearMensaje(int[] contenido) {
        this.mensajes[this.cantidadDeMensajes] = new Mensaje(this.id, this.id, -1 , contenido);
        this.cantidadDeMensajes++;
    }

    public boolean debeEnviarMensaje(int[] nuevaCasilla) {
        for (int i = 0; i < 3; i++) {
            if (nuevaCasilla[i] != ultimaCasillaReportada[i]) {
                return true;
            }
        }
        return false;
    }

    public void actualizarUltimaCasillaReportada(int[] nuevaCasilla) {
        for (int i = 0; i < 3; i++) {
            ultimaCasillaReportada[i] = nuevaCasilla[i];
        }
    }

    public void enviarMensaje(int idDestinatario) {
        Mensaje mensajeOriginal = this.mensajes[this.cantidadDeMensajes - 1];
        Mensaje mensajeCopia = new Mensaje(
            mensajeOriginal.getIdFuente(),
            mensajeOriginal.getIdEmisor(),
            idDestinatario,
            mensajeOriginal.getContenido());
        Agente.cola.añadirMensaje(mensajeCopia);
    }

    public Mensaje getMensaje() {
        if (this.cantidadDeMensajes > 0) {
            return this.mensajes[this.cantidadDeMensajes - 1];
        }
        return new Mensaje(this.id, this.id, -1 , new int[] {0,0,0});
    }
    public int getCoordX() {
        return this.coordX;
    }
    public int getCoordY() {
        return this.coordY;
    }
    public int getId() {
        return this.id;
    }
    public Cola getCola() {
        return Agente.cola;
    }
    public int[] getCasillaConMayorComidaReportada() {
        return this.casillaConMayorComidaReportada;
    }


    public int[] direccionParaMoverse() {
        final int IZQUIERDA = 0;
        final int DERECHA = 1;
        final int ABAJO = 0;
        final int ARRIBA = 1;
        int horizontal;
        int vertical;
        if (this.getCasillaConMayorComidaReportada()[0] > this.getCoordX()) {
            horizontal = DERECHA;
        } else if (this.getCasillaConMayorComidaReportada()[0] < this.getCoordX()) {
            horizontal = IZQUIERDA;
        } else {
            horizontal = -1;
        }
        if (this.getCasillaConMayorComidaReportada()[1] > this.getCoordY()) {
            vertical = ARRIBA;
        } else if (this.getCasillaConMayorComidaReportada()[1] < this.getCoordY()) {
            vertical = ABAJO;
        } else {
            vertical = -1;
        }
        return new int[] {horizontal , vertical};
    }

    public void moverse(int horizontal , int vertical) {
        this.coordXPrevia = this.coordX;
        this.coordYPrevia = this.coordY;
        if (horizontal == 0) {
            this.coordX--;
        } else if (horizontal == 1) {
            this.coordX++;
        }
        if (vertical == 0) {
            this.coordY--;
        } else if (vertical == 1) {
            this.coordY++;
        }
    }

    public boolean verificarMovimiento() {
        if (this.coordXPrevia != this.coordX || this.coordYPrevia != this.coordY) {
            return true;
        }
        return false;
    }

    public int[] buscarComida() {
        int coordXMax = this.coordX;
        int coordYMax = this.coordY;
        int comidaMax = 0;
        for (int y = this.coordY + 1 ; y >= this.coordY - 1 ; y--) {
            for (int x = this.coordX - 1 ; x <= this.coordX + 1 ; x++) {
                if (Agente.plato.getComida()[y][x] > comidaMax) {
                    coordXMax = x;
                    coordYMax = y;
                    comidaMax = Agente.plato.getComida()[y][x];
                }
            }
        }
        return new int[] {coordXMax , coordYMax , comidaMax};
    }

    public Plato getPlato() {
        return plato;
    }

    public void mostrarEstadoActual() {
        System.out.println("Insecto " + this.id + ":");
        System.out.println("Posición actual: (" + this.getCoordX() + " , " + this.getCoordY() + ")");
        System.out.println("Casilla de vecindad con mayor comida (" + this.buscarComida()[2] + "): (" + this.buscarComida()[0] + " , " + this.buscarComida()[1] + ")");
    }
}
