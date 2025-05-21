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
        insectos[0] = new Agente(1, 100, 100);
        insectos[1] = new Agente(2, 900, 100);
        insectos[2] = new Agente(3, 100, 900);
        insectos[3] = new Agente(4, 900, 900);
        insectos[4] = new Agente(5, 500, 500);
        do {
            for (int i = 0 ; i < insectos.length ; i++) {
                insectos[i].mostrarEstadoActual();
                while (insectos[i].recibirMensaje()) {
                    if (insectos[i].getMensaje().getContenido()[2] > insectos[i].buscarComida()[2] && insectos[i].getMensaje().getContenido()[2] > insectos[i].getCasillaConMayorComidaReportada()[2]) {
                        insectos[i].setCasillaConMayorComidaReportada(insectos[i].getMensaje().getContenido());
                    }
                }
                if (insectos[i].getCasillaConMayorComidaReportada()[2] > insectos[i].buscarComida()[2]) {
                    System.out.println("Se mueve hacia casilla (" + insectos[i].getCasillaConMayorComidaReportada()[0] + " , " + insectos[i].getCasillaConMayorComidaReportada()[1] + ").");
                    insectos[i].moverse(insectos[i].direccionParaMoverse()[0], insectos[i].direccionParaMoverse()[1]);
                } else {
                    if (insectos[i].getCasillaConMayorComidaReportada()[2] < insectos[i].buscarComida()[2] && insectos[i].debeEnviarMensaje(insectos[i].buscarComida())) {
                        insectos[i].crearMensaje(insectos[i].buscarComida());
                        insectos[i].actualizarUltimaCasillaReportada(insectos[i].buscarComida());
                        System.out.println("Envía mensaje con información de esta casilla a los demás insectos.");
                        for (int j = 0 ; j < insectos.length ; j++) {
                            if (i != j) {
                                insectos[i].enviarMensaje(insectos[j].getId());
                            }
                        }
                    } else {
                        System.out.println("No realiza ninguna acción.");
                    }
                    insectos[i].moverse(-1, -1);
                }
                insectos[0].getCola().mostrarMensajes();  
                System.out.println();
            }
        } while (!ningúnInsectoMovido() || !ningúnMensajeEnCola());
        System.out.println("Casilla encontrada por insectos (" + insectos[0].buscarComida()[2] + "): (" + insectos[0].buscarComida()[0] + " , " + insectos[0].buscarComida()[1] + ").");
        System.out.println("Casilla con mayor comida (" + insectos[0].getPlato().encontrarComidaMaxima()[2] + "): (" + insectos[0].getPlato().encontrarComidaMaxima()[0] + " , " + insectos[0].getPlato().encontrarComidaMaxima()[1] + ").");
    }
}
