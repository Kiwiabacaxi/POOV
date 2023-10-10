package ExemploFinally1;

import java.util.InputMismatchException;
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
        } catch (ArithmeticException e) {
            System.out.println("Divisão po 0: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Estouro indice array: " + e);
        } catch (InputMismatchException e) {
            System.out.println("Valor digitado invalido: " + e);
        } finally {
            System.out.println("Isso executa não importa o que aconteça...");
        }
        System.out.println("Execução continua.");
    }
}
