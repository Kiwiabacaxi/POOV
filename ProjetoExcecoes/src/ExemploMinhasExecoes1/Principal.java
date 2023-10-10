package ExemploMinhasExecoes1;

public class Principal {

    public static void funcao1() {
        try {
            throw new MinhaExcecao("Ocorreu um problema inesperado 1...");
        } catch (MinhaExcecao e) {
            System.out.println(e);
        }
    }

    public static void funcao2() throws MinhaExcecao {
        throw new MinhaExcecao("Ocorreu um problema inesperado 2...");
    }

    public static void funcao3() throws MinhaExcecao {
        funcao2();
    }

    public static void main(String[] args) {
        funcao1();
        try {
            funcao2();
        } catch (MinhaExcecao ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }

        try {
            funcao3();
        } catch (MinhaExcecao ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

}
