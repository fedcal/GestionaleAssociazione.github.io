package com.gestionaleonstage.soci;

import com.gestionaleonstage.HomeApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contrroller Soci
 */
public class ControllerSoci implements Initializable {
    /**
     * fx:id relativo all'aggiunta di un nuovo membro
     */
    @FXML
    private Button btnAggiungiMembro;
    /**
     * fx:id relativo alla visualizzazione dei membri
     */
    @FXML
    private Button btnVisualizzaMembro;
    /**
     * fx:id relativo alla modifica dei membri
     */
    @FXML
    private Button btnModificaMembro;

    @FXML
    private void addSoci() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("sociArea/areaSoci-add.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Gestionale Associativo - Aggiungi soci");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
