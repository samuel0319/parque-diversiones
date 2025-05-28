// vistas hechas con chat gpt y minimos cambios por el usuario

package main.java.vista.adivinarNumero;

import java.awt.*;
import javax.swing.*;
import main.java.controlador.juegos.ramdom;
import main.java.db.usuario;
import main.java.vista.menuVista.menuVista;

public class vistaAdivinarNumero extends JFrame {
    private JTextField campoNumero;
    private JButton botonAdivinar;
    private JLabel etiquetaMensaje;

    private int numeroSecreto;
    private int intentosRestantes = 3;

    private usuario user;
    private JButton volverBtn;

    public vistaAdivinarNumero(usuario user) {
        this.user = user;

        campoNumero = new JTextField(15);
        botonAdivinar = new JButton("Adivinar");
        etiquetaMensaje = new JLabel("Introduce un número del 1 al 5 (Tienes 3 intentos)");
        volverBtn = new JButton("Volver al Menú");
        numeroSecreto = ramdom.getRandomNumber();

        setLayout(new FlowLayout());
        add(etiquetaMensaje);
        add(campoNumero);
        add(botonAdivinar);
        add(volverBtn);

        botonAdivinar.addActionListener(e -> verificarNumero());

        volverBtn.addActionListener(e -> {
            new menuVista(user).setVisible(true);
            dispose();
        });

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void verificarNumero() {
        try {
            int intento = Integer.parseInt(campoNumero.getText());

            if (intento < 1 || intento > 5) {
                etiquetaMensaje.setText("Número fuera de rango (1-5). Intentos restantes: " + intentosRestantes);
                return;
            }

            boolean resultado = ramdom.validarNumero(numeroSecreto, intento);

            if (resultado) {
                user.sumarBoletos(150);
                etiquetaMensaje.setText(" ¡Ganaste 150 boletos! Total: " + user.getterBoletos());
                botonAdivinar.setEnabled(false);
            } else {
                intentosRestantes--;
                if (intentosRestantes > 0 ) {

                    etiquetaMensaje.setText("❌ Incorrecto. Te quedan " + intentosRestantes + " intentos.");
                } else {
                    user.resBoletos(50);
                    etiquetaMensaje.setText(" Perdiste. Era el " + numeroSecreto + ". -50 boletos. Total: " + user.getterBoletos());
                    botonAdivinar.setEnabled(false);
                }
            }

        } catch (NumberFormatException e) {
            etiquetaMensaje.setText("Por favor, introduce un número válido.");
        }
    }

    public static void main(String[] args) {
        usuario testUser = new usuario("Test", 100);
        new vistaAdivinarNumero(testUser).setVisible(true);
    }
}