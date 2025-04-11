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

        while (robotAmount < 2 || robotAmount > 10) { // Usuario determina la cantidad de robots que participarán (2-10)
            System.out.print("Digite la cantidad de robots que participarán (2-10): ");
            robotAmount = scanner.nextInt();
            System.out.print("\n");
            if (robotAmount < 2 || robotAmount > 10) {
                System.out.println("Número ingresado no es válido.");
                continue;
            } 
        }

        Robot[] robot = new Robot[robotAmount]; // Se crea el arreglo de robots y se inicializa cada uno
        for (int i = 0 ; i < robot.length ; i++) {
            robot[i] = new Robot();
        }

        for (int j = 0 ; j < robot.length ; j++) { // Usuario asigna los atributos a cada robot
            scanner.nextLine();
            System.out.print("Escriba el nombre del robot " + (j+1) + ": ");
            robot[j].setName(scanner.nextLine());
            System.out.print("Digite la cantidad de puntos de vida de " + robot[j].getName() + " (50-100): ");
            health = scanner.nextFloat();
            if (health < 50 || health > 100) {
                System.out.println("Número ingresado no es válido.");
                j -= 1;
                System.out.print("\n");
                continue;
            }
            robot[j].setHealth(health);
            System.out.print("Digite la cantidad de puntos de ataque de " + robot[j].getName() + " (10-20): ");
            attack = scanner.nextFloat();
            if (attack < 10 || attack > 20) {
                System.out.println("Número ingresado no es válido.");
                j -= 1;
                System.out.print("\n");
                continue;
            }
            robot[j].setAttack(attack);
            System.out.print("Digite la cantidad de puntos de defensa de " + robot[j].getName() + " (0-10): ");
            defense = scanner.nextFloat();
            if (defense < 0 || defense > 10) {
                System.out.println("Número ingresado no es válido.");
                j -= 1;
                System.out.print("\n");
                continue;
            }
            robot[j].setDefense(defense);
            System.out.print("\n");
        }

        int aliveAmount = robotAmount;
        int aliveCheck = 0;
        int menuIndex;
        int victim;
        float attackPower;
        int rounds = 0;

        while (aliveAmount > 1) { // Muestra el menú cada que se repite el bucle. Termina cuando hay solo un robot con vida
            System.out.println("Escoja la acción que desea realizar:");
            System.out.println("1. Comenzar ronda");
            System.out.println("2. Mostrar estado de los robots");
            menuIndex = scanner.nextInt();
            System.out.print("\n");
            switch (menuIndex) {
                case 1: // Cada robot ataca a otro aleatoriamente
                    for (int attacker = 0 ; attacker < robot.length ; attacker++) {
                        if (robot[attacker].getAlive()) { // Se asegura que el atacante esté con vida
                            victim = random.nextInt(robot.length);
                            if (!robot[victim].getAlive()) { // Se asegura que la víctima esté con vida
                                attacker -= 1;
                                continue;
                            }
                            if (attacker == victim) { // Se asegura que el atacante y la víctima no sean la misma
                                attacker -= 1;
                                continue;
                            }
                            attackPower = robot[attacker].getAttack() - (robot[victim].getDefense() * 0.75f); // Calcula el daño que recibirá la víctima
                            robot[victim].attack(attackPower); // Llama al método "attack" de la clase "Robot", enviándole el daño calculado
                            System.out.println(robot[attacker].getName() + " inflingió " + attackPower + " de daño a " + robot[victim].getName() + ".");
                        } else {
                            System.out.println(robot[attacker].getName() + " está fuera de juego."); // Si el robot no tiene vida restante, no atacará y se indica que está fuera de juego
                        }
                        for (int c = 0 ; c < robot.length ; c++) { // Revisa y establece cuáles robots están fuera de juego al final de cada ataque
                            if (robot[c].getHealth() <= 0) {
                                robot[c].setAlive(false);
                                robot[c].setHealth(0);
                            }
                        }    
                        if (robot[attacker].getAlive()) { // Cuenta cuántos robots quedan con vida
                            aliveCheck += 1;
                        }
                    }
                    aliveAmount = aliveCheck; // Establece cuántos robots quedan con vida al final de cada ronda
                    aliveCheck = 0; // Reinica el conteo para la siguiente ronda
                    rounds += 1; // Cuenta las rondas jugadas
                    System.out.print("\n");
                    break;
                case 2:
                    for (int t = 0 ; t < robot.length ; t++) { // Muestra los atributos de cada robot
                        System.out.println("Estado de " + robot[t].getName() + ":");
                        System.out.println("Puntos de vida restantes: " + robot[t].getHealth());
                        System.out.println("Puntos de ataque: " + robot[t].getAttack());
                        System.out.println("Puntos de defensa: " + robot[t].getDefense());
                        System.out.println("-----------------------------------------");
                    }
                    break;
                default:
                    System.out.println("Número ingresado no es válido.");
                    System.out.print("\n");
            }
        }
        for (int winner = 0 ; winner < robot.length ; winner++) { // Al quedar solo un robot con vida, revisa cuál es y lo muestra como el ganador
            if (robot[winner].getAlive()) {
                System.out.println("El robot ganador es " + robot[winner].getName() + ".");
                System.out.println("Rondas jugadas: " + rounds);
            }
        }
        scanner.close();
    }   
}
