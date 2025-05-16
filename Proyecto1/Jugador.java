/**
 * @class Jugador
 * @brief Representa un jugador en el juego de Batalla Naval.
 *
 * Cada jugador tiene su propio tablero y puede realizar acciones
 * como colocar barcos y recibir ataques.
 */
public class Jugador {
    /**
     * @brief Tablero asociado al jugador.
     * 
     * Contiene la disposición de los barcos y el estado de los ataques.
     */
    Tablero tablero;

    /**
     * @brief Coloca un barco en las coordenadas especificadas.
     * 
     * @param shipIndex Índice del barco a colocar (posición en el arreglo de barcos)
     * @param row Fila donde colocar el barco (1-based)
     * @param column Columna donde colocar el barco (1-based)
     * 
     * @see Tablero.placeBoat()
     */
    public void selectShipCoordinates(int shipIndex, int row, int column) {
        this.tablero.placeBoat(shipIndex, row, column);
    }

    /**
     * @brief Procesa un ataque recibido en las coordenadas especificadas.
     * 
     * Marca la casilla correspondiente en el tablero como atacada.
     * 
     * @param row Fila del ataque (1-based)
     * @param column Columna del ataque (1-based)
     * 
     * @see Tablero.markBoxAttacked()
     */
    public void receiveAttack(int row, int column) {
        this.tablero.markBoxAttacked(row, column);
    }
}
