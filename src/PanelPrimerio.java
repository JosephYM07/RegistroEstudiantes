import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PanelPrimerio {
    private JPanel VentanaEstudiantes;
    private JLabel Encabezado;
    private JTextField IngresoCodigo;
    private JTextField IngresoCedula;
    private JTextField IngresoNombres;
    private JTextField IngresoApellidos;
    private JComboBox<String> Dia;
    private JComboBox<String> Mes;
    private JComboBox<String> Año;
    private JCheckBox Rojo;
    private JCheckBox Verde;
    private JCheckBox Ninguno;
    private JRadioButton SiEstaCasasdo;
    private JRadioButton NoEstaCasado;
    private JComboBox<String> Signo;
    private JButton cargarDatosDesdeElButton;
    private JButton guardarDatosEnElButton;
    private JButton registroAnteriorButton;
    private JButton registroSiguienteButton;
    private JLabel Codigo;
    private JLabel Cedula;
    private JLabel Apellido;
    private JLabel Nombres;

    private List<Registro> registros = new ArrayList<>();
    private int registroActual = -1;

    public PanelPrimerio() {
        cargarDatosDesdeElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosDesdeArchivo();
            }
        });

        guardarDatosEnElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosEnArchivo();
            }
        });

        registroAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistroAnterior();
            }
        });

        registroSiguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistroSiguiente();
            }
        });
    }

    private void cargarDatosDesdeArchivo() {
        File archivo = new File("data.dat");
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                registros = (List<Registro>) ois.readObject();
                JOptionPane.showMessageDialog(null, "Datos cargados exitosamente");
                registroActual = -1;
                mostrarRegistroSiguiente();
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo de datos");

        }
    }

    private void guardarDatosEnArchivo() {
        File archivo = new File("data.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(registros);
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
        }
    }

    private void mostrarRegistroAnterior() {
        if (registroActual > 0) {
            registroActual--;
            mostrarRegistro(registros.get(registroActual));
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros anteriores");
        }
    }

    private void mostrarRegistroSiguiente() {
        if (registroActual < registros.size() - 1) {
            registroActual++;
            mostrarRegistro(registros.get(registroActual));
        } else {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "No hay más registros");
        }
    }
    //Funcion para mostrar los registros
    private void mostrarRegistro(Registro registro) {
        IngresoCodigo.setText(registro.getCodigo());
        IngresoCedula.setText(registro.getCedula());
        IngresoNombres.setText(registro.getNombres());
        IngresoApellidos.setText(registro.getApellidos());
        Dia.setSelectedItem(registro.getDia());
        Mes.setSelectedItem(registro.getMes());
        Año.setSelectedItem(registro.getAño());
        Rojo.setSelected(registro.isRojo());
        Verde.setSelected(registro.isVerde());
        Ninguno.setSelected(registro.isNinguno());
        SiEstaCasasdo.setSelected(registro.isEstaCasado());
        NoEstaCasado.setSelected(!registro.isEstaCasado());
        Signo.setSelectedItem(registro.getSigno());
    }
    //Funcion para borrar los campo y dejarlos en blanco para que se pueda agregar otro registro
    private void limpiarCampos() {
        IngresoCodigo.setText("");
        IngresoCedula.setText("");
        IngresoNombres.setText("");
        IngresoApellidos.setText("");
        Dia.setSelectedIndex(0);
        Mes.setSelectedIndex(0);
        Año.setSelectedIndex(0);
        // Se pone false para que no se quede seleccionado
        Rojo.setSelected(false);
        Verde.setSelected(false);
        Ninguno.setSelected(false);
        SiEstaCasasdo.setSelected(false);
        NoEstaCasado.setSelected(false);
        Signo.setSelectedIndex(0);
    }

    private void guardarRegistro() {
        boolean rojo, verde, ninguno, estaCasado;
        String codigo, cedula, nombres, apellidos, dia, mes, año, signo;
        codigo = IngresoCodigo.getText();
        cedula = IngresoCedula.getText();
        nombres = IngresoNombres.getText();
        apellidos = IngresoApellidos.getText();
        dia = (String) Dia.getSelectedItem();
        mes = (String) Mes.getSelectedItem();
        año = (String) Año.getSelectedItem();
        rojo = Rojo.isSelected();
        verde = Verde.isSelected();
        ninguno = Ninguno.isSelected();
        estaCasado = SiEstaCasasdo.isSelected();
        signo = (String) Signo.getSelectedItem(); // Se convierte a String porque es un objeto

        Registro registro = new Registro(codigo, cedula, nombres, apellidos, dia, mes, año,
                rojo, verde, ninguno, estaCasado, signo);
        registros.add(registro);
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        limpiarCampos();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PanelPrimerio");
        PanelPrimerio panel = new PanelPrimerio();
        frame.setContentPane(panel.VentanaEstudiantes);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        panel.guardarDatosEnElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.guardarRegistro();
            }
        });
    }
}
