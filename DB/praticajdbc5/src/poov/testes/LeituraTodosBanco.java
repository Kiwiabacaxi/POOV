package poov.testes;

import java.sql.SQLException;
import java.util.List;

import poov.modelo.Vacina;
import poov.modelo.dao.DAOFactory;
import poov.modelo.dao.VacinaDAOAntigo;

public class LeituraTodosBanco {

    public static void main(String[] args) {

        DAOFactory factory = new DAOFactory();
        try {
            factory.abrirConexao();
            VacinaDAOAntigo dao = factory.criarVacinaDAO();
            List<Vacina> vacinas = dao.buscarTodas();

            if (vacinas.isEmpty()) {
                System.out.println("Nao existem vacinas salvas no BD");
            } else {
                for (Vacina vacina : vacinas) {
                    System.out.println(vacina);
                }
            }
        } catch (SQLException ex) {
            DAOFactory.mostrarSQLException(ex);
        } finally {
            factory.fecharConexao();
        }

    }

}
