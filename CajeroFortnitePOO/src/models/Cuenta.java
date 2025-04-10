package models;
import java.util.Scanner;

public class Cuenta 
{
    private int pin;
    private double saldo;
    private final double limiteRetiroDiario;
    
    public Cuenta(int pin, double saldoInicial, double limiteRetiroDiario) 
    {
        this.pin = pin;
        this.saldo = saldoInicial;
        this.limiteRetiroDiario = limiteRetiroDiario;
    }
    
    public boolean verificarPin(int pinIngresado) 
    {
        return pinIngresado == pin;
    }
    
    public void mostrarSaldo() 
    {
        System.out.println("\nTienes en tu cuenta $" + saldo);
    }
    
    public void realizarRetiro(Scanner scanner) 
    {
        System.out.println("¿Cuántos pavos deseas sacar? $");
        if (scanner.hasNextDouble()) {
            double retiro = scanner.nextDouble();
            
            if (retiro <= 0)
            {
                System.out.println("\nEl monto debe ser positivo");
            } 
            else if (retiro > saldo) 
            {
                System.out.println("\n¡No tienes esos pavos para retirar! Tu saldo es de: " + saldo);
            } 
            else if (retiro > limiteRetiroDiario) 
            {
                System.out.println("\nNo puedes retirar más de $" + limiteRetiroDiario + " en un día.");
            } 
            else 
            {
                saldo -= retiro;
                System.out.println("\n¡Repampanos! Retiraste pavos, tu nuevo saldo es de: " + saldo + " Pavos");
            }
        } 
        else 
        {
            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
            scanner.next();
        }
    }
    
    public void realizarDeposito(Scanner scanner) 
    {
        System.out.println("¿Cuántos pavos deseas depositar? $");
        if (scanner.hasNextDouble()) 
        {
            double deposito = scanner.nextDouble();
            
            if (deposito > 0) 
            {
                saldo += deposito;
                System.out.println("\n¡Consignación exitosa! Tu nuevo saldo en pavos es de: " + saldo);
            } 
            else 
            {
                System.out.println("\nEl valor que ingresaste no es posible depositarlo");
            }
        } 
        else 
        {
            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
            scanner.next();
        }
    }
    
    public void mostrarLimiteRetiro() 
    {
        System.out.println("\nTu límite de retiro diario es de: $" + limiteRetiroDiario);
    }
    
    public void cambiarPin(Scanner scanner) 
    {
        System.out.println("\nIngrese su nuevo PIN:");
        if (scanner.hasNextInt()) 
        {
            pin = scanner.nextInt();
            System.out.println("\nPIN cambiado exitosamente.");
        } 
        else 
        {
            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
            scanner.next();
        }
    }
}
