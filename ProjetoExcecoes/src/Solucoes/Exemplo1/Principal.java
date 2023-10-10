package Solucoes.Exemplo1;

public class Principal {

    public static void main(String[] args) {
        double resultado;
        try {
            resultado = 10/0;
            System.out.println("" + resultado);
        }catch (ArithmeticException abacaxi) {
            System.out.println("Nussa, deu erro... tentando recuperar..." + abacaxi);
        }
        System.out.println("Continuação da execução.");
    }

}
