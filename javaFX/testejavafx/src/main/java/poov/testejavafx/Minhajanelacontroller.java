package poov.testejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Minhajanelacontroller {

    @FXML
    private Label labelResultado;

    @FXML
    private TextField textFieldNome;

    @FXML
    void botaoClicado(ActionEvent event) {
        String nome = textFieldNome.getText(); // pega o texto do campo de texto
        labelResultado.setText("Olá " + nome + " Seja bem vindo\n"); // coloca o texto no label
        // labelResultado.con
    }

}
