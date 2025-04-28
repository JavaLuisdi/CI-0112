public class Tablero {
    
    char[][] board;
    Barco[] ship; 

    public void makeBoard() {
        this.board = new char[5][5];
        for (int i = 0 ; i < this.board.length ; i++) {
            for (int j = 0 ; j < this.board[i].length ; j++) {
                this.board[i][j] = '~';
            }
        }
    }

    public void makeShipArray() {
        this.ship = new Barco[3];
        for (int i = 0 ; i < this.ship.length ; i++) {
            this.ship[i] = new Barco();
        }
    }

    public void placeBoat(int shipIndex , int row , int column) {
        this.ship[shipIndex].setRow(row);
        this.ship[shipIndex].setColumn(column);
        this.ship[shipIndex].setSinked(false);
        this.board[row-1][column-1] = 'B';
    }

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

    public boolean everyShipSinked() {
        for (int i = 0; i < this.ship.length; i++) {
            if (!this.ship[i].getSinked()) { // Si algún barco no está hundido
                return false;
            }
        }
        return true; // Todos los barcos están hundidos
    }

    public Barco getBarco(int row , int column) {
        for (int i = 0 ; i < this.ship.length ; i++) {
            if (this.ship[i].getRow() == row && this.ship[i].getColumn() == column) {
                return this.ship[i];
            }
        }
        return null; // Return null if no matching ship is found
    }
}
