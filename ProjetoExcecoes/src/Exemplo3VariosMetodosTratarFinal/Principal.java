package Exemplo3VariosMetodosTratarFinal;

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
        int x = 10, y = 0;
        try {
            int r = x / y;
        }catch(ArithmeticException e) {
            System.out.println("Erro! Faça alguma coisa útil!");
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("Inicio do programa principal");
        metodo1();
        System.out.println("Final do programa principal");
    }
}
