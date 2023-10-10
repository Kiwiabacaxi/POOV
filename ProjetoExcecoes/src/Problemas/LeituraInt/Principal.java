package Problemas.LeituraInt;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int valor;
        Scanner s = new Scanner(System.in);
        System.out.print("Por favor, digite um número inteiro: ");
        valor = s.nextInt();
        System.out.println("Valor digitado: " + valor);
    }

}
