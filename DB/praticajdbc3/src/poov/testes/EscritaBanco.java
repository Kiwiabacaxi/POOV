package poov.testes;

import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.VacinaDAO;

public class EscritaBanco {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Vacina v = new Vacina();
        VacinaDAO dao = new VacinaDAO();

        System.out.print("Digite o nome: ");
        v.setNome(s.nextLine());
        System.out.print("Digite a descricao: ");
        v.setDescricao(s.nextLine());

        dao.gravar(v);

        s.close();
    }

}
