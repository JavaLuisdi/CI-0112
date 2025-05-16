public class Tablero {
    //Matriz como tablero y arreglo de barcos del tablero
    char[][] board;
    Barco[] ship; 

    //Inicializa y asigna "~" a cada casilla predeterminadamente
    public void makeBoard() {
        this.board = new char[5][5];
        for (int i = 0 ; i < this.board.length ; i++) {
            for (int j = 0 ; j < this.board[i].length ; j++) {
                this.board[i][j] = '~';
            }
        }
    }

    //Inicializa cada barco del arreglo
    public void makeShipArray() {
        this.ship = new Barco[3];
        for (int i = 0 ; i < this.ship.length ; i++) {
            this.ship[i] = new Barco();
        }
    }

    //Coloca un barco en una casilla del tablero. Asigna "B" a la casilla indicando que hay un barco
    public void placeBoat(int shipIndex , int row , int column) {
        this.ship[shipIndex].setRow(row);
        this.ship[shipIndex].setColumn(column);
        this.ship[shipIndex].setSinked(false);
        this.board[row-1][column-1] = 'B';
    }

    //Al atacar una casilla, le asigna "X" si esta posee un barco y marca el barco como hundido, u "O" si no posee un barco, informando al usuario cuál caso se da. Si la casilla ya ha sido atacada, se le indica al usuario
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
  
    //Muestra el estado actual de un tablero al usuario. Puede mostrar los barcos colocados o puede no mostrarlos.
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

    //Revisa si todos los barcos de un tablero han sido hundidos
    public boolean everyShipSinked() {
        for (int i = 0; i < this.ship.length; i++) {
            if (!this.ship[i].getSinked()) {
                return false;
            }
        }
        return true;
    }

    //Devuelve el barco de una casilla específica
    public Barco getBarco(int row , int column) {
        for (int i = 0 ; i < this.ship.length ; i++) {
            if (this.ship[i].getRow() == row && this.ship[i].getColumn() == column) {
                return this.ship[i];
            }
        }
        return null;
    }
}
