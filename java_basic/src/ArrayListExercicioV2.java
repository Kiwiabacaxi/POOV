import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListExercicioV2 {
    public static void main(String[] args) {
        // usando ArrayList

        // a) Criar um vetor de tamanho 20 de inteiros
        ArrayList<Integer> vetor = new ArrayList<Integer>();

        // b) Preencher os 10 primeiros valores do vetor com números digitados pelo
        // usuário via teclado
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número: ");
            vetor.add(teclado.nextInt()); // add() adiciona um elemento no fim
        }

        // c) Preencher os 10 últimos valores do vetor com números aleatórios entre 1 e
        // 100
        for (int i = 0; i < 10; i++) {
            vetor.add((int) (Math.random() * 100) + 1);
        }

        // d) Mostrar o vetor inteiro na tela
        System.out.println("Vetor completo: ");
        for (int elemento : vetor) {
            System.out.print("[ " + elemento + " ]" + " ");
        }

        // e) Mostrar o vetor de trás para frente na tela
        System.out.println("\nVetor de trás para frente: ");
        for (int i = vetor.size() - 1; i >= 0; i--) {
            System.out.print("[ " + vetor.get(i) + " ]" + " ");
        }

        // f) Calcular e mostrar a média dos valores do vetor
        double soma = 0;
        System.out.print("\nMédia dos valores do vetor: ");
        for (int elemento : vetor) {
            soma += elemento;
        }

        System.out.println(soma / vetor.size());

        // g) Encontrar e mostrar o maior valor e o menor valor do vetor
        int maior = Collections.max(vetor);
        int menor = Collections.min(vetor);

        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);

        // h) Mostrar os valores das posições pares do vetor
        System.out.println("Valores das posições pares: ");
        for (int i = 0; i < vetor.size(); i += 2) {
            System.out.print("[ " + vetor.get(i) + " ]" + " ");
        }

        // i) Mostrar os valores das posições ímpares do vetor
        System.out.println("\nValores das posições ímpares: ");
        for (int i = 1; i < vetor.size(); i += 2) {
            System.out.print("[ " + vetor.get(i) + " ]" + " ");
        }

        // j) Mostrar os valores pares do vetor
        System.out.println("\nValores pares: ");
        for (int elemento : vetor) {
            if (elemento % 2 == 0) {
                System.out.print("[ " + elemento + " ]" + " ");
            }
        }

        // k) Mostrar os valores ímpares do vetor
        System.out.println("\nValores ímpares: ");
        for (int elemento : vetor) {
            if (elemento % 2 != 0) {
                System.out.print("[ " + elemento + " ]" + " ");
            }
        }

        // l) Verificar se há elementos repetidos no vetor e exibir uma mensagem em caso
        // afirmativo
        boolean repetido = false;
        for (int i = 0; i < vetor.size(); i++) {
            if (Collections.frequency(vetor, vetor.get(i)) > 1) {
                repetido = true;
                break;
            }
        }

        if (repetido) {
            System.out.println("\nHá elementos repetidos no vetor.");
        } else {
            System.out.println("\nNão há elementos repetidos no vetor.");
        }

        // m) Solicitar um valor ao usuário e verificar se esse valor existe no vetor.Se
        // existir exibir a posição em que ele está, senão exibir uma mensagem de valor
        // não encontrado

        System.out.println("Digite um valor: ");
        int valor = teclado.nextInt();
        if (vetor.contains(valor)) {
            System.out.println("O valor " + valor + " está na posição " + vetor.indexOf(valor));
        } else {
            System.out.println("O valor " + valor + " não existe no vetor");
        }

        // n) Verificar se o vetor está em ordem crescente, ou seja, se a[0] <= a[1] <=
        // a[2] <= ... para todos elementos do vetor
        ArrayList<Integer> vetorOrdenado = new ArrayList<Integer>(vetor);
        Collections.sort(vetorOrdenado);
        System.out.println("Vetor ordenado: " + vetorOrdenado);

        if (vetor.equals(vetorOrdenado)) {
            System.out.println("O vetor está em ordem crescente");
        } else {
            System.out.println("O vetor não está em ordem crescente");
        }

        teclado.close();
    }

}