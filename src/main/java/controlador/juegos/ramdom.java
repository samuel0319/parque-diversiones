package main.java.controlador.juegos;

public class ramdom {
    
    public static int getRandomNumber() {
        int numero = (int) (Math.random() * 10 + 1); //1 al 10
        return numero;
    }
    
    public static boolean validarNumero(int numero, int gessNumber) {
        return numero == gessNumber;
    }
}
