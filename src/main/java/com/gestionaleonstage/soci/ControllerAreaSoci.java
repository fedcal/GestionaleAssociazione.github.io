package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.DbScript;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Controller area soci
 */
public class ControllerAreaSoci implements Initializable {
    /**
     * fx:id relativo al DatePicker per la selezione della data di presentazione della domanda
     */
    @FXML
    private DatePicker datePresentazione;
    /**
     * fx:id relativo al DatePicker per la selezione della data di nascita del socio
     */
    @FXML
    private DatePicker dateNascita;
    /**
     * fx:id relativo al RadioButton per la selezionare se il socio è minorenne
     */
    @FXML
    private RadioButton minorenneNegativo;
    /**
     * fx:id relativo al RadioButton per la selezionare se il socio è maggiorenne
     */
    @FXML
    private RadioButton minorennePositivo;
    /**
     * fx:id relativo al TextField per inserire l'id della tessera
     */
    @FXML
    private TextField idTessera;
    /**
     * fx:id relativo al TextField per inserire il nome del socio
     */
    @FXML
    private TextField nome;
    /**
     * fx:id relativo al TextField per inserire il cognome del socio
     */
    @FXML
    private TextField cognome;
    /**
     * fx:id relativo al TextField per inserire il luogo di nascita del socio
     */
    @FXML
    private TextField luogoNascita;
    /**
     * fx:id relativo al TextField per inserire il cap del paese in cui il socio risiede
     */
    @FXML
    private TextField cap;
    /**
     * fx:id relativo al TextField per inserire l'indirizzo in cui il socio risiede
     */
    @FXML
    private TextField via;
    /**
     * fx:id relativo al TextField per inserire la città in cui il socio risiede
     */
    @FXML
    private TextField citta;
    /**
     * fx:id relativo al TextField per inserire la provincia
     */
    @FXML
    private TextField provincia;
    /**
     * fx:id relativo al RadioButton relativo al consenso positivo del socio per il trattamento dei dati
     */
    @FXML
    private RadioButton consensoPositivo;
    /**
     * fx:id relativo al RadioButton relativo al consenso negativo del socio per il trattamento dei dati
     */
    @FXML
    private RadioButton consensoNegativo;
    /**
     * fx:id relativo al TextField per inserire il numero di cellulare del socio
     */
    @FXML
    private TextField cellulare;
    /**
     * fx:id relativo al TextField per inserire l'email del socio
     */
    @FXML
    private TextField email;

    /**
     * Metodo per inserire un socio all'interno del database, può generare delle eccezioni di tipo SQL che vengono
     * opportunamente gestite
     *
     */
    @FXML
    private void insertSocio() {
        boolean checked=false;
        if(consensoNegativo.isSelected() || consensoPositivo.isSelected()){
            checked=true;
        }
        if(idTessera.getText().isEmpty()||nome.getText().isEmpty()||cognome.getText().isEmpty()||luogoNascita.getText().isEmpty()
                ||cap.getText().isEmpty()||via.getText().isEmpty()||citta.getText().isEmpty()||provincia.getText().isEmpty()||
               cellulare.getText().isEmpty()||email.getText().isEmpty()|| !checked|| dateNascita.getEditor().getText().equals(null)||datePresentazione.getEditor().getText().equals(null) ){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione!!!\n Non hai completato tutti i campi necessari per l'aggiunta del socio");
            alert.show();

        }else {
                try{
                    DbConnection dbConnection= new DbConnection();
                    DbScript dbScript = new DbScript();
                    String consenso=this.consensoNegativo.isSelected() ? "No" : "Si";
                    String minorenne=this.minorenneNegativo.isSelected() ? "No" : "Si";
                    String nascitaDate=this.dateNascita.getEditor().getText();
                    String presentazioneDate=this.datePresentazione.getEditor().getText();
                    String presentazioneG,presentazioneM,presentazioneY,nascitaG,nascitaM,nascitaY;
                    String[] nascitaSplit=nascitaDate.split("/");
                    String[] presentazioneSplit=presentazioneDate.split("/");
                    nascitaG=nascitaSplit[0];
                    nascitaM=nascitaSplit[1];
                    nascitaY=nascitaSplit[2];

                    presentazioneG=presentazioneSplit[0];
                    presentazioneM=presentazioneSplit[1];
                    presentazioneY=presentazioneSplit[2];

                    String query="insert into socio values ("+
                            this.idTessera.getText()+", '"+presentazioneY+"-"+presentazioneM+"-"+presentazioneG+"',"+"NULL"+",'"+this.cognome.getText()+"','"+this.nome.getText()+"', '"+nascitaY+"-"+nascitaM+"-"+nascitaG+"','"+this.luogoNascita.getText()+"','"+
                            this.via.getText()+"','"+this.citta.getText()+"','"+this.cap.getText()+"','"+this.cellulare.getText()+"','"+this.provincia.getText()+"','"+this.email.getText()+"',"+"NULL"+",'"+consenso+"','"+minorenne+"',"+"NULL"+")";
                    dbScript.triggerQuery(query,dbConnection.getConnection());
                    dbConnection.closeConnection();
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Perfetto!!! Il socio è stato aggiunto.");
                    alert.show();
                    clearField();
                }catch (Exception e){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Errore!!! Non è stato possibile aggiungere il socio.");
                    alert.show();
                }
            }
        }

    /**
     * Metedo per inizializzare la view dell'area per aggiungere i soci.
     * @param url URL Url relativo al file FXML della view
     * @param resourceBundle ResourceBundle Bundle della risorsa
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        this.consensoPositivo.setToggleGroup(toggleGroup);
        this.consensoNegativo.setToggleGroup(toggleGroup);
        ToggleGroup toggleGroup2 = new ToggleGroup();
        this.minorenneNegativo.setToggleGroup(toggleGroup2);
        this.minorennePositivo.setToggleGroup(toggleGroup2);

    }

    /**
     * Funzione che pulisce tutti i campi dopo l'inserimento di un utente
     */
    private void clearField(){
        this.idTessera.clear();
        this.nome.clear();
        this.cognome.clear();
        this.luogoNascita.clear();
        this.via.clear();
        this.citta.clear();
        this.cap.clear();
        this.provincia.clear();
        this.cellulare.clear();
        this.email.clear();
        this.minorennePositivo.setSelected(false);
        this.minorenneNegativo.setSelected(false);
        this.consensoNegativo.setSelected(false);
        this.consensoPositivo.setSelected(false);
        this.datePresentazione.setValue(null);
        this.dateNascita.setValue(null);
    }
}
