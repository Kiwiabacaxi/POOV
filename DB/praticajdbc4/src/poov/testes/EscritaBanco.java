package poov.testes;

import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.DAOFactory;
import poov.modelo.dao.VacinaDAO;

public class EscritaBanco {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Vacina v = new Vacina();
        DAOFactory factory = new DAOFactory();
        try {
            factory.abrirConexao();
            VacinaDAO dao = factory.criarVacinaDAO();

            System.out.print("Digite o nome: ");
            v.setNome(s.nextLine());
            System.out.print("Digite a descricao: ");
            v.setDescricao(s.nextLine());

            dao.gravar(v);

            s.close();
        } catch (SQLException ex) {
            DAOFactory.mostrarSQLException(ex);
        } finally {
            factory.fecharConexao();
        }
    }

}
