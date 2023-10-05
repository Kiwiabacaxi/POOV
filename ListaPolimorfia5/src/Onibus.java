// 1) Crie a classe abstrata Onibus

public abstract class Onibus {
    private int ID;
    private int capacidade;
    private double custo;
    private static int nextID = 1;

    public Onibus(int capacidade, double custo) {
        ID = nextID++;
        this.capacidade = capacidade;
        this.custo = custo;
    }

    public abstract double getAceleracao();

    public final int getID() {
        return ID;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getCusto() {
        return custo;
    }
}