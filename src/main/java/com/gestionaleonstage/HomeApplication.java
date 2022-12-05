package com.gestionaleonstage;

import com.gestionaleonstage.database.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe dedicata all'avvio dell'applicazione ed estende Application
 */
public class HomeApplication extends Application {
    /**
     * Override della funzione start per il lancio dell'applicazione
     * @param stage Stage in cui si troverà l'home dell'applicazione
     * @throws IOException Il metodo può generare un'eccezione di IOException nel caso in cui non trovi il file fxml all'interno dell'applicazione.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 530);
        stage.setTitle("Gestionale associazione");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * Funzzione main della classe che richiama il metodo lunch() per generare l'applicazione
     * @param args argomenti dell'applicazione
     */
    public static void main(String[] args) {
        launch();
    }
}