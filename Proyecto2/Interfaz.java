import javax.swing.*;
import java.awt.FlowLayout;

public class Interfaz extends JFrame {
    public Interfaz() {
        setTitle("Veterinaria Los Gatitos");
        setSize(500 , 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout());

        JButton botonAtender = new JButton("Atender siguiente mascota");
        JButton botonAgregar = new JButton("Agregar mascota");
        JButton botonMostrarCola = new JButton("Mostrar cola de mascotas");
        JButton botonMostrarAtendidas = new JButton("Mostrar mascotas atendidas");
        JButton botonMostrarArbol = new JButton("Mostrar arbol de mascotas");
        JButton botonEliminar = new JButton("Eliminar una mascota del arbol");

        panelOpciones.add(botonAtender);
        panelOpciones.add(botonAgregar);
        panelOpciones.add(botonMostrarCola);
        panelOpciones.add(botonMostrarAtendidas);
        panelOpciones.add(botonMostrarArbol);
        panelOpciones.add(botonEliminar);

        add(panelOpciones);
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }

}
