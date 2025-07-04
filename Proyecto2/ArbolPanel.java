import javax.swing.*;
import java.awt.*;

public class ArbolPanel extends JPanel {
    /**
     * Nodo raíz del árbol binario a dibujar
     */
    private Nodo raiz;

    /**
     * Constructor del panel que recibe la raíz del árbol a mostrar
     * @param raiz Nodo raíz del árbol binario
     */
    public ArbolPanel(Nodo raiz) {
        this.raiz = raiz;
        setPreferredSize(new Dimension(800, 600));
    }

    /**
     * Sobrescribe el método de JPanel para dibujar el árbol binario
     * @param g Objeto Graphics para dibujar en el panel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            dibujarNodo(g, raiz, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    /**
     * Dibuja recursivamente un nodo y sus hijos en el panel
     * @param g Objeto Graphics para dibujar
     * @param nodo Nodo actual a dibujar
     * @param x Posición horizontal del nodo
     * @param y Posición vertical del nodo
     * @param xOffset Separación horizontal entre nodos hijos
     */
    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int xOffset) {
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y - 20, 40, 40);
        g.drawString(nodo.getMascota().getNombre(), x - 15, y + 5);

        // Dibuja y conecta el hijo izquierdo si existe
        if (nodo.getNodoLado(false) != null) {
            g.drawLine(x, y, x - xOffset, y + 70);
            dibujarNodo(g, nodo.getNodoLado(false), x - xOffset, y + 70, xOffset / 2);
        }
        // Dibuja y conecta el hijo derecho si existe
        if (nodo.getNodoLado(true) != null) {
            g.drawLine(x, y, x + xOffset, y + 70);
            dibujarNodo(g, nodo.getNodoLado(true), x + xOffset, y + 70, xOffset / 2);
        }
    }
}