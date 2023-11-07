package poov.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemocaoBanco {
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
            // REMOCAO DO BANCO
            // a) crie um objeto Scanner para ler valores do teclado
            Scanner teclado = new Scanner(System.in);

            // b) obtenha o codigo do Vacina a ser removida via teclado
            System.out.println("Digite o código da vacina, que deseja consultar: ");
            long codigo = teclado.nextLong();

            // c) crie um objeto PreparedStatement com o código SQL de seleção. Quem cria o
            // objeto é o objeto conexao criado anteriormente
            String sql = "SELECT * FROM vacina WHERE codigo = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // d) use o método setLong do PreparedStatement criado para substituir a
            // interrogação do código SQL pelo valor desejado, nesse caso o valor do codigo
            // entrado pelo teclado
            stmt.setLong(1, codigo);

            // e) execute o PreparedStatement fazendo com que a seleção seja feita e guarde
            // o resultado em um ResultSet
            ResultSet rs = stmt.executeQuery();

            // f) chame o método next( ) do ResultSet para que “o cursor” ande para a
            // próxima linha lida do banco (nesse caso, a primeira). O next( ) retorna true
            // se isso foi possível e false caso contrário
            if (rs.next() == true) {
                // g) se foi possível executar o next( ) é porque a Vacina com esse codigo
                // existe
                // h) mostre na tela os valores obtidos no ResultSet usando os métodos getLong(
                // ) e getString( )

                System.out.println("Código: " + rs.getLong("codigo"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("====================================");

                // i) pergunte ao usuário se ele realmente deseja remover essa vacina
                System.out.println("Deseja remover essa vacina? (S/N)");
                String resposta = teclado.next();

                // j) se sim, crie um objeto PreparedStatement com o código SQL para a remoção
                if (resposta.equals("S") || resposta.equals("s")) {
                    PreparedStatement stmt2 = conexao.prepareStatement("DELETE FROM vacina WHERE codigo = ?");

                    // k) use o método setLong do PreparedStatement criado para substituir a
                    // interrogação do código SQL pelo valor desejado, nesse caso o valor do codigo
                    // entrado pelo teclado
                    stmt2.setLong(1, codigo);

                    // l) execute o PreparedStatement fazendo com que a remoção seja feita e guarde
                    // o resultado em um int
                    stmt2.executeUpdate();

                    // m) teste se o retorno da remoção foi igual a 1 (o número de linhas removidas
                    // nesse caso) e avise o usuário do resultado da remoção
                    if (stmt2.getUpdateCount() == 1) {
                        System.out.println("Vacina removida com sucesso!");
                    } else {
                        System.out.println("Erro ao remover vacina!");
                    }

                } else {
                    System.out.println("Vacina não removida.");
                }

            } else {
                System.out.println("Vacina não encontrada.");
            }

            // n) feche os objetos usados
            teclado.close();

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
