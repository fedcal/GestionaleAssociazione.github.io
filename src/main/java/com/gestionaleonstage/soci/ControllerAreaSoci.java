package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.DbScript;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerAreaSoci implements Initializable {

    @FXML
    private DatePicker datePresentazione;
    @FXML
    private DatePicker dateNascita;

    @FXML
    private RadioButton minorenneNegativo;
    @FXML
    private RadioButton minorennePositivo;
    @FXML
    private TextField idTessera;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField luogoNascita;
    @FXML
    private TextField cap;
    @FXML
    private TextField via;
    @FXML
    private TextField citta;
    @FXML
    private TextField provincia;
    @FXML
    private RadioButton consensoPositivo;
    @FXML
    private RadioButton consensoNegativo;
    @FXML
    private TextField cellulare;
    @FXML
    private TextField email;

    @FXML
    private void insertSocio() throws SQLException {
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
                            this.idTessera.getText()+", DATE '"+presentazioneY+"-"+presentazioneM+"-"+presentazioneG+"',"+"NULL"+",'"+this.cognome.getText()+"','"+this.nome.getText()+"',DATE '"+nascitaY+"-"+nascitaM+"-"+nascitaG+"','"+this.luogoNascita.getText()+"','"+
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        this.consensoPositivo.setToggleGroup(toggleGroup);
        this.consensoNegativo.setToggleGroup(toggleGroup);
        ToggleGroup toggleGroup2 = new ToggleGroup();
        this.minorenneNegativo.setToggleGroup(toggleGroup2);
        this.minorennePositivo.setToggleGroup(toggleGroup2);

    }
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
