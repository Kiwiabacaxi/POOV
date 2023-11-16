package vacinafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerPrincipal {

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoNova;

    @FXML
    private Button botaoPesquisar;

    @FXML
    private Button botaoRemover;

    @FXML
    private TableColumn<?, ?> colunaCodigo;

    @FXML
    private TableColumn<?, ?> colunaDescricao;

    @FXML
    private TableColumn<?, ?> colunaNome;

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
    private TableView<?> tabela;

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
