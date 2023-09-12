

public class automovel {
    // enum para combustivel
    public enum combustivel {
        GASOLINA("Gasolina"), ALCOOL("Alcool"), DIESEL("Diesel"), GAS("Gas");
        private String descricao;

        private combustivel(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    // Atributos
    private String cor;
    private String modelo;
    private combustivel combustivel;

    
    // Construtor
    public automovel(String cor, String modelo, automovel.combustivel combustivel) {
        this.cor = cor;
        this.modelo = modelo;
        this.combustivel = combustivel;
    }
    
    // Getters e Setters
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor.length() > 0)
            this.cor = cor;
        else
            throw new IllegalArgumentException("Cor precisa ser preenchida");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo.length() > 0)
            this.modelo = modelo;
        else
            throw new IllegalArgumentException("Modelo precisa ser preenchido");
    }

    public combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(combustivel combustivel) {
        this.combustivel = combustivel;
    }

    // metodos

    public double getPreco() {
        switch (combustivel) {
            case GASOLINA:
                return 20000.0;
            case ALCOOL:
                return 17000.0;
            case DIESEL:
                return 25000.0;
            case GAS:
                return 30000.0;
            default:
                return 0.0;
        }
    }

    // valor do automovel
    public double valorAutomovel() {
        return this.getPreco();
    }

    // toString
    public String toString() {
        return "Cor: " + this.cor + "\nModelo: " + this.modelo + "\nCombustível: " + 
        this.combustivel.getDescricao() + "\nPreço: R$ " + this.getPreco();
    }
    
    

    
}
