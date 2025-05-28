// vistas hechas con chat gpt y minimos cambios por el usuario

package main.java.vista.vistasAzar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import main.java.controlador.juegos.azar;
import main.java.db.usuario;

public class vistasAzar extends JFrame {

    private JLabel resultadoLabel;
    private usuario user;

    public vistasAzar(usuario user) {
        this.user = user;

        setTitle("Generador de Símbolos Aleatorios");
        setSize(500, 320);
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

                // Verificar si tienes un par
                if (resultado[0].equals(resultado[1]) || resultado[1].equals(resultado[2])) {
                    user.sumarBoletos(100);
                    textoResultado += "¡Ganaste 100 boletos! Total: " + user.getterBoletos();
                } else {
                    user.resBoletos(50); 
                    textoResultado += "Intenta de nuevo. -50 boletos. Total: " + user.getterBoletos();
                }

                resultadoLabel.setText(textoResultado);
            }
        });

        panel.add(generarButton, BorderLayout.SOUTH);

        // Agregar panel a la ventana
        add(panel);
    }
}