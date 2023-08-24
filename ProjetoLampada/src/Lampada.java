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
    public Lampada(int t, int p) {
        System.out.println("Construtor Inicialização (t, p)");
        this.tensao = t;
        this.potencia = p;
        this.ligada = false;
        this.quebrada = false;
        this.queimada = false;
    }

    // construtor Inicialização (t, p, a)
    public Lampada(int t, int p, boolean a) {
        System.out.println("Construtor Inicialização (t, p, a)");
        this.tensao = t;
        this.potencia = p;
        this.ligada = a;
        this.quebrada = false;
        this.queimada = false;
    }

    public void mostrar() {
        String texto = "Tensão: " + tensao + "V\n" + "Potencia: " + potencia + "W\n" + "Esta ligada: "
                + ((ligada) ? "Ligada\n" : "Apagada\n")
                + "A lampada esta: " + ((quebrada) ? "Quebrada\n" : "Inteira\n")
                + "A lampada esta: " + ((queimada) ? "Queimada\n" : "Inteira\n");

        System.out.println(texto);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
