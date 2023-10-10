package Solucoes.Exemplo5;

import Problemas.Exemplo4.Xurumela;

public class Principal {

    public static void main(String[] args) {
        Xurumela x = new Xurumela("Verde", 1.0);
        int valor;
        try {
            valor = Integer.parseInt(x.toString());
        } catch (NumberFormatException e) {
            System.out.println("Nussa, deu erro... tentando recuperar..." + e);
        }
        System.out.println("Continuação da execução.");
    }

}
