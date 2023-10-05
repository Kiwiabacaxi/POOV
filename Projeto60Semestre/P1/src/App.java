import java.util.Scanner;

public class App {
    /*
     * public static void main(String[] args) throws Exception {
     * System.out.println("Hello, World!");
     * }
     */

    // testar classeprova
    public static void main(String[] args) {
        // criando um objeto da classe
        ClasseProva objeto1 = new ClasseProva();
        System.out.println(objeto1.toString());

        // criando um objeto da classe
        ClasseProva objeto2 = new ClasseProva(10, "nome", 10.0, true, new int[] { 1, 2, 3 });
        System.out.println(objeto2.toString());

        // criando um objeto da classe
        ClasseProva objeto3 = new ClasseProva(10, "nome", 10.0, true, new int[] { 1, 2, 3 });
        System.out.println(objeto3.toString());

        // testando equals
        System.out.println(objeto2.equals(objeto3));

        // testando clone
        ClasseProva objeto4 = objeto2.clone();
        System.out.println(objeto4.toString());

        // testando com input do usuario
        ClasseProva objeto5 = new ClasseProva();
        // scanner
        Scanner teclado = new Scanner(System.in);
        // numeroInteiroPositivo
        System.out.println("Digite um numero inteiro positivo: ");
        objeto5.setNumeroInteiroPositivo(teclado.nextInt());
        // nome
        System.out.println("Digite um nome: ");
        objeto5.setNome(teclado.next());
        // numeroDouble
        System.out.println("Digite um numero double: ");
        objeto5.setNumeroDouble(teclado.nextDouble());
        // booleano
        System.out.println("Digite um booleano: ");
        objeto5.setBooleano(teclado.nextBoolean());
        // vetorInteiros
        System.out.println("Digite um vetor de inteiros: ");
        int[] vetorInteiros = new int[3];
        for (int i = 0; i < vetorInteiros.length; i++) {
            vetorInteiros[i] = teclado.nextInt();
        }
        objeto5.setVetorInteiros(vetorInteiros);
        // fechar scanner
        teclado.close();
        // imprimir objeto
        System.out.println(objeto5.toString());

    }
}
