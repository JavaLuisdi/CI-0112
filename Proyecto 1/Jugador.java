public class Jugador {
    
    Tablero tablero;

    public void selectShipCoordinates(int shipIndex , int row , int column) {
        this.tablero.placeBoat(shipIndex , row , column);
    }

    public void receiveAttack(int row , int column) {
        this.tablero.markBoxAttacked(row, column);
    }



}
