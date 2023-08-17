import java.util.Scanner;

public class ArrayExercicios {
    public static void main(String[] args) throws Exception {

        // a) Criar um vetor de tamanho 20 de inteiros
        int[] vetor = new int[20];

        // b) Preencher os 10 primeiros valores do vetor com números digitados pelo
        // usuário via teclado
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            // System.out.println("Digite um número: ");
            // vetor[i] = teclado.nextInt();
            vetor[i] = (int) (Math.random() * 100) + 1;

        }

        // c) Preencher os 10 últimos valores do vetor com números aleatórios entre 1 e
        // 100
        for (int i = 10; i < 20; i++) {
            vetor[i] = (int) (Math.random() * 100) + 1;
        }

        // d) Mostrar o vetor inteiro na tela
        System.out.println("Vetor completo: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[ " + vetor[i] + " ]" + " ");
        }

        // com for diferente
        // for(int valor : vetor){
        // System.out.print("[ " + valor + " ]" + " ");
        // }

        System.out.println();

        // e) Mostrar o vetor de trás para frente na tela
        System.out.println("Vetor de trás para frente: ");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.print("[ " + vetor[i] + " ]" + " ");
        }

        System.out.println();
        // f) Calcular e mostrar a média dos valores do vetor
        double soma = 0;
        System.out.print("Média dos valores do vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        System.out.println(soma / vetor.length);

        // g) Encontrar e mostrar o maior valor e o menor valor do vetor
        int maior = vetor[0];
        int menor = vetor[0];
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        System.out.println("Maior valor do vetor: " + maior);
        System.out.println("Menor valor do vetor: " + menor);
        System.out.println();

        // h) Mostrar os valores das posições pares do vetor
        System.out.println("Valores das posições pares do vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            if (i % 2 == 0) {
                System.out.print("[ " + vetor[i] + " ]" + " ");
            }
        }
        System.out.println();

        // i) Mostrar os valores das posições ímpares do vetor
        System.out.println("Valores das posições pares do vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            if (i % 2 != 0) {
                System.out.print("[ " + vetor[i] + " ]" + " ");
            }

        }
        System.out.println();

        // j) Mostrar os valores pares do vetor
        System.out.println("Valores pares do vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                System.out.print("[ " + vetor[i] + " ]" + " ");
            }
        }

        System.out.println();
        // k) Mostrar os valores ímpares do vetor
        System.out.println("Valores ímpares do vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                System.out.print("[ " + vetor[i] + " ]" + " ");
            }
        }
        System.out.println();

        // l) Verificar se há elementos repetidos no vetor e exibir uma mensagem em caso
        // afirmativo
        boolean repetido = false;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] == vetor[j]) {
                    repetido = true;
                    break;
                }
            }
        }
        if (repetido) {
            System.out.println("Há elementos repetidos no vetor");
        } else {
            System.out.println("Não há elementos repetidos no vetor");
        }

        // m) Solicitar um valor ao usuário e verificar se esse valor existe no vetor.Se
        // existir exibir a posição em que ele está, senão exibir uma mensagem de valor
        // não encontrado
        System.out.println("Digite um valor: ");
        int valor = teclado.nextInt();
        boolean existe = false;
        for (int i = 0; i < vetor.length; i++) {
            if (valor == vetor[i]) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("O valor " + valor + " existe no vetor");
        } else {
            System.out.println("O valor " + valor + " não existe no vetor");
        }

        // n) Verificar se o vetor está em ordem crescente, ou seja, se a[0] <= a[1] <=
        // a[2] <= ... para todos elementos do vetor
        System.out.println("Verificar se o vetor está em ordem crescente: ");
        boolean crescente = true;
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                crescente = false;
                break;
            }
        }
        if (crescente) {
            System.out.println("O vetor está em ordem crescente");
        } else {
            System.out.println("O vetor não está em ordem crescente");
        }

        teclado.close(); // fechar o teclado
    }

}