public class App {
    public static void main(String[] args) {
        // chamar a classe Lampada
        Lampada lampada = new Lampada();

        /*
         * // como os atributos são privados, não é possível acessá-los diretamente
         * lampada.tensao = 9999999;
         * lampada.potencia = 69;
         * lampada.ligada = true;
         * lampada.quebrada = false;
         * lampada.queimada = false;
         */

        lampada.mostrar();

        /*
         * // chamar a classe Lampada com construtor Inicialização (t, p)
         * Lampada lampada2 = new Lampada(220, 60);
         * lampada2.mostrar();
         * 
         * // chamar a classe Lampada com construtor Inicialização (t, p, a)
         * Lampada lampada3 = new Lampada(220, 60, true);
         * lampada3.mostrar();
         */

        // chamar a classe Lampada com o construtor Inicialização (tensao, potencia,
        // ligada)
        Lampada lampada4 = new Lampada(0, 0, false);
        lampada4.mostrar();

        // chamar a classe Lampada com o construtor v4
        Lampada lampada5 = new Lampada(220, 60, true, false, true);
        lampada5.mostrar();

    }

}
