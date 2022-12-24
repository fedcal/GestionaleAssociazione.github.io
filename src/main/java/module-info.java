module com.gestionaleonstage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;
    requires poi.ooxml;
    requires poi;


    opens com.gestionaleonstage to javafx.fxml;
    opens com.gestionaleonstage.database to javafx.fxml;
    opens com.gestionaleonstage.entity to javafx.fxml;
    opens com.gestionaleonstage.eventi to javafx.fxml;
    opens com.gestionaleonstage.exception to javafx.fxml;
    opens com.gestionaleonstage.gestione to javafx.fxml;
    opens com.gestionaleonstage.soci to javafx.fxml;
    opens com.gestionaleonstage.sviluppo to javafx.fxml;
    opens com.gestionaleonstage.test  to javafx.fxml;
    opens com.gestionaleonstage.util  to javafx.fxml;


    exports com.gestionaleonstage;
    exports com.gestionaleonstage.sviluppo;
    exports com.gestionaleonstage.database;
    exports com.gestionaleonstage.entity;
    exports com.gestionaleonstage.eventi;
    exports com.gestionaleonstage.gestione;
    exports com.gestionaleonstage.soci;
    exports com.gestionaleonstage.test;
}