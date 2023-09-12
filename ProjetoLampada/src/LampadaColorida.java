public class LampadaColorida extends Lampada{
    // atributos
    private String cor;
    // private String corAtual;
    // private String[] cores = {"vermelho", "verde", "azul", "amarelo", "roxo", "branco", "preto", "laranja", "rosa", "cinza"};

    // construtor
    // construtor padrao
    public LampadaColorida(String cor) {
        this.cor = cor;
    }

    // Construtor Inicialização (t, p)
    public LampadaColorida(int tensao, int potencia, String cor) {
        super(tensao, potencia);
        this.cor = cor;
    }
    
    // Construtor Inicialização (t, p, a)
    public LampadaColorida(int tensao, int potencia, boolean ligada, String cor) {
        super(tensao, potencia, ligada);
        this.cor = cor;
    }

    // Construtor
    public LampadaColorida(int tensao, int potencia, boolean ligada, boolean quebrada, boolean queimada, String cor) {
        super(tensao, potencia, ligada, quebrada, queimada);
        this.cor = cor;
    }

    // setter & getter
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // override
    // isso é um override - nao e muito recomendado
    public void setTensao(int tensao) {
        super.getTensao(); // chama o getter da classe pai
    }

    // metodos
    public void mudarCor(String cor) {
        this.cor = cor;
    }

    // mostrar cor c/ override
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Cor: " + this.cor);
    }
    

    
}
