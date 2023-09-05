import java.security.InvalidParameterException;

public class Lampada {
    // Atributos
    private int tensao; // 110 220
    private int potencia; // 40 60 100 200
    private boolean ligada; // true false
    private boolean quebrada; // true false
    private boolean queimada; // true falseO

    // construtor padrao
    public Lampada() {
        System.out.println("Construtor padrão");
        this.tensao = 110;
        this.potencia = 40;
        this.ligada = false;
        this.quebrada = false;
        this.queimada = false;
    }

    // construtor Inicialização (t, p)
    public Lampada(int tensao, int potencia) {
        System.out.println("Construtor Inicialização (t, p)");
        this.tensao = tensao;
        this.potencia = potencia;
        this.ligada = false;
        this.quebrada = false;
        this.queimada = false;
    }

    // construtor Inicialização (t, p, a)
    public Lampada(int tensao, int potencia, boolean ligada) {
        System.out.println("Construtor Inicialização (tensao, potencia, ligada)");
        this.tensao = tensao;
        this.potencia = potencia;
        this.ligada = ligada;
        this.quebrada = false;
        this.queimada = false;
    }

    // construtor v4
    // public Lampada(int tensao, int potencia, boolean ligada, boolean quebrada,
    // boolean queimada) {
    // System.out.println("Construtor v4");

    // // usando os setters
    // setTensao(tensao);
    // setPotencia(potencia);
    // setLigada(ligada);
    // setQuebrada(quebrada);
    // setQueimada(queimada);

    // }

    // construtor v5 usando this
    public Lampada(int tensao, int potencia, boolean ligada, boolean quebrada, boolean queimada) {
        this(tensao, potencia, ligada);
        System.out.println("Construtor v5");
        this.quebrada = quebrada;
        this.queimada = queimada;
        

    }
    // setter & getter

    // tensao
    public void setTensao(int tensao) {
        if ((tensao == 110) || (tensao == 220)) {
            this.tensao = tensao;
        } else {
            // System.out.println("Tensão inválida");
            tensao = 220;
            throw new InvalidParameterException("Tensão inválida");
        }
    }

    public int getTensao() {
        return this.tensao;
    }

    // potencia
    public void setPotencia(int potencia) {
        if (potencia == 40 || potencia == 60 || potencia == 100 || potencia == 200) {
            this.potencia = potencia;
        } else {
            // System.out.println("Potência inválida");
            potencia = 40;
            throw new InvalidParameterException("Potência inválida");
        }
    }

    public int getPotencia() {
        return this.tensao;
    }

    // ligada
    public void setLigada(boolean ligada) {
        if (!queimada && !quebrada) {
            this.ligada = ligada;
        }

        else {
            if (quebrada && ligada) {
                System.out.println("Não é possível ligar uma lâmpada quebrada");
                queimada = true;
            }
            ligada = true;
        }
    }

    public boolean isLigada() {
        return ligada;
    }

    // quebrada
    public void setQuebrada(boolean quebrada) {
        if (quebrada && ligada) {
            queimada = true;
            ligada = false;
            System.out.println("Não é possível quebrar uma lâmpada ligada");
        }
        this.quebrada = quebrada;
    }

    public boolean isQuebrada() {
        return this.quebrada;
    }

    // queimada
    public void setQueimada(boolean queimada) {
        if (queimada && ligada) {
            queimada = true;
            ligada = false;
            System.out.println("Não é possível queimar uma lâmpada ligada");
        }
        this.queimada = queimada;

    }

    public boolean isQueimada() {
        return queimada;
    }

    // metodos

    // ligar
    public void ligar() {
        setLigada(true);
    }

    // apagar
    public void apagar() {
        setLigada(false);
    }

    public void quebrar() {
        setQuebrada(true);
    }

    public void queimar() {
        setQueimada(true);
    }

    public void mostrar() {
        String texto = "Tensão: " + tensao + "V\n" + "Potencia: " + potencia + "W\n"
                + "Esta ligada: "
                + ((ligada) ? "Ligada\n" : "Apagada\n")
                + "A lampada esta: " + ((quebrada) ? "Quebrada\n" : "Inteira\n")
                + "A lampada esta: " + ((queimada) ? "Queimada\n" : "Ligada\n");

        System.out.println(texto);
    }

}

/*
 * if (quebrada) {
 * texto += "Esta quebrada: " + ((quebrada) ? "Quebrada\n" : "Inteira\n");
 * }
 */

/*
 * public void mostrar() {
 * String texto = "Tensão: " + tensao + "V\n" + "Potencia: " + potencia + "W\n"
 * + "Esta ligada: "
 * + ((ligada) ? "Ligada\n" : "Apagada\n")
 * 
 * + "A lampada esta: " + ((quebrada) ? "Quebrada\n" : "Inteira\n")
 * + "A lampada esta: " + ((queimada) ? "Queimada\n" : "Ligada\n");
 * 
 * System.out.println(texto);
 * }
 */