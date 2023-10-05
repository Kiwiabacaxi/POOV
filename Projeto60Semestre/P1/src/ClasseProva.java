// classe basica para prova de POOV = Programacao Orientada a Objetos e Visual

import java.util.Arrays;

public class ClasseProva {
    // atributos
    private int numeroInteiroPositivo;
    private String nome;
    private double numeroDouble;
    private boolean booleano;
    private int[] vetorInteiros;

    // construtor
    public ClasseProva() {
        this.numeroInteiroPositivo = 0;
        this.nome = "";
        this.numeroDouble = 0.0;
        this.booleano = false;
        this.vetorInteiros = new int[10];
    }

    public ClasseProva(int numeroInteiro, String nome, double numeroDouble, boolean booleano, int[] vetorInteiros) {
        this.numeroInteiroPositivo = numeroInteiro;
        this.nome = nome;
        this.numeroDouble = numeroDouble;
        this.booleano = booleano;
        this.vetorInteiros = vetorInteiros;
    }

    // setters e getters

    // numeroInteiro
    public int getNumeroInteiroPositivo() {
        return numeroInteiroPositivo;
    }

    public void setNumeroInteiroPositivo(int numeroInteiroPositivo) {
        if (numeroInteiroPositivo > 0) {
            this.numeroInteiroPositivo = numeroInteiroPositivo;
        } else {
            throw new IllegalArgumentException("Numero inteiro positivo invalido");
        }
    }

    // nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("Nome invalido");
        }
    }

    // numeroDouble
    public double getNumeroDouble() {
        return numeroDouble;
    }

    public void setNumeroDouble(double numeroDouble) {
        this.numeroDouble = numeroDouble;
    }

    // booleano - isBooleano por convencao
    public boolean isBooleano() {
        return booleano;
    }

    public void setBooleano(boolean booleano) {
        this.booleano = booleano;
    }

    // vetorInteiros
    public int[] getVetorInteiros() {
        return vetorInteiros;
    }

    public void setVetorInteiros(int[] vetorInteiros) {
        this.vetorInteiros = vetorInteiros;
    }

    // metodos
    // toString
    public String toString() {
        return "numeroInteiroPositivo: " + this.numeroInteiroPositivo + "\n" +
                "nome: " + this.nome + "\n" +
                "numeroDouble: " + this.numeroDouble + "\n" +
                "booleano: " + this.booleano + "\n" +
                "vetorInteiros: " + Arrays.toString(this.vetorInteiros);
    }

    /*
     * // versao bomba patch
     * 
     * @Override
     * public String toString() {
     * return String.format(
     * "ClasseProva [numeroInteiroPositivo=%s, nome=%s, numeroDouble=%s, booleano=%s, vetorInteiros=%s]"
     * ,
     * numeroInteiroPositivo, nome, numeroDouble, booleano,
     * Arrays.toString(vetorInteiros));
     * }
     */

    // equals
    public boolean equals(ClasseProva outraClasseProva) {
        if (this.numeroInteiroPositivo == outraClasseProva.numeroInteiroPositivo &&
                this.nome.equals(outraClasseProva.nome) &&
                this.numeroDouble == outraClasseProva.numeroDouble &&
                this.booleano == outraClasseProva.booleano &&
                Arrays.equals(this.vetorInteiros, outraClasseProva.vetorInteiros)) {
            return true;
        } else {
            return false;
        }
    }

    // clone
    public ClasseProva clone() {
        ClasseProva clone = new ClasseProva();
        clone.numeroInteiroPositivo = this.numeroInteiroPositivo;
        clone.nome = this.nome;
        clone.numeroDouble = this.numeroDouble;
        clone.booleano = this.booleano;
        clone.vetorInteiros = this.vetorInteiros.clone();
        return clone;
    }

    // metodo para testar a classe
    public static void main(String[] args) {
        // criando um objeto da classe
        ClasseProva objeto1 = new ClasseProva();
        System.out.println(objeto1.toString());

        // alterando os atributos
        objeto1.setNumeroInteiroPositivo(10);
        objeto1.setNome("nome");
        objeto1.setNumeroDouble(10.0);
        objeto1.setBooleano(true);
        objeto1.setVetorInteiros(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });

        // imprimindo o objeto
        System.out.println(objeto1.toString());

        // criando um segundo objeto da classe
        ClasseProva objeto2 = new ClasseProva(10, "nome", 10.0, true, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });

        // imprimindo o objeto
        System.out.println(objeto2.toString());

        // testando o equals
        System.out.println(objeto1.equals(objeto2));

        // testando o clone
        ClasseProva objeto3 = objeto1.clone();
        System.out.println(objeto3.toString());
    }

    // fim da classe

}
