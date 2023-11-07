package poov.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import poov.modelo.Vacina;

public class VacinaDAO {

    private final Connection conexao;

    public VacinaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Vacina vacina) {

        try {

            String sql = "INSERT INTO vacina(nome, descricao) VALUES (?, ?);";
            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, vacina.getNome());
            pstmt.setString(2, vacina.getDescricao());

            if (pstmt.executeUpdate() == 1) {
                System.out.println("Insercao da vacina feita com sucesso");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    vacina.setCodigo(rs.getLong(1));
                } else {
                    System.out.println("Erro ao obter o codigo gerado pelo BD para a vacina");
                }
                rs.close();
            } else {
                System.out.println("Erro ao inserir a vacina");
            }
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            SQLException e = ex;
            while (e != null) {
                System.out.println("Causa: " + t);
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Mensagem: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    t = t.getCause();
                }
                e = e.getNextException();
            }
        }
    }

    public Vacina buscar(long codigo) {
        Vacina v = null;
        // try {
        //     String sql = "SELECT * FROM vacina WHERE codigo = ? AND situacao = 'ATIVO';";
        //     PreparedStatement pstmt = conexao.prepareStatement(sql);
        //     pstmt.setLong(1, codigo);
        //     ResultSet rs = pstmt.executeQuery();
        //     if (rs.next()) {
        //         v = new Vacina(rs.getLong(1), rs.getString(2), rs.getString(3));
        //     } else {
        //         System.out.println("Nao foi encontrada uma vacina com o codigo " + codigo);
        //     }
        //     rs.close();
        //     pstmt.close();
        // } catch (SQLException ex) {
        //     System.out.println("Erro no acesso ao banco de dados.");
        //     SQLException e = ex;
        //     while (e != null) {
        //         System.out.println("SQL State: " + e.getSQLState());
        //         System.out.println("Error Code: " + e.getErrorCode());
        //         System.out.println("Mensagem: " + e.getMessage());
        //         Throwable t = e.getCause();
        //         while (t != null) {
        //             System.out.println("Causa: " + t);
        //             t = t.getCause();
        //         }
        //         e = e.getNextException();
        //     }
        }
        return v;
    }

    public List<Vacina> buscarTodas() {
        Vacina v;
        List<Vacina> vacinas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vacina WHERE situacao = 'ATIVO';";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                v = new Vacina(rs.getLong(1), rs.getString(2), rs.getString(3));
                vacinas.add(v);
            }
            rs.close();
            stmt.close();
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
        }
        return vacinas;
    }

    public boolean remover(Vacina vacina) {

        boolean retorno = false;
        try {

            String sqlUpdate = "UPDATE vacina SET situacao = 'INATIVO' WHERE codigo = ?;";
            PreparedStatement pstmtUpd = conexao.prepareStatement(sqlUpdate);

            pstmtUpd.setLong(1, vacina.getCodigo());

            int resultado = pstmtUpd.executeUpdate();

            if (resultado == 1) {
                System.out.println("Remocao da vacina executada com sucesso");
                retorno = true;
            } else {
                System.out.println("Erro removendo a vacina com codigo: " + vacina.getCodigo());
            }

            pstmtUpd.close();

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
        }
        return retorno;
    }

    public boolean atualizar(Vacina vacina) {
        boolean retorno = false;
        try {

            String sqlUpdate = "UPDATE vacina SET nome = ?, descricao = ?, situacao = ? WHERE codigo = ?;";
            PreparedStatement pstmtUpd = conexao.prepareStatement(sqlUpdate);
            pstmtUpd.setString(1, vacina.getNome());
            pstmtUpd.setString(2, vacina.getDescricao());
            pstmtUpd.setString(3, vacina.getSituacao().toString());
            pstmtUpd.setLong(4, vacina.getCodigo());

            int resultado = pstmtUpd.executeUpdate();
            if (resultado == 1) {
                System.out.println("Alteracao da vacina executada com sucesso");
                retorno = true;
            } else {
                System.out.println("Erro alterando a vacina com codigo: " + vacina.getCodigo());
            }
            pstmtUpd.close();
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
        }
        return retorno;
    }

}
