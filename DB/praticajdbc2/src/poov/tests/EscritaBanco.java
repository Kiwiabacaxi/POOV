package poov.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poov.models.Vacina;

public class EscritaBanco {

    public static void main(String[] args) {
        String caminho = "jdbc:postgresql";
        String host = "localhost";
        String porta = "5432";
        String bd = "postgres";
        String login = "postgres";
        String senha = "12345";
        String url = caminho + "://" + host + ":" + porta + "/" + bd;
        String classeDriver = "org.postgresql.Driver";
        Connection conexao = null;

        try {
            System.out.println("Conectando com o banco de dados.");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");
            // ESCRITA NO BANCO

            // a) crie um objeto Scanner para ler valores do teclado
            Scanner scanner = new Scanner(System.in);

            // b) crie um objeto Vacina para guardar os dados lidos pelo teclado
            Vacina vacina = new Vacina();

            // c) obtenha os dados da vacina via teclado
            System.out.println("Digite o nome da vacina: ");
            vacina.setNome(scanner.nextLine());

            System.out.println("Digite a descrição da vacina: ");
            vacina.setDescricao(scanner.nextLine());

            // System.out.println("Digite o código da vacina: ");
            // vacina.setCodigo(scanner.nextLong());

            // d) crie um objeto PreparedStatement com o código SQL de inserção, avisando
            // que você vai querer buscar as chaves geradas.
            // Quem cria o objeto é o objeto conexao criado anteriormente

            String sql = "INSERT INTO vacina (nome, descricao) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getDescricao());

            // f) execute o PreparedStatement fazendo com que a inserção seja feita
            stmt.executeUpdate(); // para executar o comando SQL

            // g) teste se o retorno da inserção foi igual a 1 (o número de linhas inseridas
            // nesse caso) avisando o usuário do resultado e
            // g.1) crie um objeto ResultSet buscando as chaves geradas no banco
            // g.2) se você recebeu resultados nesse ResultSet use o 1o valor como codigo
            // inserindo-o no objeto vacina

            if (stmt.getUpdateCount() == 1) {
                System.out.println("Vacina inserida com sucesso!");
                ResultSet rs = stmt.getGeneratedKeys();

                while (rs.next()) {
                    vacina.setCodigo(rs.getLong(1));
                }

                // g.3) feche o ResultSet
                rs.close();

            } else {
                System.out.println("Erro ao inserir vacina!");
            }

            // h) feche o PreparedStatement que foi criado
            stmt.close();
            scanner.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            SQLException e = ex;
            while (e != null) {
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Mensagem: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
                e = e.getNextException();
            }
        } finally {
            if (conexao != null) {
                System.out.println("Terminando a conexão com o banco de dados.");
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro fechando a conexão com o banco de dados.");
                }
                System.out.println("Conexão com o banco de dados terminada.");
            }
        }

    }

}
