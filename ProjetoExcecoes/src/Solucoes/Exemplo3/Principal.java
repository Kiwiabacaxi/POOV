package Solucoes.Exemplo3;

public class Principal {

    public static void main(String[] args) {
        String nome = "Rafael";
        try {
            System.out.println(nome.charAt(15));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Nussa, deu erro... tentando recuperar..." + e);
            //e.printStackTrace();
        }
        System.out.println("Continuação da execução.");
    }
}
