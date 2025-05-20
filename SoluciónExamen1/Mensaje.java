public class Mensaje {
    private int idFuente;
    private int idEmisor;
    private int idDestinatario;
    private int[] contenido;

    public Mensaje(int idFuente , int idEmisor , int idDestinatario , int[] contenido) {
        this.idFuente = idFuente;
        this.idEmisor = idEmisor;
        this.idDestinatario = idDestinatario;
        this.contenido = contenido;
    }

    public void setEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }
    public void setDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }


    public int getIdFuente() {
        return this.idFuente;
    }
    public int getIdEmisor() {
        return this.idEmisor;
    }
    public int getIdDestinatario() {
        return this.idDestinatario;
    }
    public int[] getContenido() {
        return this.contenido;
    }
}