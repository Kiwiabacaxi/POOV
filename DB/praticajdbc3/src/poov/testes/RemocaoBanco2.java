package poov.testes;

import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.VacinaDAO;

public class RemocaoBanco2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Digite o codigo da vacina a remover: ");
        long codigo = Long.parseLong(s.nextLine());
        VacinaDAO dao = new VacinaDAO();

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
    }

    

}
