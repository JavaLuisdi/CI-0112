public class Robot {

    private String name;
    private float health;
    private float attack;
    private float defense;
    private boolean alive = true;

    // Métodos "set" para dar atributos a los robots
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
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Métodos "get" para obtener atributos de los robots
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
    public boolean getAlive() {
        return alive;
    }

    public void attack(float attackPower) { // Disminuye la vida del robot al ser atacado
        this.health -= attackPower;
    } 
}