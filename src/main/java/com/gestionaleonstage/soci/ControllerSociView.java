package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.Example;
import com.gestionaleonstage.database.TableData;
import com.gestionaleonstage.database.TableSchema;
import com.gestionaleonstage.entity.Soci;
import com.gestionaleonstage.exception.EmptySetException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControllerSociView implements Initializable {
    @FXML
    private ListView listaSociView;
    @FXML
    private Label tessera;
    @FXML
    private Label nome;
    @FXML
    private Label cognome;
    @FXML
    private Label dataNascita;
    @FXML
    private Label luogoNascita;
    @FXML
    private Label indirizzo;
    @FXML
    private Label citta;
    @FXML
    private Label cap;
    @FXML
    private Label provincia;
    @FXML
    private Label email;
    @FXML
    private Label cellulare;
    @FXML
    private Label consensoDati;
    @FXML
    private Label minorenne;
    @FXML
    private Label dataAnnullamento;
    @FXML
    private Label dataIscrizione;
    @FXML
    private Label note;

    @FXML
    private void infoSocio(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.cap.setText("");
        this.cellulare.setText("");
        this.dataIscrizione.setText("");
        this.consensoDati.setText("");
        this.tessera.setText("");
        this.nome.setText("");
        this.cognome.setText("");
        this.dataNascita.setText("");
        this.luogoNascita.setText("");
        this.indirizzo.setText("");
        this.citta.setText("");
        this.provincia.setText("");
        this.email.setText("");
        this.minorenne.setText("");
        this.dataAnnullamento.setText("");
        this.note.setText("");

        DbConnection dbConnection=new DbConnection();
        LinkedList<Example> trans=new LinkedList<>();
        TableData tableData=new TableData(dbConnection);
        TreeSet<String> setSoci=new TreeSet<>();
        try {
            trans=tableData.getTransazioni("select * from socio","socio");
            TableSchema tableSchema=new TableSchema(dbConnection,"socio");
            for(int i=0;i<trans.size();i++){

                String socioElab="";
                socioElab+=trans.get(i).get(0).toString()+" ";
                socioElab+=trans.get(i).get(4).toString()+" ";
                socioElab+=trans.get(i).get(3).toString();
                setSoci.add(socioElab);            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (EmptySetException e) {
            throw new RuntimeException(e);
        }
        Iterator<String> setIterator= setSoci.iterator();
        while (setIterator.hasNext()){
            String socio= setIterator.next().toString();
            listaSociView.getItems().add(socio);
        }
    }
}
