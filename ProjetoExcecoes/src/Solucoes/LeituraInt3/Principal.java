package Solucoes.LeituraInt3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int valor;
        System.out.print("Por favor, digite um número inteiro: ");
        valor = leInteiro();
        System.out.println("Valor digitado: " + valor);
    }

    public static int leInteiro() {
        String auxiliar;
        int valor;
        Scanner s = new Scanner(System.in);
        do {
            try {
                auxiliar = s.nextLine();
                valor = Integer.parseInt(auxiliar);
                return valor;
            } catch (NumberFormatException nfe) {
                System.out.println("Valor digitado inválido.");
                System.out.print("Tente novamente: ");
            }
        } while (true);
    }
}
