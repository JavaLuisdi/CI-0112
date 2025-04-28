import java.util.Scanner;
import java.util.InputMismatchException;

public class BatallaNaval {
    
    Jugador[] player;
    Jugador currentPlayer;

    Scanner scanner = new Scanner(System.in);

    public void initializeGame() {
        player = new Jugador[2];
        for (int i = 0 ; i < player.length ; i++) {
            player[i] = new Jugador();
            player[i].tablero = new Tablero();
            player[i].tablero.makeBoard();
            player[i].tablero.makeShipArray();
        }
        currentPlayer = player[0];
    }

    public void changeCurrentPlayer() {
        if(currentPlayer == player[0]) {
            currentPlayer = player[1];
        } else {
            currentPlayer = player[0];
        }
    }

    public Jugador getCurrentPlayer(boolean player1Turn) {
        if (player1Turn) {
            return player[0];
        } else {
            return player[1];
        }
    }

    int row;
    int column;
    public void startBattleship() {
        
        for (int playerIndex = 0 ; playerIndex < 2 ; playerIndex++) {
            System.out.println("Jugador " + (playerIndex + 1) + " coloca sus barcos:");
            System.out.println();
            for(int i = 1 ; i <= currentPlayer.tablero.ship.length ; i++) {
                currentPlayer.tablero.showBoard(true);              
                try {
                    System.out.print("Digite la fila donde desea colocar el barco " + i + " (1-5): ");
                    row = scanner.nextInt();
                    if (row < 1 || row > 5) {
                        i -= 1;
                        System.out.println();
                        System.out.println("Digite un número válido.");
                        System.out.println();
                        continue;
                    }
                    System.out.print("Digite la columna donde desea colocar el barco " + i + " (1-5): ");
                    column = scanner.nextInt();
                    if (column < 1 || column > 5) {
                        i -= 1;
                        System.out.println();
                        System.out.println("Digite un número válido.");
                        System.out.println();
                        continue;
                    }
                    if (currentPlayer.tablero.board[row-1][column-1] != 'B') {
                        currentPlayer.tablero.placeBoat(i-1 , row , column);
                    } else {
                        i -= 1;
                        System.out.println();
                        System.out.println("Esta casilla ya posee un barco.");
                        System.out.println();
                    }             
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    i -= 1;
                    System.out.println();
                    System.out.println("Digite un número válido.");
                    System.out.println();
                    continue;
                }
            }
            currentPlayer.tablero.showBoard(true);
            player[playerIndex] = currentPlayer;
            changeCurrentPlayer();
        }

        boolean player1Turn;
        while (!player[0].tablero.everyShipSinked() && !player[1].tablero.everyShipSinked()) {
            for (int playerTurn = 0 ; playerTurn < player.length ; playerTurn++) {
                if (playerTurn == 0) {
                    player1Turn = true;
                } else {
                    player1Turn = false;
                }
                System.out.println("Turno del jugador " + (playerTurn + 1) + ":");
                System.out.println();
                if (playerTurn == 0) {
                    System.out.println("Tablero del jugador 1:");
                    player[0].tablero.showBoard(true);
                    System.out.println();
                    System.out.println("Tablero del jugador 2:");
                    player[1].tablero.showBoard(false);
                } else {
                    System.out.println("Tablero del jugador 2:");
                    player[1].tablero.showBoard(true);
                    System.out.println();
                    System.out.println("Tablero del jugador 1:");
                    player[0].tablero.showBoard(false);
                }
                try {
                    System.out.print("Digite la fila de la casilla que desea atacar: ");
                    row = scanner.nextInt();
                    if (row < 1 || row > 5) {
                        playerTurn -= 1;
                        System.out.println();
                        System.out.println("Digite un número válido.");
                        System.out.println();
                        continue;
                    }
                    System.out.print("Digite la columna de la casilla que desea atacar: ");
                    column = scanner.nextInt();
                    if (column < 1 || column > 5) {
                        playerTurn -= 1;
                        System.out.println();
                        System.out.println("Digite un número válido.");
                        System.out.println();
                        continue;
                    }
                    if (getCurrentPlayer(!player1Turn).tablero.board[row-1][column-1] != 'O' && getCurrentPlayer(!player1Turn).tablero.board[row - 1][column - 1] != 'X') {
                        getCurrentPlayer(!player1Turn).tablero.markBoxAttacked(row  , column );
                        if (getCurrentPlayer(!player1Turn).tablero.board[row - 1][column - 1] == 'X') {
                            getCurrentPlayer(!player1Turn).tablero.getBarco(row, column).setSinked(true);
                            System.out.println("¡Le ha disparado a un barco enemigo!");
                            playerTurn -= 1;
                            if (getCurrentPlayer(!player1Turn).tablero.everyShipSinked()) {
                                System.out.println("¡Jugador " + (playerTurn + 2) + " ha hundido todos los barcos enemigos! ¡Gana el juego!");
                                return; // Termina el juego inmediatamente
                            }
                        } else {
                            System.out.println("Disparo fallido.");
                        }
                    } else {
                        playerTurn -= 1;
                        System.out.println();
                        System.out.println("Esta casilla ya ha sido atacada.");
                        System.out.println();
                        continue;
                    }             
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    playerTurn -= 1;
                    System.out.println();
                    System.out.println("Digite un número válido.");
                    System.out.println();
                    continue;
                }
            }
        }
        scanner.close();
        
    }
}

