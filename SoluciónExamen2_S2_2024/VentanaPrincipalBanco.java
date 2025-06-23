// Clase principal de la interfaz gráfica del banco.
// Permite agregar clientes, atenderlos según prioridad y cerrar el banco mostrando la cola restante.
import javax.swing.*;
import java.awt.FlowLayout;

public class VentanaPrincipalBanco extends JFrame {
    ColaConPrioridades colaBanco; // Cola con prioridades para gestionar los clientes
    VentanaAgregar ventanaAgregar; // Ventana secundaria para agregar clientes

    // Constructor: inicializa la ventana principal y los componentes de la interfaz
    public VentanaPrincipalBanco() {
        this.colaBanco = new ColaConPrioridades(); // Crea la cola de clientes
        this.ventanaAgregar = new VentanaAgregar(this.colaBanco); // Crea la ventana para agregar clientes
        setTitle("Banco Popular"); // Título de la ventana
        setSize(400 , 200); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panelBotonesPrincipales = new JPanel(); // Panel para los botones principales
        panelBotonesPrincipales.setLayout(new FlowLayout(FlowLayout.CENTER)); // Layout de los botones

        // Botón para atender al siguiente cliente según prioridad
        JButton atender = new JButton("Atender siguiente cliente");
        atender.addActionListener(e -> {
            if (colaBanco.vacia()) {
                JOptionPane.showMessageDialog(null, "No hay clientes por atender");
            } else {
                JOptionPane.showMessageDialog(null, "Atendiendo al cliente: " + this.colaBanco.getSiguienteCliente().getNombre());
                colaBanco.atenderCliente();
            }
        });

        // Botón para abrir la ventana de agregar cliente
        JButton agregar = new JButton("Agregar cliente a la cola");
        agregar.addActionListener(r -> {
            this.ventanaAgregar.setVisible(true);
        });

        // Botón para cerrar el banco y mostrar los clientes restantes en la cola
        JButton cerrar = new JButton("Cerrar banco");
        cerrar.addActionListener(y -> {
            JOptionPane.showMessageDialog(null, "Banco cerrado\n" + "Clientes en la cola:\n" + this.colaBanco.mostrarClientes(this.colaBanco.getAdultoMayor().getPrimerCliente() , 0));
        });

        // Agrega los botones al panel
        panelBotonesPrincipales.add(atender);
        panelBotonesPrincipales.add(agregar);
        panelBotonesPrincipales.add(cerrar);
        add(panelBotonesPrincipales); // Agrega el panel a la ventana principal
    }

    // Método principal: inicia la aplicación mostrando la ventana principal
    public static void main(String[] args) {
        VentanaPrincipalBanco ventanaPrincipal = new VentanaPrincipalBanco();
        ventanaPrincipal.setVisible(true);
    }
}