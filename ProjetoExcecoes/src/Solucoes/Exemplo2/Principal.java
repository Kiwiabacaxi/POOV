package Solucoes.Exemplo2;

public class Principal {

    public static void main(String[] args) {
        int vetor[] = new int[10];
        try {
            vetor[15] = 10;
            System.out.println(vetor[15]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nussa, deu erro... tentando recuperar..." + e);
        }
        System.out.println("Continuação da execução.");
    }

}
