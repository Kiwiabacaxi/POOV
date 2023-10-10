package ExemploExcecoesVerificadas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Principal {

    public static void lerArquivo1 (String nome) {
        try {
            FileInputStream f = new FileInputStream(nome);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
    }

    public static void lerArquivo2 (String nome) throws FileNotFoundException {
        FileInputStream f = new FileInputStream(nome);
    }

    public static void main(String[] args) {
        lerArquivo1("teste.txt");
        try {
            lerArquivo2("teste.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

}
