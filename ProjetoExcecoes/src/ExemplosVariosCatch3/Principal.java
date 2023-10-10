package ExemplosVariosCatch3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int a, b, c[], i;
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Digite um numero inteiro: ");
            a = s.nextInt();
            System.out.println("Valor lido = " + a);
            System.out.print("Digite um tamanho: ");
            i = s.nextInt();
            System.out.println("Tamanho lido = " + i);
            c = new int[i];
            System.out.print("Digite um indice: ");
            i = s.nextInt();
            System.out.println("Indice lido = " + i);
            b = 42 / a;
            c[i] = 99;
        } catch (Exception e) {
            System.out.println("Aconteceu algum problema: " + e);
        }
        System.out.println("Execução continua.");
    }
}
