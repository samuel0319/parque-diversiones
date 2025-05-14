package main.java.vista.adivinarNumero;

import main.java.controlador.juegos.ramdom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaAdivinarNumero extends JFrame{
    private JTextField campoNumero;
    private JButton botonAdivinar;
    private JLabel etiquetaMensaje;

    private int numeroSecreto;

    public vistaAdivinarNumero() {

        campoNumero = new JTextField(10);
        botonAdivinar = new JButton("Adivinar");
        etiquetaMensaje = new JLabel("Introduce un número del 1 al 10");

        numeroSecreto = ramdom.getRandomNumber();

        setLayout(new FlowLayout());
        add(etiquetaMensaje);
        add(campoNumero);
        add(botonAdivinar);

        botonAdivinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarNumero();
            }
        });

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    private void verificarNumero() {
        try {
            int intento = Integer.parseInt(campoNumero.getText());
            boolean resultado = ramdom.validarNumero(numeroSecreto, intento);
            if (resultado) {
                etiquetaMensaje.setText("Ganaste");
            } else {
                etiquetaMensaje.setText("Perdiste");
            }

        } catch (NumberFormatException e) {
            etiquetaMensaje.setText("Por favor, introduce un número válido.");
        }
    }
    
    public static void main(String[] args) {
        new vistaAdivinarNumero();
    }

}
