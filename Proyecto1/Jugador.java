public class Jugador {
    //Cada jugador posee su atributo tablero
    Tablero tablero;

    //Coloca un barco en la casilla del tablero seleccionada por el jugador
    public void selectShipCoordinates(int shipIndex , int row , int column) {
        this.tablero.placeBoat(shipIndex , row , column);
    }

    //
    public void receiveAttack(int row , int column) {
        this.tablero.markBoxAttacked(row, column);
    }



}
