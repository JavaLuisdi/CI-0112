public class Simulación {
    static Agente[] insectos;

    public static boolean ningúnInsectoMovido() {
        for (int i = 0 ; i < insectos.length ; i++) {
            if (insectos[i].verificarMovimiento()) {
                return false;
            }
        }
        return true;
    }
    public static boolean ningúnMensajeEnCola() {
        if (insectos[0].getCola().getCantidadDeMensajes() == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        insectos = new Agente[5];
        final int IZQUIERDA = 0;
        final int DERECHA = 1;
        final int ABAJO = 0;
        final int ARRIBA = 1;
        int horizontal;
        int vertical;

        for (int i = 0 ; i < insectos.length ; i++) {
            insectos[i] = new Agente(i+1, 166 * (i + 1), 166 * (i + 1));
        }
        do {
            for (int i = 0 ; i < insectos.length ; i++) {
                System.out.println("Insecto " + (i+1) + ":");
                System.out.println("Posición actual: (" + insectos[i].getCoordX() + " , " + insectos[i].getCoordY() + ")");
                System.out.println("Casilla de vecindad con mayor comida (" + insectos[i].buscarComida()[2] + "): (" + insectos[i].buscarComida()[0] + " , " + insectos[i].buscarComida()[1] + ")");
                while (insectos[i].recibirMensaje()) {
                    if (insectos[i].getMensaje().getContenido()[2] > insectos[i].buscarComida()[2] && insectos[i].getMensaje().getContenido()[2] > insectos[i].getCasillaConMayorComidaReportada()[2]) {
                        insectos[i].setCasillaConMayorComidaReportada(insectos[i].getMensaje().getContenido());
                    }
                }
                if (insectos[i].getCasillaConMayorComidaReportada()[2] > insectos[i].buscarComida()[2]) {
                    System.out.println("Se mueve hacia casilla (" + insectos[i].getCasillaConMayorComidaReportada()[0] + " , " + insectos[i].getCasillaConMayorComidaReportada()[1] + ").");
                    if (insectos[i].getCasillaConMayorComidaReportada()[0] > insectos[i].getCoordX()) {
                        horizontal = DERECHA;
                    } else if (insectos[i].getCasillaConMayorComidaReportada()[0] < insectos[i].getCoordX()) {
                        horizontal = IZQUIERDA;
                    } else {
                        horizontal = -1;
                    }
                    if (insectos[i].getCasillaConMayorComidaReportada()[1] > insectos[i].getCoordY()) {
                        vertical = ARRIBA;
                    } else if (insectos[i].getCasillaConMayorComidaReportada()[1] < insectos[i].getCoordY()) {
                        vertical = ABAJO;
                    } else {
                        vertical = -1;
                    }
                    insectos[i].moverse(horizontal, vertical);
                } else {
                    if (insectos[i].getCasillaConMayorComidaReportada()[2] < insectos[i].buscarComida()[2]) {
                        insectos[i].crearMensaje(insectos[i].buscarComida());
                        System.out.println("Envía mensaje con información de esta casilla a los demás insectos.");
                        for (int j = 0 ; j < insectos.length ; j++) {
                            if (i != j) {
                                insectos[i].enviarMensaje(insectos[j].getId());
                            }
                        }
                    } else {
                        System.out.println("No realiza ninguna acción.");
                    }
                }
                insectos[0].getCola().mostrarMensajes();  
                System.out.println();
            }
        } while (!ningúnInsectoMovido() || !ningúnMensajeEnCola());
    }
}
