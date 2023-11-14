module poov.testejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens poov.testejavafx to javafx.fxml;

    exports poov.testejavafx;
}
