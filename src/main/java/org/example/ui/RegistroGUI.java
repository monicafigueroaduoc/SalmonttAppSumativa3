package org.example.ui;

import org.example.data.GestorEntidades;
import org.example.model.CentroCultivo;
import org.example.model.PlantaProceso;
import org.example.model.Proveedor;
import org.example.model.Registrable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaz gráfica principal del sistema SalmonttApp.
 * Permite registrar distintas entidades del sistema y
 * visualizar un resumen de las entidades creadas.
 */
public class RegistroGUI extends JFrame {

    // Campos de entrada para los datos comunes.
    private JTextField txtNombre, txtComuna, txtExtra;

    // Combox para seleccionar el tipo de entidad.
    private JComboBox<String>  cbTipo;

    // Área de texto para mostrar resúmenes.
    private JTextArea txtAreaLog;

    // Botones de acción de la interfaz.
    private JButton btnGuardar, btnSalir;

    // Gestor encargado de almacenar las entidades.
    private final GestorEntidades gestor;

    /**
     * Constructor de la entidad gráfica.
     * Inicializa la ventana y sus componentes.
     */
    public RegistroGUI() {
        // Se crea el gestor que administrará las entidades registradas.
        gestor = new GestorEntidades();

        // Configuración básica de la ventana.
        setTitle("SalmonttApp - Registro de entidades");
        setSize(550, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se utiliza setLayout nulo para posicionar manualmente a los componentes.
        setLayout(null);

        // Se inicializan y agregan los componentes gráficos.
        initComponentes();
    }
    // Inicializa y posiciona todos los componentes gráficos.
    private void initComponentes() {

        // Etiquetas.
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 120, 25);
        add(lblNombre);

        JLabel lblComuna = new JLabel("Comuna:");
        lblComuna.setBounds(20, 60, 120, 25);
        add(lblComuna);

        JLabel lblTipo = new JLabel("Tipo Entidad:");
        lblTipo.setBounds(20, 100, 120, 25);
        add(lblTipo);

        JLabel lblExtra = new JLabel("Dato Extra:");
        lblExtra.setBounds(20, 140, 200, 25);
        add(lblExtra);

        JLabel lblInstruccion = new JLabel(
                "<html>(Produccion o Capacidad en toneladas<br> / Tipo de Proveedor)<html>");
        lblInstruccion.setBounds(310, 140, 230, 40);
        add(lblInstruccion);

        // Campos de texto.
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 150, 25);
        add(txtNombre);

        txtComuna = new JTextField();
        txtComuna.setBounds(150, 60, 150, 25);
        add(txtComuna);

        txtExtra = new JTextField();
        txtExtra.setBounds(150, 140, 150, 25);
        add(txtExtra);

        // ComboBox.
        cbTipo = new JComboBox<>(new String[] {"CentroCultivo", "PlantaProceso", "Proveedor"});
        cbTipo.setBounds(150, 100, 150, 25);
        add(cbTipo);

        //Botón registrar entidad.
        btnGuardar = new JButton("Registrar Entidad");
        btnGuardar.setBounds(20, 190, 480, 30);
        add(btnGuardar);

        // Área de resultados.
        txtAreaLog = new JTextArea();
        txtAreaLog.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtAreaLog);
        scroll.setBounds(20, 280, 500, 200);
        add(scroll);

        //Botón salir.
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(20, 500, 480, 30);
        add(btnSalir);

        // Eventos
        btnGuardar.addActionListener(e -> registrarEntidad());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    /**
     * Registra una entidad según el tipo seleccionado y
     * actualiza el resumen en pantalla.
     */
    private void registrarEntidad() {

        // Se obtienen los valores ingresados por el usuario y
        //se eliminan espacios.
        String nombre = txtNombre.getText().trim();
        String comuna = txtComuna.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();
        String extra = txtExtra.getText().trim();

        // Validación básica, ningún campo puede estar vacío.
        if (nombre.isEmpty() || comuna.isEmpty() || tipo.isEmpty() || extra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Registrable entidad;

            // Creación del objeto según el tipo seleccionado.
            switch (tipo) {
                case "CentroCultivo":
                    double prod = Double.parseDouble(extra);
                    entidad = new CentroCultivo(nombre, comuna, prod);
                    break;

                case "PlantaProceso":
                    double cap = Double.parseDouble(extra);
                    entidad = new PlantaProceso(nombre, comuna, cap);
                    break;

                default:
                    entidad = new Proveedor(nombre, comuna, extra);
            }

            // Se agrega la entidad a la colección.
            gestor.agregarEntidad(entidad);
            JOptionPane.showMessageDialog(this, "Entidad registrada correctamente",
                    "Exito", JOptionPane.INFORMATION_MESSAGE);

            // Se actualiza el área de texto con los resúmenes.
            actualizarLog();

            // Se limpian los campos para un nuevo ingreso.
            txtNombre.setText("");
            txtComuna.setText("");
            txtExtra.setText("");
            cbTipo.setSelectedIndex(0);

        } catch (NumberFormatException ex) {
            // Captura error cuando se espera un número y se ingresa texto.
            if (!tipo.equals("Proveedor")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Actualiza el área de texto mostrando el
     * resumen de todas las entidades registradas.
     */
    private void actualizarLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("===ENTIDADES REGISTRADAS===\n\n");

        for (Registrable r : gestor.getEntidades()) {
            sb.append(r.mostrarResumen()).append("\n");
        }
        txtAreaLog.setText(sb.toString());
    }
}
