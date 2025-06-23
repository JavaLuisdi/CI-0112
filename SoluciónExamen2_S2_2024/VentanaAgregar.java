// Clase que representa la ventana para agregar un cliente a la cola del banco.
// Permite ingresar el nombre y la prioridad del cliente, y lo agrega a la cola correspondiente.
import javax.swing.*;
public class VentanaAgregar extends JFrame{
    private ColaConPrioridades colaBanco; // Referencia a la cola de prioridades del banco

    // Constructor: inicializa la ventana y los componentes para agregar un cliente
    public VentanaAgregar(ColaConPrioridades colaBanco) {
        this.colaBanco = colaBanco; // Guarda la referencia a la cola
        setTitle("Agregar cliente a la cola"); // Título de la ventana
        setSize(400 , 200); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Oculta la ventana al cerrarla
        setLocationRelativeTo(null); // Centra la ventana

        JPanel ingresarDatos = new JPanel(); // Panel para los campos de entrada
        ingresarDatos.setLayout(new BoxLayout(ingresarDatos, BoxLayout.Y_AXIS)); // Layout vertical

        JLabel etiquetaNombre = new JLabel("Ingrese el nombre del cliente"); // Etiqueta para el nombre
        JTextField campoNombre = new JTextField(); // Campo de texto para el nombre

        // ComboBox para seleccionar la prioridad del cliente
        String[] prioridades = {"Adulto mayor" , "Mujer embarazada" , "Persona con necesidades especiales" , "Cliente regular"};
        JComboBox<String> prioridad = new JComboBox<>(prioridades);

        // Botón para guardar el cliente en la cola
        JButton guardar = new JButton("Agregar cliente");
        guardar.addActionListener(t -> {
            String nombre = campoNombre.getText(); // Obtiene el nombre ingresado
            int prioridadInt = prioridad.getSelectedIndex(); // Obtiene la prioridad seleccionada
            this.colaBanco.agregarCliente(nombre, prioridadInt + 1); // Agrega el cliente a la cola
            JOptionPane.showMessageDialog(null , "Cliente agregado exitosamente"); // Mensaje de éxito
            setVisible(false); // Oculta la ventana
            campoNombre.setText(""); // Limpia el campo de nombre
            prioridad.setSelectedIndex(0); // Reinicia la selección de prioridad
        });

        // Agrega los componentes al panel
        ingresarDatos.add(etiquetaNombre);
        ingresarDatos.add(campoNombre);
        ingresarDatos.add(prioridad);
        ingresarDatos.add(guardar);
        add(ingresarDatos); // Agrega el panel a la ventana
    }
}
