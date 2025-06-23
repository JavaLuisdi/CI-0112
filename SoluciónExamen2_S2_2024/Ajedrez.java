// Clase que contiene métodos para verificar si una matriz representa un recorrido válido del caballo de ajedrez.
// Incluye métodos recursivos e iterativos para la verificación.
public class Ajedrez {
    // Verifica recursivamente si la matriz representa un recorrido válido del caballo,
    // comenzando desde la casilla con el número 1 y siguiendo la secuencia hasta 64.
    public boolean recursivoMatrizEsViajable(int[][] matriz) {
        return viajarMatriz(matriz , encontrarCasillaInicio(matriz)[0] , encontrarCasillaInicio(matriz)[1]);
    }

    // Realiza el recorrido recursivo desde la posición actual buscando el siguiente número
    // en la secuencia, usando solo movimientos de caballo.
    private boolean viajarMatriz(int[][] matriz , int fila , int columna) {
        if(matriz[fila][columna] == 64) {
            return true;
        } else if (siguienteIntEnVecindad(matriz , fila , columna)[0] == -1) {
            return false;
        }
        return viajarMatriz(matriz , siguienteIntEnVecindad(matriz , fila , columna)[0] , siguienteIntEnVecindad(matriz , fila , columna)[1]);
    }

    // Busca la posición (fila, columna) donde se encuentra el número 1 en la matriz.
    private int[] encontrarCasillaInicio(int[][] matriz) {
        for (int i = 0 ; i < matriz.length ; i++) {
            for (int j = 0 ; j < matriz[i].length ; j++) {
                if (matriz[i][j] == 1) {
                    return new int[] {i , j};
                }
            }
        }
        return null;
    }

    // Busca en la vecindad de la posición actual (usando movimientos de caballo)
    // la casilla que contenga el siguiente número en la secuencia.
    private int[] siguienteIntEnVecindad(int[][] matriz , int fila , int columna) {
        for (int i = -1 ; i <= 1 ; i += 2) {
            for (int j = -1 ; j <= 1 ; j += 2) {
                for (int k = 0 ; k <= 1 ; k++) {
                    if ((fila + j) + k * j >= 0 && (fila + j) + k * j < 8 && (columna + i) + ((1 - k) * i) >= 0 && (columna + i) + ((1 - k) * i) < 8) {
                        if (matriz[fila][columna] + 1 == matriz[(fila + j) + k * j][(columna + i) + ((1 - k) * i)]) {
                            return new int[] {(fila + j) + k * j , (columna + i) + ((1 - k) * i)};
                        }
                    }
                }
            }
        }
        return new int[] {-1 , -1};
    }

    // Verifica de forma iterativa si la matriz representa un recorrido válido del caballo.
    public boolean iterativoMatrizEsViajable(int[][] matriz) {
        int[] casillaInicio = encontrarCasillaInicio(matriz);
        int fila = casillaInicio[0];
        int columna = casillaInicio[1];
        int[] siguienteCasilla;
        while (matriz[fila][columna] < 64) {
            siguienteCasilla = siguienteIntEnVecindad(matriz , fila , columna);
            fila = siguienteCasilla[0];
            columna = siguienteCasilla[1];
            if (fila == -1 || columna == -1) {
                return false;
            }
        }
        return true;
    }

    // Método principal para probar el funcionamiento de la clase Ajedrez.
    // Crea una matriz de ejemplo y muestra si es un recorrido válido del caballo.
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 60, 39, 34, 31, 18, 9, 64},
            {38, 35, 32, 61, 10, 63, 30, 17},
            {59, 2, 37, 40, 33, 28, 19, 8},
            {36, 49, 42, 27, 62, 11, 16, 29},
            {43, 58, 3, 50, 41, 24, 7, 20},
            {48, 51, 46, 55, 26, 21, 12, 15},
            {57, 44, 53, 4, 23, 14, 25, 6},
            {52, 47, 56, 45, 54, 5, 22, 13}
        };
        Ajedrez ajedrez = new Ajedrez();
        System.out.println(ajedrez.recursivoMatrizEsViajable(matriz));
        System.out.println(ajedrez.iterativoMatrizEsViajable(matriz));
    }
}