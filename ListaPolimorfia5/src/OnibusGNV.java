// d) Crie a classe OnibusGNV (gás natural veicular)
// – Faça a herança e implemente as interfaces corretas
// – Atributos: alcance, nivelEmissao (mais os herdados)
// – Crie um construtor
// – Implemente os métodos abstratos herdados; getAceleracao() retorna 3.0

public class OnibusGNV extends Onibus implements CombustivelLiquido {
    private double alcance;
    private int nivelEmissao;

    public OnibusGNV(int capacidade, double custo, double alcance, int nivelEmissao) {
        super(capacidade, custo);
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
    public double getAceleracao() {
        return 3.0;
    }
}