import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        float health;
        float attack;
        float defense;
        int robotAmount = 0;

        while (robotAmount < 2 || robotAmount > 10) {
            System.out.print("Digite la cantidad de robots que participarán (2-10): ");
            robotAmount = scanner.nextInt();
            if (robotAmount < 2 || robotAmount > 10) {
                System.out.println("Número ingresado no es válido.");
                continue;
            } 
        }

        Robot[] robot = new Robot[robotAmount];
        for (int i = 0 ; i < robot.length ; i++) {
            robot[i] = new Robot();
        }

        for (int j = 0 ; j < robot.length ; j++) {
            scanner.nextLine();
            System.out.print("Escriba el nombre del robot " + (j+1) + ": ");
            robot[j].setName(scanner.nextLine());
            System.out.print("Digite la cantidad de puntos de vida de " + robot[j].getName() + " (50-100): ");
            health = scanner.nextFloat();
            if (health < 50 || health > 100) {
                System.out.println("Número ingresado no es válido.");
                j -= 1;
                continue;
            }
            robot[j].setHealth(health);
            System.out.print("Digite la cantidad de puntos de ataque de " + robot[j].getName() + " (10-20): ");
            attack = scanner.nextFloat();
            if (attack < 10 || attack > 20) {
                System.out.println("Número ingresado no es válido.");
                j -= 1;
                continue;
            }
            System.out.print("Digite la cantidad de puntos de defensa de " + robot[j].getName() + " (0-10): ");
            defense = scanner.nextFloat();
            if (defense < 0 || defense > 10) {
                System.out.println("Número ingresado no es válido.");
                continue;
            }
        }

        int aliveAmount = robotAmount;
        int menuIndex;
        int victim;
        float attackPower;

        while (aliveAmount > 1) {
            System.out.println("Escoja la acción que desea realizar:");
            System.out.println("1. Comenzar ronda");
            System.out.println("2. Pausar juego y mostrar estado de los robots");
            menuIndex = scanner.nextInt();
            switch (menuIndex) {
                case 1:
                    for (int attacker = 0 ; attacker < robot.length ; attacker++) {
                        victim = random.nextInt(robot.length);
                        if (attacker == victim) {
                            attacker -= 1;
                            continue;
                        }
                        attackPower = robot[attacker].getAttack() - ((robot[victim].getDefense() * 3) / 4);
                        robot[victim].attack(attackPower);
                        System.out.println(robot[attacker].getName() + " inflingió " + attackPower + " de daño a " + robot[victim].getName() + ".");
                    }
                    break;
                case 2:
                    
                    break;
                default:
            }
        }
    }   
}
