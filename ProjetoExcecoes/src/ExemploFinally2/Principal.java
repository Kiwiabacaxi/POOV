package ExemploFinally2;

public class Principal {

    public static int funcao1() {
        System.out.println("Faz alguma coisa 1");
        return 10;
//        System.out.println("Isso nao executa");
    }

    public static int funcao2() {
        try {
            System.out.println("Faz alguma coisa 2");
            return 20;
        } finally {
            System.out.println("Isso executa!");
        }
    }

    public static void main(String[] args) {
        System.out.println(funcao1());
        System.out.println(funcao2());
    }
}
