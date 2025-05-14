package main.java.controlador.menu;

import java.util.Scanner;
import main.java.db.usuario;

public class interfaz {
 
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        String invitado = sc.nextLine();

        usuario user = new usuario(invitado, 100);

        System.out.println(user.getterNombre() + " " + user.getterBoletos());
        
    }
}