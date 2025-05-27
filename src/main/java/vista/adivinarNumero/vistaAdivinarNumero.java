package main.java.vista.adivinarNumero;

import java.awt.*;
import javax.swing.*;
import main.java.controlador.juegos.ramdom;
import main.java.db.usuario;
import main.java.vista.menuVista.menuVista;

public class vistaAdivinarNumero extends JFrame{
    private JTextField campoNumero;
    private JButton botonAdivinar;
    private JLabel etiquetaMensaje;

    private int numeroSecreto; 
    private usuario user;
    private JButton volverBtn;

    public vistaAdivinarNumero(usuario user) {
        this.user = user;

        campoNumero = new JTextField(15);
        botonAdivinar = new JButton("Adivinar");
        etiquetaMensaje = new JLabel("Introduce un número del 1 al 10");
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
            dispose(); // Cierra la ventana actual
        });

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    private void verificarNumero() {
        try {
            int intento = Integer.parseInt(campoNumero.getText());
            boolean resultado = ramdom.validarNumero(numeroSecreto, intento);
            if (resultado) {
                user.sumarBoletos(50);
                etiquetaMensaje.setText("¡Ganaste 50 boletos! Total: " + user.getterBoletos());
            } else {
                user.resBoletos(50);
                etiquetaMensaje.setText("Perdiste 50 boletos. Total: " + user.getterBoletos());
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