import java.util.Random;
public class Plato {
    private Random random;
    private int[][] comida;

    public Plato() {
        this.random = new Random();
        this.comida = new int[1000][1000];
        for (int i = 0 ; i < this.comida.length ; i++) {
            for (int j = 0 ; j < this.comida[i].length ; j++) {
                this.comida[i][j] = 0;
            }
        }
        for (int i = 0 ; i < 200000 ; i++) {
            int fila;
            int columna;
            int suma = 0;
            do {
                fila = random.nextInt(1000);
                columna = random.nextInt(1000);
            } while (fila == 0 || fila == 999 || columna == 0 || columna == 999);
            for (int y = fila + 1 ; y >= fila - 1 ; y--) {
                for (int x = columna - 1 ; x <= columna + 1 ; x++) {
                    suma += this.comida[y][x];
                }
            }
            if (suma == 0) {
                this.comida[fila][columna]++;
            } else {
                this.comida[fila][columna] += (suma - this.comida[fila][columna]);
            }
        }
    }

    public int[] encontrarComidaMaxima() {
        int X = -1;
        int Y = -1;
        int max = 0;
        for (int i = 0 ; i < this.comida.length ; i++) {
            for (int j = 0 ; j < this.comida[i].length ; j++) {
                if (this.comida[i][j] > max) {
                    X = j;
                    Y = i;
                    max = this.comida[i][j];
                }
            }
        }
        return new int[] {X , Y , max};
    } 

    public int[][] getComida() {
        return comida;
    }
}
