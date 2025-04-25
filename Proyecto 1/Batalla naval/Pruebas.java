public class Pruebas {
    public static void main(String[] args) {

        String[] yLetters = {"A" , "B" , "C" , "D" , "E"};
    

        Casilla[][] player1Grid = new Casilla[5][5];
        for (int i = 0 ; i < player1Grid.length ; i++) {
            for (int j = 0 ; j < player1Grid[i].length ; j++) {
                player1Grid[i][j] = new Casilla();
            }
        }
        
        System.out.print(" ");
        for (int r = 0 ; r < player1Grid.length ; r++) {
            System.out.print(" ");
            System.out.print(r + 1);
        }
        System.out.println();
        for (int t = 0 ; t < player1Grid.length ; t++) {
            System.out.print(yLetters[t] + " ");
            for (int y = 0 ; y < player1Grid[t].length ; y++) {
                System.out.print(player1Grid[t][y].getAttackerBoxType() + " ");
            }
            System.out.println();
        }
    }
}
