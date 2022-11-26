package com.gestionaleonstage.sviluppo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller relatico alla sezione di sviluppo dedita alla gestione di acount e impostazioni del sistema
 */
public class ControllerSviluppo {
    /**
     * fx:id del pulsante relativo alla sotto sezione del database
     */
    @FXML
    private Button btnSetupDb;

    /**
     * fx:id del pulsante relativo alla sotto sezione relativa alle impostazioni degli account
     */
    @FXML
    private Button btnSetupAccount;

    /**
     * fx:id del pulsante relativo alla sotto sezione relativa alle modifiche account
     */
    @FXML
    private Button btnModificaAccount;

}
