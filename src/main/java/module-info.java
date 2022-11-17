module com.gestionaleonstage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gestionaleonstage to javafx.fxml;
    exports com.gestionaleonstage;
}