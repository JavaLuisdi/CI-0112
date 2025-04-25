import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameIndex = 0;
        String invalidInputOutput = "Debe ingresar un número válido.";

        while (gameIndex != 3){
            System.out.println("Seleccione el videojuego que desea jugar:");
            System.out.println("1. Batalla naval");
            System.out.println("2. Ahorcado");
            System.out.println("3. Terminar el programa");
            try {
                gameIndex = scanner.nextInt();
            }
            catch (InputMismatchException gameIndexInput) {
                System.out.println(invalidInputOutput);
                System.out.println();
                scanner.nextLine();
                continue;
            }
            if (gameIndex < 1 || gameIndex > 3) {
                System.out.println(invalidInputOutput);
                System.out.println();
                continue;
            }

            switch (gameIndex) {
                case 1:
                Casilla[][] player1Grid = new Casilla[5][5];
                for (int i = 0 ; i < player1Grid.length ; i++) {
                    for (int j = 0 ; j < player1Grid[i].length ; j++) {
                        player1Grid[i][j] = new Casilla();
                    }
                }

                Casilla[][] player2Grid = new Casilla[5][5];
                for (int i = 0 ; i < player2Grid.length ; i++) {
                    for (int j = 0 ; j < player2Grid[i].length ; j++) {
                        player2Grid[i][j] = new Casilla();
                    }
                }
                
                                
                    break;
                
                case 2:
                    break;

                case 3:
                    break;
                
                default:
            }
        }


    }
}
