package main.java.db;

public class usuario {

    private String nombre;

    private int boletos;

    private boolean incertidumbre;

    public usuario (String nombre, int boletos){

        this.nombre = nombre;

        this.boletos = boletos;

    }

    public String getterNombre() {

        return this.nombre;

    }

    public void sumarBoletos(int sumBoletos) {
        this.boletos += sumBoletos;

    }

    public void resBoletos(int resBoletos) {
        this.boletos -= resBoletos;
    }


    public int getterBoletos() {
        return this.boletos;
    }
    public static void main(String[] args) {
        usuario user = new usuario("paco", 20);

        System.out.println(user.getterNombre() + " " + user.getterBoletos());

    }

}
