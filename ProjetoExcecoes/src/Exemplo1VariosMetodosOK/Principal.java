package Exemplo1VariosMetodosOK;

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
    }
    
    
    public static void main(String[] args) {
        System.out.println("Inicio do programa principal");
        metodo1();
        System.out.println("Final do programa principal");
    }
}
