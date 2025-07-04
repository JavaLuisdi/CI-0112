import java.awt.*;
import javax.swing.*;

public class Interfaz extends JFrame {
    private final Cola cola;
    private final ArbolBinario arbol;
    private Nodo primeraMascotaAtendida;
    private Nodo ultimaMascotaAtendida;
    
    public Interfaz() {
        setTitle("Veterinaria Los Trolls");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cola = new Cola();
        arbol = new ArbolBinario();
        primeraMascotaAtendida = null;
        ultimaMascotaAtendida = null;

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        
        JButton botonAtender = crearBoton("Atender siguiente", Color.GREEN);
        JButton botonAgregar = crearBoton("Agregar mascota", Color.CYAN);
        JButton botonMostrarCola = crearBoton("Mostrar cola", Color.YELLOW);
        JButton botonMostrarAtendidas = crearBoton("Historial", Color.ORANGE);
        JButton botonMostrarArbol = crearBoton("Mostrar árbol", Color.PINK);
        JButton botonEliminar = crearBoton("Eliminar mascota", Color.RED);

        panelBotones.add(botonAtender);
        panelBotones.add(botonAgregar);
        panelBotones.add(botonMostrarCola);
        panelBotones.add(botonMostrarAtendidas);
        panelBotones.add(botonMostrarArbol);
        panelBotones.add(botonEliminar);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        
        JLabel labelEstado = new JLabel("Estado: Listo");
        labelEstado.setHorizontalAlignment(SwingConstants.CENTER);

        panelPrincipal.add(panelBotones, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(labelEstado, BorderLayout.SOUTH);

        botonAtender.addActionListener(e -> atenderMascota(areaTexto, labelEstado));
        botonAgregar.addActionListener(e -> agregarMascota(areaTexto, labelEstado));
        botonMostrarCola.addActionListener(e -> mostrarCola(areaTexto, labelEstado));
        botonMostrarAtendidas.addActionListener(e -> mostrarAtendidas(areaTexto, labelEstado));
        botonMostrarArbol.addActionListener(e -> mostrarArbol(areaTexto, labelEstado));
        botonEliminar.addActionListener(e -> eliminarMascota(areaTexto, labelEstado));

        add(panelPrincipal);
        actualizarEstado(labelEstado, "Sistema iniciado");
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        return boton;
    }

    private void actualizarEstado(JLabel label, String mensaje) {
        label.setText("Estado: " + mensaje);
    }

    private void atenderMascota(JTextArea areaTexto, JLabel labelEstado) {
        if (cola.getPrimerNodo() == null) {
            actualizarEstado(labelEstado, "No hay mascotas en cola");
            areaTexto.setText("No hay mascotas para atender.");
            return;
        }

        Nodo nodoAtendido = cola.getPrimerNodo();
        cola.eliminarPrimerNodo();
        arbol.eliminarNodo(nodoAtendido);

        // Agregar a la lista de atendidas (lista enlazada)
        if (primeraMascotaAtendida == null) {
            primeraMascotaAtendida = nodoAtendido;
            ultimaMascotaAtendida = nodoAtendido;
        } else {
            ultimaMascotaAtendida.setSiguienteNodo(nodoAtendido);
            ultimaMascotaAtendida = nodoAtendido;
        }

        areaTexto.setText("Mascota atendida: " + nodoAtendido.getMascota().getNombre());
        actualizarEstado(labelEstado, "Atendiendo a " + nodoAtendido.getMascota().getNombre());
    }

    private void agregarMascota(JTextArea areaTexto, JLabel labelEstado) {
        String nombre = JOptionPane.showInputDialog(this, "Nombre de la mascota:");
        if (nombre == null || nombre.trim().isEmpty()) {
            actualizarEstado(labelEstado, "Operación cancelada");
            return;
        }

        // Verificar si ya existe en el árbol
        if (arbol.buscarPorNombre(nombre, arbol.getRaiz()) != null) {
            areaTexto.setText("Error: Ya existe una mascota con ese nombre.");
            actualizarEstado(labelEstado, "Nombre duplicado");
            return;
        }

        Mascota nuevaMascota = new Mascota(nombre, 0);
        Nodo nuevoNodo = new Nodo(nuevaMascota);
        
        cola.insertarAlFinal(nuevoNodo);
        arbol.insertarNodo(nuevoNodo);

        areaTexto.setText("Mascota agregada:\n" + nombre + "\nPosición en cola: " + contarMascotasEnCola());
        actualizarEstado(labelEstado, "Mascota agregada: " + nombre);
    }

    private void mostrarCola(JTextArea areaTexto, JLabel labelEstado) {
        StringBuilder sb = new StringBuilder("COLA DE MASCOTAS:\n");
        Nodo actual = cola.getPrimerNodo();
        int posicion = 1;
        
        while (actual != null) {
            sb.append(posicion++).append(". ").append(actual.getMascota().getNombre()).append("\n");
            actual = actual.getSiguienteNodo();
        }
        
        if (posicion == 1) {
            sb.append("La cola está vacía");
        }
        
        areaTexto.setText(sb.toString());
        actualizarEstado(labelEstado, "Mostrando cola (" + (posicion-1) + " mascotas)");
    }

    private void mostrarAtendidas(JTextArea areaTexto, JLabel labelEstado) {
        StringBuilder sb = new StringBuilder("MASCOTAS ATENDIDAS:\n");
        Nodo actual = primeraMascotaAtendida;
        int contador = 0;
        
        while (actual != null) {
            sb.append(++contador).append(". ").append(actual.getMascota().getNombre()).append("\n");
            actual = actual.getSiguienteNodo();
        }
        
        if (contador == 0) {
            sb.append("No hay mascotas atendidas aún");
        }
        
        areaTexto.setText(sb.toString());
        actualizarEstado(labelEstado, "Mostrando historial (" + contador + " mascotas)");
    }

    private void mostrarArbol(JTextArea areaTexto, JLabel labelEstado) {
        StringBuilder sb = new StringBuilder("RECORRIDOS DEL ÁRBOL:\n\n");
        
        sb.append("Preorden:\n");
        preorden(arbol.getRaiz(), sb);
        sb.append("\nInorden:\n");
        inorden(arbol.getRaiz(), sb);
        sb.append("\nPostorden:\n");
        postorden(arbol.getRaiz(), sb);
        
        areaTexto.setText(sb.toString());
        actualizarEstado(labelEstado, "Mostrando árbol (" + contarNodosArbol(arbol.getRaiz()) + " nodos)");
    }

    private void eliminarMascota(JTextArea areaTexto, JLabel labelEstado) {
    String nombre = JOptionPane.showInputDialog(this, "Nombre de la mascota a eliminar:");
    if (nombre == null || nombre.trim().isEmpty()) {
        actualizarEstado(labelEstado, "Operación cancelada");
        return;
    }

    // Buscar el nodo en el árbol
    Nodo nodoEliminar = arbol.buscarPorNombre(nombre, arbol.getRaiz());
    if (nodoEliminar == null) {
        areaTexto.setText("No se encontró mascota con nombre: " + nombre);
        actualizarEstado(labelEstado, "Mascota no encontrada");
        return;
    }

    // Eliminar el nodo del árbol
    arbol.eliminarNodo(nodoEliminar);

    // Eliminar el nodo de la cola
    cola.eliminarNodo(nodoEliminar);

    areaTexto.setText("Mascota eliminada: " + nombre);
    actualizarEstado(labelEstado, "Mascota eliminada: " + nombre);
}

    // Métodos auxiliares para recorridos del árbol
    private void preorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append("- ").append(nodo.getMascota().getNombre()).append("\n");
            preorden(nodo.getNodoLado(false), sb);
            preorden(nodo.getNodoLado(true), sb);
        }
    }

    private void inorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            inorden(nodo.getNodoLado(false), sb);
            sb.append("- ").append(nodo.getMascota().getNombre()).append("\n");
            inorden(nodo.getNodoLado(true), sb);
        }
    }

    private void postorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            postorden(nodo.getNodoLado(false), sb);
            postorden(nodo.getNodoLado(true), sb);
            sb.append("- ").append(nodo.getMascota().getNombre()).append("\n");
        }
    }

    // Métodos auxiliares para contar elementos
    private int contarMascotasEnCola() {
        int contador = 0;
        Nodo actual = cola.getPrimerNodo();
        while (actual != null) {
            contador++;
            actual = actual.getSiguienteNodo();
        }
        return contador;
    }

    private int contarNodosArbol(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodosArbol(nodo.getNodoLado(false)) + contarNodosArbol(nodo.getNodoLado(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz interfaz = new Interfaz();
            interfaz.setVisible(true);
        });
    }
}