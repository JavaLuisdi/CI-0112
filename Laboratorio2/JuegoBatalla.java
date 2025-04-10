import java.util.Scanner;

public class JuegoBatalla {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    float health;
    float attack;
    float defense;

    System.out.print("Digite la cantidad de robots que participarán: ");
    Robot.makeRobotArray(scanner.nextInt());
    
    
    for (int i = 0 ; i < Robot.getRobotLength() ; i++) { // Asigna atributos a los robots desde la terminal
        scanner.nextLine();
        System.out.print("Escriba el nombre del robot " + (i+1) + ": ");
        robot[i].setName(scanner.nextLine());
        System.out.print("Digite la cantidad de puntos de vida del robot " + (i+1) + " (50-100): ");
        health = scanner.nextFloat();
        if (health < 50 || health > 100) { // Asegura que el valor ingresado esté en el rango solicitado
            System.out.println("Número ingresado no es válido.");
            i -= 1;
            continue;
        }
        robot[i].setHealth(health);
        System.out.print("Digite la cantidad de puntos de ataque del robot " + (i+1) + " (10-20): ");
        attack = scanner.nextFloat();
        if (attack < 10 || attack > 20) { // Asegura que el valor ingresado esté en el rango solicitado
            System.out.println("Número ingresado no es válido.");
            i -= 1;
            continue;
        }
        robot[i].setAttack(attack);
        System.out.print("Digite la cantidad de puntos de defensa del robot " + (i+1) + " (0-10): ");
        defense = scanner.nextFloat();
        if (defense < 0 || defense > 10) { // Asegura que el valor ingresado esté en el rango solicitado
            System.out.println("Número ingresado no es válido.");
            i -= 1;
            continue;
        }
        robot[i].setDefense(defense);
    }
    }
}
