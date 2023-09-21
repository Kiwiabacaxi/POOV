import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Produto {
    // atributos
    private long codigo;
    private String nome;
    private String descricao;
    private BigDecimal precoCompra;
    private LocalDate dataCompra;
    private LocalDate dataValidade;
    private int situacao;
    private String marca;
    private int quantidadeMinima;
    private int quantidadeAtual;

    // construtor padrao
    public Produto() {
    }

    public Produto(long codigo, String nome, String descricao,
            BigDecimal precoCompra, LocalDate dataCompra, LocalDate dataValidade, int situacao, String marca,
            int quantidadeMinima, int quantidadeAtual) {
        setCodigo(codigo);
        setDescricao(descricao);
        setNome(nome);
        setdataCompra(dataCompra);
        setdataValidade(dataValidade);
        setmarca(marca);
        setprecoCompra(precoCompra);
        setquantidadeAtual(quantidadeAtual);
        setquantidadeMinima(quantidadeMinima);
        setsituacao(situacao);
    }

    // SETTER E GETTERS

    // codigo
    public void setCodigo(long codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("O codigo deve ser maior que zero");
        }
    }

    public long getCodigo() {
        return codigo;
    }

    // nome
    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Escreve alguma coisa, por favor <3");
        }
    }

    public String getNome() {
        return nome;
    }

    // descricao
    public void setDescricao(String descricao) {
        if (descricao.length() > 0) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("Escreve alguma coisa, por favor <3");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    // precoCompra
    public void setprecoCompra(BigDecimal precoCompra) {
        if (precoCompra.compareTo(BigDecimal.ZERO) > 0) { // ou precoCompra == 1
            this.precoCompra = precoCompra;
        } else {
            throw new IllegalArgumentException("O preco de compra deve ser maior que zero");
        }

    }

    public BigDecimal getprecoCompra(BigDecimal precoCompra) {
        return precoCompra;
    }

    // dataCompra
    public void setdataCompra(LocalDate dataCompra) {
        if (!dataCompra.isBefore(LocalDate.now())) {
            this.dataCompra = dataCompra;
        } else {
            throw new IllegalArgumentException("A data de compra deve ser anterior a data atual");
        }
    }

    public LocalDate getdataCompra(LocalDate dataCompra) {
        return dataCompra;
    }

    // dataValidade
    public void setdataValidade(LocalDate dataValidade) {
        if (!dataValidade.isBefore(LocalDate.now())) {
            this.dataValidade = dataValidade;
        } else {
            throw new IllegalArgumentException("A data de validade deve ser anterior a data atual");
        }
    }

    public LocalDate getdataValidade(LocalDate dataValidade) {
        return dataValidade;
    }

    // situacao - ? que isso
    public void setsituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getsituacao(int situacao) {
        return situacao;
    }

    // marca
    public void setmarca(String marca) {
        if (marca.length() > 0) {
            this.marca = marca;
        } else {
            throw new IllegalArgumentException("Escreve alguma coisa, por favor <3");
        }
    }

    public String getmarca(String marca) {
        return marca;
    }

    // quantidadeMinima
    public void setquantidadeMinima(int quantidadeMinima) {
        if (quantidadeMinima >= 0) {
            this.quantidadeMinima = quantidadeMinima;
        } else {
            throw new IllegalArgumentException("A quantidade minima deve ser maior que zero");
        }
    }

    public int getquantidadeMinima(int quantidadeMinima) {
        return quantidadeMinima;
    }

    // quantidadeAtual
    public void setquantidadeAtual(int quantidadeAtual) {
        if (quantidadeAtual > 0) {
            this.quantidadeAtual = quantidadeAtual;
        } else {
            throw new IllegalArgumentException("A quantidade atual deve ser maior que zero");
        }

    }

    public int getquantidadeAtual(int quantidadeAtual) {
        return quantidadeAtual;
    }

    // metodos

    // isEmFalta
    public boolean isEmFalta() {
        if (quantidadeAtual < quantidadeMinima) {
            return true;
        } else {
            return false;
        }
    }

    // isVencido
    public boolean isVencido() {
        if (dataValidade.isBefore(LocalDate.now()))
            return true;
        return false;

    }

    // quando ele e estatico ele nao precisa ser instanciado
        // public static Produto obterProduto() {
    public Produto obterProduto() {
        // iniciar o teclado
        Scanner teclado = new Scanner(System.in);

        // instanciar um novo produto
        // Produto produto = new Produto(codigo, nome, descricao, precoCompra,
        // dataCompra, dataValidade, situacao, marca, quantidadeMinima, quantidadeAtual)
        Produto produto = new Produto();

        // codigo
        System.out.print("Digite o codigo do produto: ");
        setCodigo(codigo = Long.parseLong(teclado.nextLine()));

        // nome
        System.out.print("Digite o nome do produto: ");
        setNome(nome = teclado.nextLine());

        // descricao
        System.out.print("Digite a descricao do produto: ");
        setDescricao(descricao = teclado.nextLine());

        // precoCompra
        System.out.print("Digite o preco de compra do produto: ");
        setprecoCompra(precoCompra = new BigDecimal(teclado.nextLine()));

        // dataCompra
        // System.out.println("Digite a data de compra do produto: ");
        LocalDate dataCompra = LocalDate.now();
        setdataCompra(dataCompra);

        // dataValidade
        System.out.print("Digite a data de validade do produto: ");
        // digitar a data no formato dd/MM/yyyy
        // converter a string para LocalDate
        String textoData = teclado.nextLine();
        LocalDate dataValidade = LocalDate.parse(textoData, formatador);
        setdataValidade(dataValidade);

        // situacao
        System.out.print("Digite a situacao do produto: ");
        setsituacao(situacao = Integer.parseInt(teclado.nextLine()));

        // marca
        System.out.print("Digite a marca do produto: ");
        setmarca(textoData = teclado.nextLine());

        // quantidadeMinima
        System.out.print("Digite a quantidade minima do produto: ");
        setquantidadeMinima(quantidadeMinima = Integer.parseInt(teclado.nextLine()));

        // quantidadeAtual
        System.out.print("Digite a quantidade atual do produto: ");
        setquantidadeAtual(quantidadeAtual =  Integer.parseInt(teclado.nextLine()));

        produto = new Produto(codigo, nome, descricao, precoCompra, dataCompra, dataValidade, situacao, marca,
                quantidadeMinima, quantidadeAtual);

        // fechar teclado
        teclado.close();

        return produto;
    }

    // formatarData
    public String formatarData(LocalDate data) {
        return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
    }

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // mostrar
    public void mostrarProduto() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Preco de compra: " + precoCompra);
        // System.out.println("Data de compra: " + dataCompra);
        System.out.println("Data de compra: " + formatador.format(dataCompra));
        System.out.println("Data de validade: " + dataValidade);
        System.out.println("Situacao: " + situacao);
        System.out.println("Marca: " + marca);
        System.out.println("Quantidade minima: " + quantidadeMinima);
        System.out.println("Quantidade atual: " + quantidadeAtual);
        System.out.println("Esta em falta " + ((isEmFalta()) ? "Sim" : "Não"));

        // String texto = (isVencido()) ? "Sim" : "Não";
        // System.out.println("Esta vencido " + texto);

        System.out.println("Esta vencido " + ((isVencido()) ? "Sim" : "Não"));

    }t

}
