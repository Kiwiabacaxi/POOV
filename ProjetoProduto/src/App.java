import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        // criar um produto com os dados fornecidos
        Produto produto = new Produto(12345678, "Arroz Doce", "Arroz branco de tanto jogar jogo do pão",
                new BigDecimal("12.5"), LocalDate.now(),
                LocalDate.now().plusDays(30), 1, "Tio Jorge", 10, 20);

        // imprimir os dados do produto
        System.out.println(produto);
        produto.mostrarProduto();

        // criar um produto com os dados do usuario
        Produto produto2 = produto.obterProduto();
        produto2.mostrarProduto();
    }
}
