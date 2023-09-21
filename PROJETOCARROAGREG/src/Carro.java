import java.util.ArrayList;

public class Carro {
    private int ano;
    private String modelo;
    private String cor;
    private ArrayList<Porta> portas;
    private ArrayList<Roda> rodas;
    private Motor motor;
    private Chassi chassi;

    // construtor padrão
    

    public Carro(int ano, String modelo, String cor, ArrayList<Porta> portas, ArrayList<Roda> rodas, Motor motor,
            Chassi chassi) {
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
        this.portas = portas;
        this.rodas = rodas;
        this.motor = motor;
        this.chassi = chassi;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ArrayList<Porta> getPortas() {
        return this.portas;
    }

    public void setPortas(ArrayList<Porta> portas) {
        this.portas = portas;
    }

    public ArrayList<Roda> getRodas() {
        return this.rodas;
    }

    public void setRodas(ArrayList<Roda> rodas) {
        this.rodas = rodas;
    }

    public Motor getMotor() {
        return this.motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Chassi getChassi() {
        return this.chassi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ano;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        result = prime * result + ((portas == null) ? 0 : portas.hashCode());
        result = prime * result + ((rodas == null) ? 0 : rodas.hashCode());
        result = prime * result + ((motor == null) ? 0 : motor.hashCode());
        result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
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
        Carro other = (Carro) obj;
        if (ano != other.ano)
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        if (portas == null) {
            if (other.portas != null)
                return false;
        } else if (!portas.equals(other.portas))
            return false;
        if (rodas == null) {
            if (other.rodas != null)
                return false;
        } else if (!rodas.equals(other.rodas))
            return false;
        if (motor == null) {
            if (other.motor != null)
                return false;
        } else if (!motor.equals(other.motor))
            return false;
        if (chassi == null) {
            if (other.chassi != null)
                return false;
        } else if (!chassi.equals(other.chassi))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Carro [ano=%s, modelo=%s, cor=%s, portas=%s, rodas=%s, motor=%s, chassi=%s]", ano, modelo,
                cor, portas, rodas, motor, chassi);
    }

    
}