import javax.swing.*;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ventana principal de la aplicación de la veterinaria.
 * Permite gestionar la fila, historial y registro de mascotas.
 */
public class VentanaPrincipal extends JFrame {
    /**
     * Constructor de la ventana principal.
     * Configura la interfaz gráfica y los botones de acción.
     * @param veterinaria Instancia de la veterinaria a gestionar
     */
    public VentanaPrincipal(Veterinaria veterinaria) {
        setTitle("Veterinaria los Trolls");
        setSize(500 , 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel para los botones de opciones
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout());

        // Botón para atender la siguiente mascota en la fila
        JButton botonAtender = new JButton("Atender siguiente mascota");
        botonAtender.addActionListener(t -> {
            if (veterinaria.getFila().getPrimerNodo() == null) {
                JOptionPane.showMessageDialog(null, "No hay mascotas por atender");
            } else {
                JOptionPane.showMessageDialog(null, "Atendiendo a la mascota: " + veterinaria.getFila().getPrimerNodo().getMascota().getNombre());
                veterinaria.getFila().eliminarPrimerNodo();
                File archivo = new File("fila.txt");
                try {
                    FileWriter writerHistorial = new FileWriter("historial.txt" , true);
                    BufferedReader br = new BufferedReader(new FileReader(archivo));
                    String primeraLinea = br.readLine();
                    veterinaria.getHistorial().insertarAlFinal(new Nodo(new Mascota(primeraLinea)));
                    writerHistorial.write(primeraLinea + "\n");
                    String linea;
                    String contenidoSinPrimeraLinea = "";
                    while ((linea = br.readLine()) != null) {
                        contenidoSinPrimeraLinea += linea + "\n";
                    }
                    FileWriter writer = new FileWriter("fila.txt" , false);
                    writer.write(contenidoSinPrimeraLinea);
                    writer.close();
                    br.close();
                    writerHistorial.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo de la fila: " + e.getMessage());
                }
            }
        });

        // Botón para agregar una nueva mascota a la fila y al registro
        JButton botonAgregar = new JButton("Agregar mascota");
        botonAgregar.addActionListener(t -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
            if (nombre != null) {
                try {
                    FileWriter writerFila = new FileWriter("fila.txt" , true);
                    writerFila.write(nombre + "\n");
                    Mascota nuevaMascota = new Mascota(nombre);
                    Nodo nuevoNodoFila = new Nodo(nuevaMascota);
                    veterinaria.getFila().insertarAlFinal(nuevoNodoFila);
                    writerFila.close();
                    JOptionPane.showMessageDialog(null , "La mascota ha sido agregada a la fila");
                    // Si la mascota no está en el registro, la agrega
                    if (veterinaria.getRegistro().getRaiz() == null || veterinaria.getRegistro().buscarPorNombre(nombre , veterinaria.getRegistro().getRaiz()) == null) {
                        Nodo nuevoNodoRegistro = new Nodo(nuevaMascota);
                        veterinaria.getRegistro().insertarNodo(nuevoNodoRegistro);
                        FileWriter writerRegistro = new FileWriter("registro.txt" , true);
                        writerRegistro.write(nombre + "\n");
                        writerRegistro.close();
                        JOptionPane.showMessageDialog(null , "La mascota ha sido registrada");
                    }
                } catch (IOException m) {
                    JOptionPane.showMessageDialog(null , "Error al registrar la mascota");
                }
            }
        });

        // Botón para mostrar la fila de mascotas
        JButton botonMostrarFila = new JButton("Mostrar fila de mascotas");
        botonMostrarFila.addActionListener(y -> {
            if (veterinaria.getFila().getPrimerNodo() == null) {
                JOptionPane.showMessageDialog(null, "La fila está vacía");
            } else {
                String fila = veterinaria.getFila().mostrarCola(veterinaria.getFila().getPrimerNodo(), 1);
                JOptionPane.showMessageDialog(null, fila);
            }
        });

        // Botón para mostrar el historial de mascotas atendidas
        JButton botonMostrarHistorial = new JButton("Mostrar mascotas atendidas");
        botonMostrarHistorial.addActionListener(u -> {
            if (veterinaria.getHistorial().getPrimerNodo() == null) {
                JOptionPane.showMessageDialog(null, "El historial está vacío");
            } else {
                String historial = veterinaria.getHistorial().mostrarCola(veterinaria.getHistorial().getPrimerNodo(), 1);
                JOptionPane.showMessageDialog(null, historial);
            }
        });

        // Botón para mostrar gráficamente el árbol binario de mascotas
        JButton botonMostrarArbol = new JButton("Mostrar registro de mascotas");
        botonMostrarArbol.addActionListener(i -> {
            JFrame frame = new JFrame("Árbol de Mascotas");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new ArbolPanel(veterinaria.getRegistro().getRaiz()));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // Botón para eliminar una mascota del registro
        JButton botonEliminar = new JButton("Eliminar una mascota del registro");
        botonEliminar.addActionListener(h -> {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota que desea eliminar del registro");
            if (nombre != null) {
                try {
                    File registro = new File("registro.txt");
                    BufferedReader registroReader = new BufferedReader(new FileReader(registro));
                    String linea;
                    String nuevoContenido = "";
                    while ((linea = registroReader.readLine()) != null) {
                        if (!nombre.equals(linea)) {
                            nuevoContenido += linea + "\n";
                        }
                    }
                    FileWriter registroWriter = new FileWriter(registro);
                    registroWriter.write(nuevoContenido);
                    registroReader.close();
                    registroWriter.close();
                } catch (IOException j) {
                    JOptionPane.showMessageDialog(null , "No hay registro guardado");
                }
                

                Nodo nodoEliminar = veterinaria.getRegistro().buscarPorNombre(nombre, veterinaria.getRegistro().getRaiz());
                if (nodoEliminar == null) {
                    JOptionPane.showMessageDialog(null, "La mascota no ha sido registrada");
                } else {
                    veterinaria.getRegistro().eliminarNodo(nodoEliminar);
                    JOptionPane.showMessageDialog(null, "La mascota ha sido eliminada del registro");
                }
            }
        });

        // Agrega los botones al panel de opciones
        panelOpciones.add(botonAtender);
        panelOpciones.add(botonAgregar);
        panelOpciones.add(botonMostrarFila);
        panelOpciones.add(botonMostrarHistorial);
        panelOpciones.add(botonMostrarArbol);
        panelOpciones.add(botonEliminar);

        // Agrega el panel de opciones a la ventana principal
        add(panelOpciones);

        // Carga la información de los archivos de texto al iniciar la aplicación
        File filaTXT = new File("fila.txt");
        File historialTXT = new File("historial.txt");
        File registroTXT = new File("registro.txt");
        String linea;
        try {
            BufferedReader filaReader = new BufferedReader(new FileReader(filaTXT));
            while ((linea = filaReader.readLine()) != null) {
                veterinaria.getFila().insertarAlFinal(new Nodo(new Mascota(linea)));
            }
            filaReader.close();
        } catch (IOException g) {
            JOptionPane.showMessageDialog(null , "No hay fila por cargar");
        }

        try {
            BufferedReader historialReader = new BufferedReader(new FileReader(historialTXT));
            while ((linea = historialReader.readLine()) != null) {
                veterinaria.getHistorial().insertarAlFinal(new Nodo(new Mascota(linea)));
            }
            historialReader.close();
        } catch (IOException p) {
            JOptionPane.showMessageDialog(null , "No hay historial por cargar");
        }
            
        try {
            BufferedReader registroReader = new BufferedReader(new FileReader(registroTXT));
            while ((linea = registroReader.readLine()) != null) {
                veterinaria.getRegistro().insertarNodo(new Nodo(new Mascota(linea)));
            }
            registroReader.close();   
        } catch (IOException p) {
                JOptionPane.showMessageDialog(null , "No hay registro por cargar");
        }
    }

    /**
     * Método principal para iniciar la aplicación.
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();
        VentanaPrincipal interfaz = new VentanaPrincipal(veterinaria);
        interfaz.setVisible(true);
    }

}
