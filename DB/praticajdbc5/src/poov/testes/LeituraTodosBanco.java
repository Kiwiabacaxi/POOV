package poov.testes;

import java.sql.SQLException;
import java.util.List;

import poov.modelo.Vacina;
import poov.modelo.dao.ConexaoFactoryPostgreSQL;
import poov.modelo.dao.VacinaDAO;
import poov.modelo.dao.core.ConnectionFactory;
import poov.modelo.dao.core.DAOFactory;
import poov.modelo.dao.core.GenericJDBCDAO;

public class LeituraTodosBanco {

    public static void main(String[] args) {

        ConnectionFactory conexaoFactory = new ConexaoFactoryPostgreSQL("localhost:5432/poov", "postgres", "12345");
        DAOFactory factory = new DAOFactory(conexaoFactory);
        try {
            factory.abrirConexao();
            VacinaDAO dao = factory.getDAO(VacinaDAO.class);
            List<Vacina> vacinas = dao.findAll();

            if (vacinas.isEmpty()) {
                System.out.println("Nao existem vacinas salvas no BD");
            } else {
                for (Vacina vacina : vacinas) {
                    System.out.println(vacina);
                }
            }
        } catch (SQLException ex) {
            GenericJDBCDAO.showSQLException(ex);
        } finally {
            factory.fecharConexao();
        }

    }

}
