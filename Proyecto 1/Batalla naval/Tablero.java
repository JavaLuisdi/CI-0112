public class Tablero {
    
    String[] yCoordinates = {"A" , "B" , "C" , "D" , "E"};
    int[] xCoordinates = {1 , 2 , 3 , 4 , 5};

    public void makePlayer1Grid() {
        Casilla[][] player1Grid = new Casilla[5][5];
        for (int i = 0 ; i < player1Grid.length ; i++) {
            for (int j = 0 ; j < player1Grid[i].length ; j++) {
                player1Grid[i][j] = new Casilla();
            }
        }
    }
    
    Casilla[][] player2Grid = new Casilla[5][5];
    for (int i = 0 ; i < player2Grid.length ; i++) {
        for (int j = 0 ; j < player2Grid[i].length ; j++) {
            player2Grid[i][j] = new Casilla();
        }
    }


    

}       
    

