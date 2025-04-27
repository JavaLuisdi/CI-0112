public class Barco {
    int row;
    int column;
    boolean sinked = false;
    boolean attacked = false;

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
