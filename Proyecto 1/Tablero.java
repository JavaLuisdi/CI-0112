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
        if (this.board[row][column] != 'X' || this.board[row][column] != 'O') {
            for (int i = 0 ; i < this.ship.length ; i++) {
                if (this.ship[i].getRow() == row && this.ship[i].getColumn() == column) {
                    this.ship[i].setSinked(true);
                    this.board[row][column] = 'X';
                    System.out.println("Barco en la fila " + row + " y columna " + column + " ha sido atacado.");
                }
            }
            if (!(this.ship[0].getRow() == row && this.ship[0].getColumn() == column)) {
                if (!(this.ship[1].getRow() == row && this.ship[1].getColumn() == column)) {
                    if (!(this.ship[2].getRow() == row && this.ship[2].getColumn() == column)) {
                        this.board[row][column] = 'O';
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
            for (int i = 1 ; i <= this.board.length ; i++) {
                System.out.print(i + " ");
            }
            for (int i = 1 ; i <= this.board.length - 1 ; i++) {
                System.out.println();
                System.out.print(i);
                for (int j = 1 ; j <= this.board.length ; j++) {
                    for (int k = 0 ; k < this.ship.length ; k++) {
                        if (this.ship[k].getRow() == i && this.ship[k].getColumn() == j){
                            System.out.print(" " + '~');
                        } else {
                            System.out.print(" " + this.board[i][j]);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public boolean everyShipSinked() {
        if (this.ship[0].getSinked() == true && this.ship[1].getSinked() == true && this.ship[2].getSinked() == true) {
            return true;
        } else {
            return false;
        }
    }
}
