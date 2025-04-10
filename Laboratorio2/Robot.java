import java.util.Random;
import java.util.Scanner;

public class Robot {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private float health;
    private float attack;
    private float defense;

    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(float health) {
        this.health = health;
    }
    public void setAttack(float attack) {
        this.attack = attack;
    }
    public void setDefense(float defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }
    public float getHealth() {
        return health;
    }
    public float getAttack() {
        return attack;
    }
    public float getDefense() {
        return defense;
    }

    private static Robot[] robot;

    public static void makeRobotArray(int robotQuantity) {
        robot = new Robot[robotQuantity];
        for (int j = 0 ; j < robot.length ; j++) {
            robot[j] = new Robot();
        }
    }
    
    public static int getRobotLength() {
        return robot.length;
    }
    public static Robot getRobot(int robotIndex) {
        return robot[robotIndex];
    }


    
        
        
    
}