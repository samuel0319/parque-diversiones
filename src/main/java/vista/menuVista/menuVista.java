package main.java.vista.menuVista;

import java.awt.*;
import javax.swing.*;
import main.java.db.usuario;
import main.java.vista.adivinarNumero.vistaAdivinarNumero;

public class menuVista extends JFrame {

    private usuario user;
    private JButton botonJugar;
    private JTextArea areaDatos;

    public menuVista() {
        setTitle("Menú de Usuario");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior de entrada
        JPanel inputPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Ingresa tu nombre:");
        JTextField textField = new JTextField(10);
        JButton aceptarBtn = new JButton("Aceptar");
        botonJugar = new JButton("Ir a Juego");
        botonJugar.setVisible(false); // Oculto hasta que se ingrese un nombre

        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(aceptarBtn);
        inputPanel.add(botonJugar);

        // Área de datos mostrados
        areaDatos = new JTextArea();
        areaDatos.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(areaDatos), BorderLayout.CENTER);

        // Acción del botón "Aceptar"
        aceptarBtn.addActionListener(e -> {
            String nombre = textField.getText().trim();
            if (!nombre.isEmpty()) {
                user = new usuario(nombre, 100);
                areaDatos.setText("Nombre: " + user.getterNombre() + "\nBoletos: " + user.getterBoletos());
                botonJugar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(menuVista.this, "Por favor ingresa un nombre válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción del botón "Ir a Juego"
        botonJugar.addActionListener(e -> {
            new vistaAdivinarNumero(user).setVisible(true);
            dispose(); // Cierra esta ventana
        });
    }

    // 🔁 Constructor que permite volver desde otra vista con el mismo usuario
    public menuVista(usuario user) {
        this(); // Llama al constructor principal
        this.user = user;

        // Actualiza los datos mostrados
        areaDatos.setText("Nombre: " + user.getterNombre() + "\nBoletos: " + user.getterBoletos());
        botonJugar.setVisible(true);
    }

    // Método main para probar la vista
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menuVista().setVisible(true));
    }
}
