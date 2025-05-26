import javax.swing.*;
import java.awt.FlowLayout;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Formulario de usuario");
        setSize(400 , 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        salirItem.addActionListener(e -> System.exit(0));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout (panelFormulario , BoxLayout.Y_AXIS));

        JLabel etiquetaNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Teléfono:");
        JTextField campoTelefono = new JTextField(20);

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        add(panelFormulario);

        JLabel etiquetaTipo = new JLabel("Tipo de usuario:");
        String[] tiposUsuario = {"Cliente" , "Empleado" , "Administrador"};
        JComboBox<String> comboTipo = new JComboBox<>(tiposUsuario);

        panelFormulario.add(etiquetaTipo);
        panelFormulario.add(comboTipo);

        JCheckBox checkTerminos = new JCheckBox("Acepto los términos y condiciones");
        panelFormulario.add(checkTerminos);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setEnabled(false);
        checkTerminos.addActionListener(e -> botonGuardar.setEnabled(checkTerminos.isSelected()));      
        botonGuardar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();
            String tipo = (String) comboTipo.getSelectedItem();

            try {
                FileWriter writer = new FileWriter("datos_usuario.txt" , true);
                writer.write("Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono + ", Tipo de usuario: " + tipo + System.lineSeparator());
                writer.close();
                JOptionPane.showMessageDialog(null , "Datos guardados exitosamente");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos");
            }
        });

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(e -> {
            campoNombre.setText("");
            campoEmail.setText("");
            campoTelefono.setText("");
            comboTipo.setSelectedIndex(0);
            checkTerminos.setSelected(false);
            botonGuardar.setEnabled(false);
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(botonGuardar);
        panelBotones.add(botonLimpiar);
        panelFormulario.add(panelBotones);

        File archivo = new File("datos_usuario.txt");
        if (archivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new java.io.FileReader(archivo));
                String linea = br.readLine();
                if (linea != null && !linea.isEmpty()) {
                    String[] partes = linea.split(",");
                    for (String parte : partes) {
                        String[] etiquetaYValor = parte.split(":");
                        String etiqueta = etiquetaYValor[0].trim();
                        String valor = etiquetaYValor[1].trim();
                        switch (etiqueta) {
                            case "Nombre":
                                campoNombre.setText(valor);
                                break;
                            case "Email":
                                campoEmail.setText(valor);
                                break;
                            case "Teléfono":
                                campoTelefono.setText(valor);
                                break;
                            case "Tipo de usuario":
                                comboTipo.setSelectedItem(valor);
                                break;
                        }
                    }
                }
                br.close();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}