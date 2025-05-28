package main.java.controlador.juegos;

public class ramdom {

    public static int getRandomNumber() {
        int numero = (int) (Math.random() * 4 + 1); //1 al 5
        return numero;
    }

    public static boolean getIntentos(int numeroSecreto) {
        int intentos = 3;

        while (intentos > 0) {
            int intento = getRandomNumber();
            if (intento == numeroSecreto) {
                return true;
            } else {
                intentos--;
            }
        }
        return false;
    }

    public static boolean validarNumero(int numero, int gessNumber) {
        return numero == gessNumber;
    }
}