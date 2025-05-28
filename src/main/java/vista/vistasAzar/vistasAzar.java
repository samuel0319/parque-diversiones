package main.java.vista.vistasAzar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.controlador.juegos.azar;

public class vistasAzar extends JFrame {

    private JLabel resultadoLabel;

    public vistasAzar() {
        setTitle("Generador de Símbolos Aleatorios");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta del resultado
        resultadoLabel = new JLabel("Presiona 'Generar' para obtener símbolos", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(resultadoLabel, BorderLayout.CENTER);

        // Botón para generar símbolos
        JButton generarButton = new JButton("Generar");
        generarButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azar generador = new azar();
                String[] resultado = generador.spinRow();

                String textoResultado = resultado[0] + "  " + resultado[1] + "  " + resultado[2];

                // Verificar si todos los símbolos son iguales
                if (resultado[0].equals(resultado[1]) && resultado[1].equals(resultado[2])) {
                    textoResultado += "  🎉 ¡Ganaste!";
                }

                resultadoLabel.setText(textoResultado);
            }
        });

        panel.add(generarButton, BorderLayout.SOUTH);

        // Agregar panel a la ventana
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            vistasAzar ventana = new vistasAzar();
            ventana.setVisible(true);
        });
    }
}