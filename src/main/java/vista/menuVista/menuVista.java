package main.java.vista.menuVista;

import java.awt.*;
import javax.swing.*;
import main.java.db.usuario;
import main.java.vista.menuJuegos.menuJuegos;

public class menuVista extends JFrame {

    private usuario user;
    private JButton botonJugar;
    private JTextArea areaDatos;
    private JButton aceptarBtn;
    private JTextField textField;

    // Constructor para nuevo usuario
    public menuVista() {
        inicializarInterfaz(true);
    }

    // Constructor para usuario existente
    public menuVista(usuario user) {
        this.user = user;
        inicializarInterfaz(false);

        // Mostrar datos directamente
        areaDatos.setText("Nombre: " + user.getterNombre() + "\nBoletos: " + user.getterBoletos());
        botonJugar.setVisible(true);
    }

    private void inicializarInterfaz(boolean mostrarEntradaNombre) {
        setTitle("Menú de Usuario");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());

        if (mostrarEntradaNombre) {
            JLabel label = new JLabel("Ingresa tu nombre:");
            textField = new JTextField(10);
            aceptarBtn = new JButton("Aceptar");
            inputPanel.add(label);
            inputPanel.add(textField);
            inputPanel.add(aceptarBtn);

            aceptarBtn.addActionListener(e -> {
                String nombre = textField.getText().trim();
                if (!nombre.isEmpty()) {
                    user = new usuario(nombre, 100);
                    areaDatos.setText("Nombre: " + user.getterNombre() + "\nBoletos: " + user.getterBoletos());
                    botonJugar.setVisible(true);
                    aceptarBtn.setVisible(false);
                    textField.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(menuVista.this, "Por favor ingresa un nombre válido.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        botonJugar = new JButton("Juegos");
        botonJugar.setVisible(!mostrarEntradaNombre);
        botonJugar.addActionListener(e -> {
            new menuJuegos(user).setVisible(true);
            dispose();
        });

        inputPanel.add(botonJugar);

        areaDatos = new JTextArea();
        areaDatos.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(areaDatos), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menuVista().setVisible(true));
    }
}
