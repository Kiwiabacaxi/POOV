package Solucoes.LeituraInt2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int valor;
        String auxiliar;
        boolean ok = false;
        Scanner s = new Scanner(System.in);
        System.out.print("Por favor, digite um número inteiro: ");
        do {
            try {
                auxiliar = s.nextLine();
                valor = Integer.parseInt(auxiliar);
                System.out.println("Valor digitado: " + valor);
                ok = true;
            } catch (NumberFormatException nfe) {
//                System.out.println(nfe);
//                for (StackTraceElement s1 : nfe.getStackTrace()) {
//                    System.out.println(s1);
//                }
                System.out.println("Valor digitado inválido.");
                System.out.print("Tente novamente: ");
            }
        } while (!ok);
    }
}
