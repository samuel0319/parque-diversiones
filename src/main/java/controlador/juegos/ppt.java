package main.java.controlador.juegos;

public class ppt {
    public int piedra = 1;
    public int papel = 2;
    public int tijera = 3;
    
    public int getEleccion() {

        int seleccion = (int) (Math.random() * 3 + 1);
        return seleccion;
    }

    public int getGanador(int jugador, int jugador2) {

        if (jugador == piedra && jugador2 == tijera || 
        jugador == papel && jugador2 == piedra ||
                jugador == tijera && jugador2 == papel) {

            return 1;
        } 
        else if (jugador2 == piedra && jugador == tijera || 
        jugador2 == papel && jugador == piedra ||
                jugador2 == tijera && jugador == papel) {
            return 2;
        } 
        else {
            return -1;
        } 
    }
}