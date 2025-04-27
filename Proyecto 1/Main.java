import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {

        BatallaNaval batallaNaval = new BatallaNaval();

        int menuIndex = 0;
        while (menuIndex != 3) {
            Scanner scanner = new Scanner(System.in);
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
                    break;
                    case 3:
                    break;
                    default:
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println();
                System.out.println("Digite un número válido.");
                System.out.println();
            }
        }
    }
}
