package main.java.controlador.dialogos;

import java.util.Scanner;

public class Personaje {
 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime tu nombre querid@");

        String invitado = sc.nextLine();

        System.out.println("Buenas tardes, " + invitado + " bienvenidos al parque de atracciones !!!");
        
        System.out.println("Pero antes dejemos las cosas claras desde el inicio");

        int puntosIniciles = 100;

        System.out.println("esto van a ser tus puntos " + puntosIniciles + " pero no te desanimes, siempre que jueges puedes conseguir mas");
        
        System.out.println("asi que cambie juguemos un jueguito de numeros JA JA JA ");

        System.out.println("chao");


    }
}