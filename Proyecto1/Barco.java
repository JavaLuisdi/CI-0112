public class Barco {
    //Atributos de cada barco
    int row;
    int column;
    boolean sinked = false;
    boolean attacked = false;

    //Métodos set para crear y editar un barco
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public void setSinked(boolean sinked) {
        this.sinked = sinked;
    }
    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    //Métodos get para devolver atributos de un barco
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public boolean getSinked() {
        return sinked;
    }
    public boolean getAttacked() {
        return attacked;
    }

}
