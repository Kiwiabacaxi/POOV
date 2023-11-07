package poov.testes;

import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.DAOFactory;
import poov.modelo.dao.VacinaDAO;

public class RemocaoBanco2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        DAOFactory factory = new DAOFactory();
        try {
            System.out.print("Digite o codigo da vacina a remover: ");
            long codigo = Long.parseLong(s.nextLine());
            factory.abrirConexao();
            VacinaDAO dao = factory.criarVacinaDAO();

            Vacina vacina = dao.buscar(codigo);
            if (vacina != null) {
                System.out.println(vacina);
                System.out.print("Deseja realmente remover essa vacina? (S/N): ");
                String opcao = s.nextLine();
                if (opcao.equalsIgnoreCase("S")) {
                    dao.remover(vacina);
                }
            } else {
                System.out.println("Nao foi encontrada uma vacina com o codigo: " + codigo);
            }
            s.close();
        } catch (SQLException ex) {
            DAOFactory.mostrarSQLException(ex);
        } finally {
            factory.fecharConexao();
        }
    }

}
