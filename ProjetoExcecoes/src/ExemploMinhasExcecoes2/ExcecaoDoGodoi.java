package ExemploMinhasExcecoes2;

public abstract class ExcecaoDoGodoi extends Exception{

    public ExcecaoDoGodoi() {
    }

    public ExcecaoDoGodoi(String menssagem) {
        super(menssagem);
    }
}
