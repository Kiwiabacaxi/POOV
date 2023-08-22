public class Lampada {
    // Atributos
    public int tensao; // 110 220
    public int potencia; // 40 60 100 200
    public boolean ligada; // true false
    public boolean quebrada; // true false
    public boolean queimada; // true falseO

    public void mostrar() {
        String texto = "Tensão: " + tensao + "V\n" + "Potencia: " + potencia + "W\n" + "Esta ligada: " +((ligada) ? "Ligada\n" : "Apagada\n")
                + ((quebrada) ? "Quebrada\n" : "Inteira\n")
                + ((queimada) ? "Queimada\n" : "Inteira\n");

        System.out.println(texto);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
