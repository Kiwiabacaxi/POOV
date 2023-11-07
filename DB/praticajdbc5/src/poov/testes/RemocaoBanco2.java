package poov.testes;

import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.Situacao;
import poov.modelo.Vacina;
import poov.modelo.dao.ConexaoFactoryPostgreSQL;
import poov.modelo.dao.VacinaDAO;
import poov.modelo.dao.core.ConnectionFactory;
import poov.modelo.dao.core.DAOFactory;
import poov.modelo.dao.core.GenericJDBCDAO;

public class RemocaoBanco2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ConnectionFactory conexaoFactory = new ConexaoFactoryPostgreSQL("localhost:5432/poov", "postgres", "12345");
        DAOFactory factory = new DAOFactory(conexaoFactory);
        try {
            System.out.print("Digite o codigo da vacina a remover: ");
            long codigo = Long.parseLong(s.nextLine());
            factory.abrirConexao();
            VacinaDAO dao = factory.getDAO(VacinaDAO.class);

            Vacina vacina = dao.findById(codigo);
            if (vacina != null) {
                System.out.println(vacina);
                System.out.print("Deseja realmente remover essa vacina? (S/N): ");
                String opcao = s.nextLine();
                if (opcao.equalsIgnoreCase("S")) {
                    vacina.setSituacao(Situacao.INATIVO);
                    dao.update(vacina);
                }
            } else {
                System.out.println("Nao foi encontrada uma vacina com o codigo: " + codigo);
            }
            s.close();
        } catch (SQLException ex) {
            GenericJDBCDAO.showSQLException(ex);
        } finally {
            factory.fecharConexao();
        }
    }

}
