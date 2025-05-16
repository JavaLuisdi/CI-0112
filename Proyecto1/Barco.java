public class Barco {
    /**
     * @brief Atributos de cada barco
     */
    int row;
    int column;
    boolean sinked = false;
    boolean attacked = false;

    /**
     * @brief Métodos set para crear y editar un barco
     * @param row Fila donde se encuentra el barco
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @brief Establece la columna del barco
     * @param column Columna donde se encuentra el barco
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @brief Establece si el barco ha sido hundido
     * @param sinked Estado de hundimiento del barco
     */
    public void setSinked(boolean sinked) {
        this.sinked = sinked;
    }

    /**
     * @brief Establece si el barco ha sido atacado
     * @param attacked Estado de ataque del barco
     */
    public void setAttacked(boolean attacked) {
        this.attacked = this.attacked;
    }

    /**
     * @brief Métodos get para devolver atributos de un barco
     * @return La fila donde se encuentra el barco
     */
    public int getRow() {
        return row;
    }

    /**
     * @brief Devuelve la columna donde se encuentra el barco
     * @return La columna del barco
     */
    public int getColumn() {
        return column;
    }

    /**
     * @brief Indica si el barco ha sido hundido
     * @return true si el barco está hundido, false en caso contrario
     */
    public boolean getSinked() {
        return sinked;
    }

    /**
     * @brief Indica si el barco ha sido atacado
     * @return true si el barco ha sido atacado, false en caso contrario
     */
    public boolean getAttacked() {
        return attacked;
    }

}