package vacinafx.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vacinafx.dao.VacinaDAO;
import vacinafx.dao.core.DAOFactory;
import vacinafx.dao.core.GenericJDBCDAO;
import vacinafx.model.Vacina;

public class ControllerPrincipal implements Initializable {

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoNova;

    @FXML
    private Button botaoPesquisar;

    @FXML
    private Button botaoRemover;

    @FXML
    private TableColumn<Vacina, Long> colunaCodigo;

    @FXML
    private TableColumn<Vacina, String> colunaDescricao;

    @FXML
    private TableColumn<Vacina, String> colunaNome;

    @FXML
    private TextField inputCodigo;

    @FXML
    private TextField inputDescricao;

    @FXML
    private TextField inputNome;

    @FXML
    private Label labelCodigo;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelNumero;

    @FXML
    // private TableView<?> tabela;
    private TableView<Vacina> tabela;

    private DAOFactory daoFactory;

    public void setDAOFACTORY(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Vacina> vacinasBuscadas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Your initialization code...
        // FXMLLoader fxmlLoader = new
        // FXMLLoader(getClass().getResource("/vacinafx/view/JanelaMain.fxml"));
        // chamar o método buscarTodasVacinas
        vacinasBuscadas = buscarTodasVacinas();

        colunaNome.setCellValueFactory(new PropertyValueFactory<Vacina, String>("nome"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vacina, String>("descricao"));
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Vacina, Long>("codigo"));

        tabela.getItems().addAll(vacinasBuscadas);
    }

    // Buscar vacina
    @FXML
    void pesquisarVacina(ActionEvent event) {

    }

    // Buscar Todas as vacinas
    private List<Vacina> buscarTodasVacinas() {
        try {
            daoFactory.abrirConexao();
            VacinaDAO vacinaDAO = daoFactory.getDAO(VacinaDAO.class);
            List<Vacina> vacinas = vacinaDAO.findAll();

            for (Vacina vacina : vacinas) {
                System.out.println(vacina);
            }
            return vacinas;
        }

        catch (SQLException e) {
            GenericJDBCDAO.showSQLException(e);

        } finally {
            daoFactory.fecharConexao();
        }
        return null;

    }

    @FXML
    void editarClicado(ActionEvent event) {

    }

    @FXML
    void novaClicado(ActionEvent event) {

    }

    @FXML
    void pesquisarClicado(ActionEvent event) {

    }

    @FXML
    void removerClicado(ActionEvent event) {

    }

}
