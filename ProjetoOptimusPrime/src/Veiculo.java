/* 
1) Escreva uma classe Veiculo contendo peso em quilos (int), 
velocMax em km/h (int) e preco em Reais (double). 
Inclua um construtor sem argumentos que inicialize os dados com valores padrão 
(escolha os valores) e um construtor que inicialize os dados com os valores recebidos como argumento. A
crescente um método para setar os dados e um método toString que retorne os dados do Veiculo em uma string.
*/

public class Veiculo {

    private int peso;
    private int velocMax;
    private double preco;

    public Veiculo() {
        this.peso = 1000;
        this.velocMax = 200;
        this.preco = 10000.00;
    }

    public Veiculo(int peso, int velocMax, double preco) {
        this.peso = peso;
        this.velocMax = velocMax;
        this.preco = preco;
    }

    public void setDados(int peso, int velocMax, double preco) {
        this.peso = peso;
        this.velocMax = velocMax;
        this.preco = preco;
    }

    public String toString() {
        return "Peso: " + this.peso + " kg\nVelocidade Máxima: " + this.velocMax + " km/h\nPreço: R$ " + this.preco;
    }
    
}
