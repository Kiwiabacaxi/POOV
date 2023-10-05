// f) Crie uma classe OnibusEletrico que implementa Eletrico
// – Use extends, implements adequadamente
// – Atributo tensao
// – Crie um construtor
// – Implemente os métodos necessários
// 	• getAceleracao() returna 5.0

public class OnibusEletrico extends Onibus implements Eletrico {
    private double tensao;

    public OnibusEletrico(int capacidade, double custo, double tensao) {
        super(capacidade, custo);
        this.tensao = tensao;
    }

    @Override
    public double getAceleracao() {
        return 5.0;
    }

    @Override
    public double getTensao() {
        return tensao;
    }

    public void setTensao(double tensao) {
        this.tensao = tensao;
    }
}