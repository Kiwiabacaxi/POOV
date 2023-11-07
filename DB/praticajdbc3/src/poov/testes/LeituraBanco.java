package poov.testes;

import java.util.Scanner;

import poov.modelo.Vacina;
import poov.modelo.dao.VacinaDAO;

public class LeituraBanco {

    public static void main(String[] args) {

        VacinaDAO dao = new VacinaDAO();
        Scanner s = new Scanner(System.in);
        long codigo;
        System.out.print("Digite o código da vacina: ");
        codigo = Long.parseLong(s.nextLine());

        Vacina vacina = dao.buscar(codigo);
        System.out.println(vacina);

        s.close();
    }


}
