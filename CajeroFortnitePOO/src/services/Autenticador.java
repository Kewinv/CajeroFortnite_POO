package services;
import java.util.Scanner;

import models.Cuenta;
public class Autenticador {
    public boolean autenticarUsuario(Scanner scanner, Cuenta cuenta) {
        int intentos = 0;
        
        while (intentos < 3) {
            System.out.println("Ingrese su PIN:");
            if (scanner.hasNextInt()) {
                int pinIngresado = scanner.nextInt();
                
                if (cuenta.verificarPin(pinIngresado)) {
                    System.out.println("¡Bienvenido Fortnite player!");
                    return true;
                } else {
                    intentos++;
                    System.out.println("Pin Incorrecto. -50 de vida\nIntentos: " + intentos);
                }
                
                if (intentos == 3) {
                    System.out.println("Se te bloqueó la cuenta, a jugar salvar el mundo");
                    return false;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
        return false;
    }
}

