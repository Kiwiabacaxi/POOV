package poov.testes;

import java.util.List;

import poov.modelo.Vacina;
import poov.modelo.dao.VacinaDAO;

public class LeituraTodosBanco {

    public static void main(String[] args) {
        
        VacinaDAO dao = new VacinaDAO();
        List<Vacina> vacinas = dao.buscarTodas();

        if (vacinas.isEmpty()) {
            System.out.println("Nao existem vacinas salvas no BD");
        } else {
            for (Vacina vacina : vacinas) {
                System.out.println(vacina);
            }
        }

    }

}
