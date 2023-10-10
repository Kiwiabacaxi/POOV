package Exemplo2VariosMetodosExcecao;

public class Principal {

    public static void metodo1() {
        System.out.println("Dentro do método 1");
        metodo2();
    }

    public static void metodo2() {
        System.out.println("Dentro do método 2");
        metodo3();
    }

    public static void metodo3() {
        System.out.println("Dentro do método 3");

        int x = 10, y = 0; // original era por 0 para mostrar o stack trace
        int r = x / y;
        metodo4(); // recursao pra estourar o stack trace

    }

    public static void metodo4() {
        System.out.println("Dentro do método 4");
        // metodo1();
    }

    public static void main(String[] args) {
        System.out.println("Inicio do programa principal");
        metodo1();
        System.out.println("Final do programa principal");
    }

}
