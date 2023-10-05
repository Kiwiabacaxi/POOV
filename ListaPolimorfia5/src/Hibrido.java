// c) Crie a classe Hibrido
// – extends Onibus implements CombustivelLiquido, Eletrico
// – Atributos tensao, alcance, nivelEmissao (mais os herdados)
// – Crie um construtor
// – Crie getAlcance(), getNivelEmissao(), getTensao(), getAceleracao()
// 	• getAceleracao() sempre retorna 4.0

public class Hibrido extends Onibus implements CombustivelLiquido, Eletrico {
    private double tensao;
    private double alcance;
    private int nivelEmissao;

    public Hibrido(int capacidade, double custo, double tensao, double alcance, int nivelEmissao) {
        super(capacidade, custo);
        this.tensao = tensao;
        this.alcance = alcance;
        this.nivelEmissao = nivelEmissao;
    }

    @Override
    public double getAlcance() {
        return alcance;
    }

    @Override
    public int getNivelEmissao() {
        return nivelEmissao;
    }

    @Override
    public double getTensao() {
        return tensao;
    }

    @Override
    public double getAceleracao() {
        return 4.0;
    }
}