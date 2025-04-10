package ui;
import java.util.Scanner;

import models.Cuenta;
import services.Autenticador;
public class SistemaCajero 
{
    private final Scanner scanner;
    private final Cuenta cuenta;
    private final Autenticador autenticador;
    
    public SistemaCajero() 
    {
        this.scanner = new Scanner(System.in);
        this.cuenta = new Cuenta(1234, 50000, 10000);
        this.autenticador = new Autenticador();
    }
    
    public void iniciar() 
    {
        if (!autenticador.autenticarUsuario(scanner, cuenta)) {
            scanner.close();
            return;
        }
        
        mostrarMenuPrincipal();
    }
    
    private void mostrarMenuPrincipal() 
    {
        int opcion;
        do {
            System.out.println("\nCAJERO FORTNITE");
            System.out.println("1. Consultar pavos");
            System.out.println("2. Retirar pack de inicio");
            System.out.println("3. Depositar");
            System.out.println("4. Consultar límite de retiro diario");
            System.out.println("5. Cambiar PIN");
            System.out.println("6. Salir");
            System.out.println("Selecciona tu opción:");
            
            if (scanner.hasNextInt()) 
            {
                opcion = scanner.nextInt();
                procesarOpcion(opcion);
            } 
            else 
            {
                System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
                scanner.next();
                opcion = 0;
            }
        } while (opcion != 6);
        
        scanner.close();
    }
    
    private void procesarOpcion(int opcion) 
    {
        switch (opcion) 
        {
            case 1: cuenta.mostrarSaldo();
                    break;
            case 2: cuenta.realizarRetiro(scanner);
                    break;
            case 3: cuenta.realizarDeposito(scanner);
                    break;
            case 4: cuenta.mostrarLimiteRetiro();
                    break;
            case 5: cuenta.cambiarPin(scanner);
                    break;
            case 6: System.out.println("\nGracias por visitarnos ¡Vuelve pronto!");
                    break;
            default: System.out.println("\nLa opción ingresada no es válida");
        }
    }

}
