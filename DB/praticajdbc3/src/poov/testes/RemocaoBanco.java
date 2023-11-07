package poov.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.ConexaoFactory;

public class RemocaoBanco {

    public static void main(String[] args) {
        
        Connection conexao = null;
        try {
            conexao = ConexaoFactory.getConexao();

//       a) crie um objeto Scanner para ler valores do teclado
            Scanner s = new Scanner(System.in);

//       b) obtenha o codigo do Vacina a ser removida via teclado
            System.out.print("Digite o codigo da vacina a remover: ");
            long codigo = Long.parseLong(s.nextLine());

//       c) crie um objeto PreparedStatement com o código SQL de seleção. Quem cria o objeto é o objeto 
//conexao criado anteriormente
            String sqlSelecao = "SELECT * FROM VACINA WHERE codigo = ? AND situacao = 'ATIVO';";
            PreparedStatement pstmtSel = conexao.prepareStatement(sqlSelecao);

//       d) use o método setLong do PreparedStatement criado para substituir a interrogação do código
// SQL pelo valor desejado, nesse caso o valor do codigo entrado pelo teclado
            pstmtSel.setLong(1, codigo);

//       e) execute o PreparedStatement fazendo com que a seleção seja feita e guarde o resultado em um
//  ResultSet
            ResultSet rs = pstmtSel.executeQuery();

//       f) chame o método next( ) do ResultSet para que “o cursor” ande para a próxima linha lida do
// banco (nesse caso, a primeira). O next( ) retorna true se isso foi possível e false caso contrário
            if (rs.next()) {

//       g) se foi possível executar o next( ) é porque a Vacina com esse codigo existe
// 	         h) mostre na tela os valores obtidos no ResultSet usando os métodos getLong( ) e getString( )
                Vacina vacina = new Vacina(rs.getLong(1), rs.getString(2), rs.getString(3));
                System.out.println(vacina);

// 	         i) pergunte ao usuário se ele realmente deseja remover essa vacina
                System.out.print("Deseja realmente remover essa vacina? (S/N): ");
                String opcao = s.nextLine();

// 	         j) se sim, crie um objeto PreparedStatement com o código SQL para a remoção
                if (opcao.equalsIgnoreCase("S")) {
                    String sqlRemocao = "DELETE FROM vacina WHERE codigo = ?;";
                    PreparedStatement pstmtDel = conexao.prepareStatement(sqlRemocao);

// 	         k) use o método setLong do PreparedStatement criado para substituir a interrogação do código
// SQL pelo valor desejado, nesse caso o valor do codigo entrado pelo teclado
                    pstmtDel.setLong(1, codigo);

// 	         l) execute o PreparedStatement fazendo com que a remoção seja feita e guarde o resultado em
// um int
                    int resultado = pstmtDel.executeUpdate();

// 	         m) teste se o retorno da remoção foi igual a 1 (o número de linhas removidas nesse caso)
// e avise o usuário do resultado da remoção
                    if (resultado == 1) {
                        System.out.println("Remocao da vacina executada com sucesso");
                    } else {
                        System.out.println("Erro removendo a vacina com codigo: " + codigo);
                    }

//       n) feche os objetos usados
                    pstmtDel.close();
                }
                rs.close();
                pstmtSel.close();
                s.close();
            } else {
                System.out.println("Nao foi encontrada uma vacina com o codigo: " + codigo);
            }
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
