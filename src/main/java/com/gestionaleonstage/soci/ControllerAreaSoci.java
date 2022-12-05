package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.DbScript;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerAreaSoci implements Initializable {
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
    private TextField dataNascita;
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
    private TextField dataPresentazione;
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
                ||dataNascita.getText().isEmpty()||cap.getText().isEmpty()||via.getText().isEmpty()||citta.getText().isEmpty()||provincia.getText().isEmpty()||
           dataPresentazione.getText().isEmpty()||cellulare.getText().isEmpty()||email.getText().isEmpty()|| !checked ){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione!!!\n Non hai completato tutti i campi necessari per l'aggiunta del socio");
            alert.show();

        }else{
            DbConnection dbConnection= new DbConnection();
            DbScript dbScript = new DbScript();
            String consenso=this.consensoNegativo.isSelected() ? "No" : "Si";
            String minorenne=this.minorenneNegativo.isSelected() ? "No" : "Si";
            String query="insert into socio values ("+
                    this.idTessera.getText()+", DATE '"+this.dataPresentazione.getText()+"',"+"NULL"+",'"+this.cognome.getText()+"','"+this.nome.getText()+"',DATE '"+this.dataNascita.getText()+"','"+this.luogoNascita.getText()+"','"+
                    this.via.getText()+"','"+this.citta.getText()+"','"+this.cap.getText()+"','"+this.cellulare.getText()+"','"+this.provincia.getText()+"','"+this.email.getText()+"',"+"NULL"+",'"+consenso+"','"+minorenne+"',"+"NULL"+")";
            dbScript.insertSocio(query,dbConnection.getConnection());
            dbConnection.closeConnection();
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
}
