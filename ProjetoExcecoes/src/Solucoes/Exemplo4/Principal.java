package Solucoes.Exemplo4;

public class Principal {

    public static void main(String[] args) {
        Xurumela x = null;
        try {
            x.setCor("Azul");
        } catch (NullPointerException e) {
            System.out.println("Nussa, deu erro... tentando recuperar..." + e);
        }
        System.out.println("Continuação da execução.");
    }

}
