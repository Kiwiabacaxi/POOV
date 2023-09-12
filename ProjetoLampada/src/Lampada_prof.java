/* package poov;

public class Lampada {

    private int tensao; // 110, 220
    private int potencia;
    private boolean acesa;
    private boolean quebrada;
    private boolean queimada;

    // Construtor Padrao
    public Lampada() {
        this(220, 100);
        // System.out.println("Construtor padrao da Lampada executado");
        // tensao = 220;
        // potencia = 100;
        // acesa = false;
    }

    // Construtor de Inicializacao 1
    public Lampada(int tensao, int potencia) {
        this(tensao, potencia, false);
        // System.out.println("Construtor de Inicializacao 1 da Lampada executado");
        // setTensao(tensao);
        // setPotencia(potencia);
    }

    // Construtor de Inicializacao 2
    public Lampada(int tensao, int potencia, boolean acesa) {
        // System.out.println("Construtor de Inicializacao 2 da Lampada executado");
        setTensao(tensao);
        setPotencia(potencia);
        this.acesa = acesa;  //setAcesa(acesa);
    }

    //Construtor de copia
    public Lampada(Lampada lampada) {
        tensao = lampada.tensao;
        potencia = lampada.potencia;
        acesa = lampada.acesa;
        quebrada = lampada.quebrada;
        queimada = lampada.queimada;
    }

    public void setTensao(int tensao) {
        if ((tensao == 110) || (tensao == 220)) {
            this.tensao = tensao;
        } else {
            this.tensao = 220;
            throw new IllegalArgumentException("Valor inválido de tensao"); 
        }
    }

    public int getTensao() {
        return tensao;
    }

    public void setPotencia(int potencia) {
        if ((potencia == 60) || (potencia == 100) || (potencia == 150)) {
            this.potencia = potencia;
        } else {
            this.potencia = 60;
            throw new IllegalArgumentException("Valor inválido de potencia");
        }
    }

    public int getPotencia() {
        return potencia;
    }

    public void setAcesa(boolean acesa) {
        if (!queimada && !quebrada) {
            this.acesa = acesa;
        } else {
            if (quebrada && acesa) {
                queimada = true;
            }
            this.acesa = false;
        }
    }

    public boolean isAcesa() {
        return acesa;
    }

    public void setQuebrada(boolean quebrada) {
        if (quebrada && acesa) {
            queimada = true;
            acesa = false;
        }
        this.quebrada = quebrada;
    }

    public boolean isQuebrada() {
        return quebrada;
    }

    public void setQueimada(boolean queimada) {
        if (queimada && acesa) {
            acesa = false;
        }
        this.queimada = queimada;
    }

    public boolean isQueimada() {
        return queimada;
    }

    public void acender() {
        setAcesa(true);
    }

    public void apagar() {
        setAcesa(false);
    }

    public void quebrar() {
        setQuebrada(true);
    }

    public void queimar() {
        setQueimada(true);
    }

    // public void setLampada(int tensao, int potencia, boolean acesa) {

    // }

    public void mostrar() {
        String texto = tensao + "V, " + potencia + "W, " + ((acesa) ? "Acesa" : "Apagada")
                + ((queimada) ? ", Queimada" : "")
                + ((quebrada) ? ", Quebrada" : "");
        System.out.println(texto);
    }

    // @Override
    // public String toString() {
    //     String texto = tensao + "V, " + potencia + "W, " + ((acesa) ? "Acesa" : "Apagada")
    //             + ((queimada) ? ", Queimada" : "")
    //             + ((quebrada) ? ", Quebrada" : "");
    //     return texto;
    // }



    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tensao;
        result = prime * result + potencia;
        result = prime * result + (acesa ? 1231 : 1237);
        result = prime * result + (quebrada ? 1231 : 1237);
        result = prime * result + (queimada ? 1231 : 1237);
        return result;
    }

    @Override
    public String toString() {
        return "tensao: " + tensao + "\npotencia: " + potencia + "\nacesa: " + acesa + "\nquebrada: " + quebrada
                + "\nqueimada: " + queimada;
    }

    // @Override
    // public String toString() {
    //     return "Lampada [tensao=" + tensao + ", potencia=" + potencia + ", acesa=" + acesa + ", quebrada=" + quebrada
    //             + ", queimada=" + queimada + "]";
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lampada other = (Lampada) obj;
        if (tensao != other.tensao)
            return false;
        if (potencia != other.potencia)
            return false;
        if (acesa != other.acesa)
            return false;
        if (quebrada != other.quebrada)
            return false;
        if (queimada != other.queimada)
            return false;
        return true;
    }

    

} */