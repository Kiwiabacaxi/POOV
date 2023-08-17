import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExercicio {
    public static void main(String[] args) {
        // usando ArrayList

        // a) Criar um vetor de tamanho 20 de inteiros
        ArrayList<Integer> vetor = new ArrayList<Integer>();

        // b) Preencher os 10 primeiros valores do vetor com números digitados pelo
        // usuário via teclado
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            // System.out.println("Digite um número: ");
            // vetor.add(teclado.nextInt()); // add() adiciona um elemento no fim
            vetor.add((int) (Math.random() * 50) + 1); // o + 1 elimina o zero || e o random() * "seu número" gera
                                                       // números de 0 a "seu número" - 1

        }

        // c) Preencher os 10 últimos valores do vetor com números aleatórios entre 1 e
        // 100
        for (int i = 10; i < 20; i++) {
            vetor.add((int) (Math.random() * 100) + 1);
        }

        // d) Mostrar o vetor inteiro na tela
        System.out.println("Vetor completo: ");
        for (int i = 0; i < vetor.size(); i++) {
            System.out.print("[ " + vetor.get(i) + " ]" + " "); // get() retorna o elemento na posição i
        }

        // e) Mostrar o vetor de trás para frente na tela
        System.out.println("\nVetor de trás para frente: ");
        for (int i = vetor.size() - 1; i >= 0; i--) {
            System.out.print("[ " + vetor.get(i) + " ]" + " ");
        }

        // f) Calcular e mostrar a média dos valores do vetor
        double soma = 0;
        System.out.print("\nMédia dos valores do vetor: ");
        for (int i = 0; i < vetor.size(); i++) {
            soma += vetor.get(i);
        }

        System.out.println(soma / vetor.size());

        // g) Encontrar e mostrar o maior valor e o menor valor do vetor
        int maior = vetor.get(0);
        int menor = vetor.get(0);

        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i) > maior) {
                maior = vetor.get(i);
            }
            if (vetor.get(i) < menor) {
                menor = vetor.get(i);
            }
        }

        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);

        // h) Mostrar os valores das posições pares do vetor
        System.out.println("Valores das posições pares: ");
        for (int i = 0; i < vetor.size(); i++) {
            if (i % 2 == 0) {
                System.out.print("[ " + vetor.get(i) + " ]" + " ");
            }
        }

        // i) Mostrar os valores das posições ímpares do vetor
        System.out.println("\nValores das posições ímpares: ");
        for (int i = 0; i < vetor.size(); i++) {
            if (i % 2 != 0) {
                System.out.print("[ " + vetor.get(i) + " ]" + " ");
            }
        }

        // j) Mostrar os valores pares do vetor
        System.out.println("\nValores pares: ");
        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i) % 2 == 0) {
                System.out.print("[ " + vetor.get(i) + " ]" + " ");
            }
        }

        // k) Mostrar os valores ímpares do vetor
        System.out.println("\nValores ímpares: ");
        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i) % 2 != 0) {
                System.out.print("[ " + vetor.get(i) + " ]" + " ");
            }
        }

        // l) Verificar se há elementos repetidos no vetor e exibir uma mensagem em caso
        // afirmativo
        int repetido = 0;
        for (int i = 0; i < vetor.size(); i++) {
            for (int j = i + 1; j < vetor.size(); j++) {
                if (vetor.get(i) == vetor.get(j)) {
                    repetido++;
                }
            }
        }

        if (repetido > 0) {
            System.out.println("\nHá elementos " + repetido + " repetidos no vetor.");
        } else {
            System.out.println("\nNão há elementos repetidos no vetor.");
        }

        // m) Solicitar um valor ao usuário e verificar se esse valor existe no vetor.Se
        // existir exibir a posição em que ele está, senão exibir uma mensagem de valor
        // não encontrado

        System.out.println("Digite um valor: ");
        int valor = teclado.nextInt();
        boolean existe = false;
        for (int i = 0; i < vetor.size(); i++) {
            if (valor == vetor.get(i)) {
                System.out.println("O valor " + valor + " está na posição " + i);
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("O valor " + valor + " não existe no vetor");
        }

        // n) Verificar se o vetor está em ordem crescente, ou seja, se a[0] <= a[1] <=
        // a[2] <= ... para todos elementos do vetor
        boolean crescente = true;
        for (int i = 0; i < vetor.size() - 1; i++) {
            if (vetor.get(i) > vetor.get(i + 1)) {
                crescente = false;
                break;
            }
        }

        if (crescente == true) {
            System.out.println("O vetor está em ordem crescente");
        } else {
            System.out.println("O vetor não está em ordem crescente");
        }


        teclado.close();
    }

}
