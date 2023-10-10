package Solucoes.LeituraInt1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int valor;
        Scanner s = new Scanner(System.in);
        System.out.print("Por favor, digite um número inteiro: ");
        try {
            valor = s.nextInt();
            System.out.println("Valor digitado: " + valor);
        } catch (InputMismatchException e) {
            System.out.println("Valor digitado inválido.");
        }
        System.out.println("Continuação da execução");
    }

}
