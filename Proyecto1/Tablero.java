/**
 * @class Tablero
 * @brief Representa un tablero de juego para batalla naval.
 * 
 * La clase gestiona una matriz de caracteres que representa el tablero
 * y un arreglo de barcos colocados en él.
 */
public class Tablero {
    /**
     * @brief Matriz que representa el tablero de juego.
     * 
     * Cada celda puede contener:
     * - '~' para agua
     * - 'B' para barco
     * - 'X' para barco hundido
     * - 'O' para ataque fallido
     */
    char[][] board;
    
    /**
     * @brief Arreglo de barcos colocados en el tablero.
     */
    Barco[] ship; 

    /**
     * @brief Inicializa el tablero con agua en todas las celdas.
     * 
     * Crea una matriz 5x5 y asigna el carácter '~' a cada celda.
     */
    public void makeBoard() {
        this.board = new char[5][5];
        for (int i = 0 ; i < this.board.length ; i++) {
            for (int j = 0 ; j < this.board[i].length ; j++) {
                this.board[i][j] = '~';
            }
        }
    }

    /**
     * @brief Inicializa el arreglo de barcos.
     * 
     * Crea 3 instancias de la clase Barco.
     */
    public void makeShipArray() {
        this.ship = new Barco[3];
        for (int i = 0 ; i < this.ship.length ; i++) {
            this.ship[i] = new Barco();
        }
    }

    /**
     * @brief Coloca un barco en una posición específica del tablero.
     * 
     * @param shipIndex Índice del barco en el arreglo
     * @param row Fila donde colocar el barco (1-5)
     * @param column Columna donde colocar el barco (1-5)
     */
    public void placeBoat(int shipIndex , int row , int column) {
        this.ship[shipIndex].setRow(row);
        this.ship[shipIndex].setColumn(column);
        this.ship[shipIndex].setSinked(false);
        this.board[row-1][column-1] = 'B';
    }

    /**
     * @brief Marca una casilla como atacada.
     * 
     * Si hay un barco, lo marca como hundido ('X'), si no, marca como fallo ('O').
     * Informa al usuario el resultado del ataque.
     * 
     * @param row Fila a atacar (1-5)
     * @param column Columna a atacar (1-5)
     */
    public void markBoxAttacked(int row , int column) {
        if (this.board[row - 1][column - 1] != 'X' || this.board[row - 1][column - 1] != 'O') {
            for (int i = 0 ; i < this.ship.length ; i++) {
                if (this.ship[i].getRow() == (row) && this.ship[i].getColumn() == (column)) {
                    this.ship[i].setSinked(true);
                    this.board[row - 1][column - 1] = 'X';
                    System.out.println("Barco en la fila " + row + " y columna " + column + " ha sido atacado.");
                }
            }
            if (!(this.ship[0].getRow() == row && this.ship[0].getColumn() == column)) {
                if (!(this.ship[1].getRow() == row && this.ship[1].getColumn() == column)) {
                    if (!(this.ship[2].getRow() == row && this.ship[2].getColumn() == column)) {
                        this.board[row-1][column-1] = 'O';
                    }
                }
            }    
        } else {
            System.out.println("Esta casilla ya ha sido atacada.");
        }      
    }
  
    /**
     * @brief Muestra el estado actual del tablero.
     * 
     * @param showBoats Si es true, muestra los barcos ('B'), si es false los oculta ('~')
     */
    Barco[] shipTemp = new Barco[3];
    public void showBoard(boolean showBoats) {  
        if (showBoats) {
            System.out.print("  ");
            for (int i = 0 ; i < this.board.length ; i++) {
                System.out.print((i + 1) + " ");
            }
            for (int i = 0 ; i < this.board.length ; i++) {
                System.out.println();
                System.out.print(i+1);
                for (int j = 0 ; j < this.board.length ; j++) {
                    System.out.print(" " + this.board[i][j]);
                }
            }
        } else {
            System.out.print("  ");
            for (int i = 0 ; i < this.board.length ; i++) {
                System.out.print((i + 1) + " ");
            }
            for (int i = 0 ; i < this.board.length ; i++) {
                System.out.println();
                System.out.print(i+1);
                for (int j = 0 ; j < this.board.length ; j++) {
                    if (this.board[i][j] == 'B') {
                        System.out.print(" " + '~');
                    } else {
                        System.out.print(" " + this.board[i][j]);
                    } 
                }
            }
        }
        System.out.println();
    }

    /**
     * @brief Verifica si todos los barcos han sido hundidos.
     * 
     * @return true si todos los barcos están hundidos, false si al menos uno sigue a flote
     */
    public boolean everyShipSinked() {
        for (int i = 0; i < this.ship.length; i++) {
            if (!this.ship[i].getSinked()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @brief Obtiene el barco en una posición específica.
     * 
     * @param row Fila a buscar (1-5)
     * @param column Columna a buscar (1-5)
     * @return El objeto Barco en esa posición, o null si no hay barco
     */
    public Barco getBarco(int row , int column) {
        for (int i = 0 ; i < this.ship.length ; i++) {
            if (this.ship[i].getRow() == row && this.ship[i].getColumn() == column) {
                return this.ship[i];
            }
        }
        return null;
    }
}
