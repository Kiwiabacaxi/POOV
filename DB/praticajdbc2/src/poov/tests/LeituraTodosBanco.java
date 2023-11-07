package poov.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeituraTodosBanco {
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
            // LEITURA DE TODOS DO BANCO

            // a) crie um objeto Statement com o código SQL de seleção. Quem cria o objeto é
            // o objeto conexao criado anteriormente
            String sql = "SELECT * FROM vacina";

            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // b) execute o Statement fazendo com que a seleção seja feita e guarde o
            // resultado em um ResultSet
            ResultSet rs = stmt.executeQuery();

            // c) chame o método next( ) do ResultSet em um laço para que “o cursor” ande
            // para a próxima linha lida do banco. O next( ) retorna true se isso foi
            // possível e false caso contrário
            while (rs.next()) {
                // d) dentro do laço mostre na tela os valores obtidos no ResultSet usando os
                // métodos getLong( ) e getString( )
                System.out.println("Código: " + rs.getLong("codigo"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("====================================");
            }

            // e) feche os objetos utilizados
            rs.close();
            stmt.close();

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
