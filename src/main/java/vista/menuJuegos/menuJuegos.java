package main.java.vista.menuJuegos;

import java.awt.*;
import javax.swing.*;
import main.java.db.usuario;
import main.java.vista.adivinarNumero.vistaAdivinarNumero;
import main.java.vista.menuVista.menuVista;

public class menuJuegos extends JFrame {

    private usuario user;

    public menuJuegos(usuario user) {
        this.user = user;

        setTitle("Selecciona un Juego");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel saludo = new JLabel("Hola, " + user.getterNombre() + "! Elige un juego:", SwingConstants.CENTER);
        saludo.setFont(new Font("Arial", Font.BOLD, 16));
        add(saludo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(0, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Juego: Adivinar Número
        JButton btnAdivinar = new JButton("🎯 Adivinar Número");
        btnAdivinar.addActionListener(e -> {
            new vistaAdivinarNumero(user).setVisible(true);
            dispose();
        });

        // Juego futuro (placeholder)
        JButton btnProximamente = new JButton("🕹️ Juego Próximamente");
        btnProximamente.setEnabled(false);

        // Volver al menú
        JButton btnVolver = new JButton("← Volver al Menú");
        btnVolver.addActionListener(e -> {
            new menuVista(user).setVisible(true);
            dispose();
        });

        panelBotones.add(btnAdivinar);
        panelBotones.add(btnProximamente);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.CENTER);
    }
}