import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BatallaNaval batallaNaval = new BatallaNaval();

        //Menu. Inicia el videojuego que el usuario elija
        int menuIndex = 0;
        while (menuIndex != 3) {
            System.out.println("~ ~ ~ Menú de videojuegos ~ ~ ~");
            System.out.println("1. Batalla naval");
            System.out.println("2. Ahorcado");
            System.out.println("3. Salir");
            try {
                menuIndex = scanner.nextInt();
                switch (menuIndex) {
                    case 1:
                        batallaNaval.initializeGame();
                        batallaNaval.startBattleship();
                    break;
                    case 2:
                    MainAhorcado.main(args);
                    break;
                    default:
                    System.out.println("Digite un número válido.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println();
                System.out.println("Digite un número válido.");
                System.out.println();
            }
        }
        scanner.close();
    }
}
