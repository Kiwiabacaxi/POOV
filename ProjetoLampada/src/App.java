public class App {
    public static void main(String[] args) {
        // chamar a classe Lampada
        Lampada lampada = new Lampada();
        lampada.tensao = 220;
        lampada.potencia = 60;
        lampada.ligada = true;
        lampada.quebrada = false;
        lampada.queimada = false;

        lampada.mostrar();

    }
    
}
