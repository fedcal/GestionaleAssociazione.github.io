package com.gestionaleonstage.soci;

import com.gestionaleonstage.HomeApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Controller Soci
 */
public class ControllerSoci {
      /**
     * Funzione per aprire la view relativa all'aggiunta di un socio
     * @throws IOException Exception generata in caso non viene trovato il file FXML relativo
     */
    @FXML
    private void addSoci() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("sociArea/areaSoci-add.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Gestionale Associativo - Aggiungi soci");
        stage.show();
    }

    /**
     * Funzione per aprire la view relativa alla visualizzazione di un socio
     * @throws IOException Exception generata in caso non viene trovato il file FXML relativo
     */
    @FXML
    private void visualizzaSoci() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("sociArea/areaSoci-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Gestionale Associativo - Visualizza soci");
        stage.show();
    }

    public void modificaSoci( ) {
    }

    public void exportSoci() {
    }
}
