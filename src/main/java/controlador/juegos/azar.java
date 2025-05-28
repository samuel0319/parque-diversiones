package main.java.controlador.juegos;

public class azar {
    public String[] spinRow() {
        String[] simbolos = { "♣️", "♠️", "♥️", "♦️" };
        String[] cadenas = new String[3];

        for (int i = 0; i < 3; i++) {
            int wa = (int) (Math.random() * simbolos.length);
            cadenas[i] = simbolos[wa];
        }
        return cadenas;
    }
}