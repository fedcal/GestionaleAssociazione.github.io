module com.gestionaleonstage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.gestionaleonstage to javafx.fxml;
    exports com.gestionaleonstage;
    exports com.gestionaleonstage.soci;
    opens com.gestionaleonstage.soci to javafx.fxml;

    exports com.gestionaleonstage.eventi;
    opens com.gestionaleonstage.eventi to javafx.fxml;

    exports com.gestionaleonstage.gestione;
    opens com.gestionaleonstage.gestione to javafx.fxml;

    exports com.gestionaleonstage.sviluppo;
    opens com.gestionaleonstage.sviluppo to javafx.fxml;
}