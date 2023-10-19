package poov.models;

import poov.tests.Situacao;

public class Vacina {
    private Long codigo;
    private String nome;
    private String descricao;
    private Situacao situacao;

    // Crie três construtores, um padrão, um de inicialização que só não recebe o
    // código e um de inicialização que recebe tudo
    public Vacina() {
    }

    public Vacina(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Vacina(Long codigo, String nome, String descricao, Situacao situacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.situacao = situacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
        Vacina other = (Vacina) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (situacao != other.situacao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vacina [codigo=");
        builder.append(codigo);
        builder.append(", nome=");
        builder.append(nome);
        builder.append(", descricao=");
        builder.append(descricao);
        builder.append(", situacao=");
        builder.append(situacao);
        builder.append("]");
        return builder.toString();
    }

}
