public class Motor {
    private int potencia;
    private int tipoCombustivel; // 0 - Gasolina, 1 - Alcool, 2 - Flex
    private String modelo;

    public Motor(int potencia, int tipoCombustivel, String modelo) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
        this.modelo = modelo;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getTipoCombustivel() {
        return this.tipoCombustivel;
    }

    public void setTipoCombustivel(int tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getTipoCombustivelString() {
        switch (this.tipoCombustivel) {
            case 0:
                return "Gasolina";
            case 1:
                return "Alcool";
            case 2:
                return "Flex";
            default:
                return "Tipo de combustível inválido";
        }
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + potencia;
        result = prime * result + tipoCombustivel;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Motor other = (Motor) obj;
        if (potencia != other.potencia)
            return false;
        if (tipoCombustivel != other.tipoCombustivel)
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Motor [potencia=%s, tipoCombustivel=%s, modelo=%s]", potencia, tipoCombustivel, modelo);
    }


    

}
