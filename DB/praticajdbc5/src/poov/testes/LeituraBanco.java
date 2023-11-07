package poov.testes;

import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.DAOFactory;
import poov.modelo.dao.VacinaDAOAntigo;

public class LeituraBanco {

    public static void main(String[] args) {

        DAOFactory factory = new DAOFactory();
        try {
            factory.abrirConexao();
            VacinaDAOAntigo dao = factory.criarVacinaDAO();

            Scanner s = new Scanner(System.in);
            long codigo;
            System.out.print("Digite o código da vacina: ");
            codigo = Long.parseLong(s.nextLine());

            Vacina vacina = dao.buscar(codigo);
            System.out.println(vacina);

            s.close();

        } catch (SQLException ex) {
            DAOFactory.mostrarSQLException(ex);
        } finally {
            factory.fecharConexao();
        }
    }

}
