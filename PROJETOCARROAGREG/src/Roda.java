public class Roda {
    private int aro;
    private String modelo;
    private String marca;

    public Roda(int aro, String modelo, String marca) {
        this.aro = aro;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getAro() {
        return this.aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + aro;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
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
        Roda other = (Roda) obj;
        if (aro != other.aro)
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Roda [aro=%s, modelo=%s, marca=%s]", aro, modelo, marca);
    }

}
