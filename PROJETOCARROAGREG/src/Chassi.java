public class Chassi {
    private String numeracao;
    private String material;

    public Chassi(String numeracao, String material) {
        this.numeracao = numeracao;
        this.material = material;
    }

    public String getNumeracao() {
        return this.numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeracao == null) ? 0 : numeracao.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
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
        Chassi other = (Chassi) obj;
        if (numeracao == null) {
            if (other.numeracao != null)
                return false;
        } else if (!numeracao.equals(other.numeracao))
            return false;
        if (material == null) {
            if (other.material != null)
                return false;
        } else if (!material.equals(other.material))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Chassi [numeracao=%s, material=%s]", numeracao, material);
    }

}
