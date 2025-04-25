public class Casilla {
    
    private boolean hasShip = false;
    private boolean attacked = false;

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }
    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public boolean getHasShip() {
        return hasShip;
    }
    public boolean getAttacked() {
        return attacked;
    }
    
    public char getAttackerBoxType() {
        if (this.hasShip && this.attacked) {
            return 'X';
        }
        if (!this.hasShip && this.attacked) {
            return 'O';
        }
        if (this.hasShip && !this.attacked) {
            return 'B';
        }
        if (!this.hasShip && !this.attacked) {
            return '~';
        }
        // Default return value in case all conditions fail
        return '~';
    }

    public char getVictimBoxType() {
        if (this.hasShip && this.attacked) {
            return 'X';
        }
        if (!this.hasShip && this.attacked) {
            return 'O';
        }
        if (this.hasShip && !this.attacked) {
            return '~';
        }
        if (!this.hasShip && !this.attacked) {
            return '~';
        }
        // Default return value in case all conditions fail
        return '~';
    }
}
