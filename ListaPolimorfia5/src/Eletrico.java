// b) Crie a interface Eletrico
// - Assinatura de método double getTensao()
// - Defina as constantes ALTA_VOLTAGEM=600, BAIXA_VOLTAGEM=480, ambas double

public interface Eletrico {
    double getTensao();

    final double ALTA_VOLTAGEM = 600;
    static final double BAIXA_VOLTAGEM = 480;

}

