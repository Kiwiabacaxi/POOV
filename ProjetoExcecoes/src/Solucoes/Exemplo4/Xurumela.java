package Solucoes.Exemplo4;

public class Xurumela {

    private String cor;
    private double peso;

    public Xurumela() {
        cor = "sem cor";
        peso = 0.0;
    }

    public Xurumela(String cor, double peso) {
        this.cor = cor;
        this.peso = peso;
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
