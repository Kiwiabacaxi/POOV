package ExemploMinhasExcecoes2;

public class Principal {

    public static void funcao1() throws ExcecaoCatastrofica {
        throw new ExcecaoCatastrofica("CATASTROFE!");
    }

    public static void funcao2() throws ExcecaoArmagedon {
        throw new ExcecaoArmagedon("ARMAGEDON!");
    }

    public static void funcao3() throws ExcecaoDanou_se {
        throw new ExcecaoDanou_se("DANOU-SE!");
    }

    public static void funcao4() throws ExcecaoJaEra {
        throw new ExcecaoJaEra("JA ERA!");
    }

    public static void main(String[] args) {
        try {
            funcao1();
        } catch (ExcecaoCatastrofica e) {
            System.out.println("Ocorreu uma excecao catastrofica..." + e);
        }

        try {
            funcao2();
        } catch (ExcecaoArmagedon e) {
            System.out.println("Ocorreu uma excecao armagedon..." + e);
        }

        try {
            funcao3();
        } catch (ExcecaoDanou_se e) {
            System.out.println("Ocorreu uma excecao danou-se..." + e);
        }

        try {
            funcao4();
        } catch (ExcecaoJaEra e) {
            System.out.println("Ocorreu uma excecao ja era..." + e);
        }

        try {
            funcao3();
        } catch (ExcecaoCatastrofica e) {
            System.out.println("Ocorreu uma excecao catastrofica..." + e);
        }

        try {
            funcao4();
        } catch (ExcecaoArmagedon e) {
            System.out.println("Ocorreu uma excecao armagedon..." + e);
        }

        try {
            funcao1();
        } catch (ExcecaoDoGodoi e) {
            System.out.println(e);
        }

    }
}
