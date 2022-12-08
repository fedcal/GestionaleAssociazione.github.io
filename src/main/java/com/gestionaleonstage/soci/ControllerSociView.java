package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.Example;
import com.gestionaleonstage.database.TableData;
import com.gestionaleonstage.database.TableSchema;
import com.gestionaleonstage.entity.Soci;
import com.gestionaleonstage.exception.EmptySetException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControllerSociView implements Initializable {
    private TreeSet<Soci> elencoSoci=new TreeSet<>();
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
    private void infoSocio(){
        if(listaSociView.getSelectionModel().getSelectedItem()==null){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Seleziona un socio prima per richiederne le informazioni");
            a.show();
        }else {
            String selectedSocio = listaSociView.getSelectionModel().getSelectedItem().toString();

            String[] socioSplit = selectedSocio.split(" ");
            int idTessera = Integer.parseInt(socioSplit[0]);
            Iterator<Soci> iterator = this.elencoSoci.iterator();
            boolean trovato = false;
            while (iterator.hasNext() && trovato == false) {
                Soci socio = (Soci) iterator.next();
                if (socio.getTessera() == idTessera) {
                    trovato = true;
                    this.tessera.setText(Integer.toString(socio.getTessera()));
                    this.nome.setText(socio.getNome());
                    this.cognome.setText(socio.getCognome());
                    this.dataNascita.setText(socio.getNascita() == null ? " " : new SimpleDateFormat("dd-mm-yyyy").format(socio.getNascita()));
                    this.luogoNascita.setText(socio.getLuogoNascita());
                    this.indirizzo.setText(socio.getVia());
                    this.citta.setText(socio.getCitta());
                    this.cap.setText(socio.getCap());
                    this.provincia.setText(socio.getProvincia());
                    this.note.setText(socio.getNote() == null ? " " : socio.getNote());
                    this.email.setText(socio.getEmail());
                    this.cellulare.setText(socio.getTelefono());
                    this.consensoDati.setText(socio.getConsenso());
                    this.minorenne.setText(socio.getMinorenne());
                    this.dataAnnullamento.setText(socio.getdataAnnullamento() == null ? "" : new SimpleDateFormat("dd-mm-yyyy").format(socio.getdataAnnullamento()));
                    this.dataIscrizione.setText(new SimpleDateFormat("dd-mm-yyyy").format(socio.getDataIscrizione()));
                }
            }
        }
    }

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
        uploadElencoSoci();
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
        try {
            dbConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void uploadElencoSoci(){
        DbConnection dbConnection=new DbConnection();
        TableData tableData=new TableData(dbConnection);
        LinkedList<Example> trans=new LinkedList<>();
        try{
            trans=tableData.getTransazioni("select * from socio","socio");
            TableSchema tableSchema=new TableSchema(dbConnection,"socio");
            for(int i=0;i<trans.size();i++){
                Soci socio=new Soci();
                socio.setTessera(Integer.parseInt(trans.get(i).get(0).toString()));
                socio.setDataIscrizione(new SimpleDateFormat("yyyy-mm-dd").parse(trans.get(i).get(1).toString()));

                if(trans.get(i).get(2)!=null)
                    socio.setDataApprovazione(new SimpleDateFormat("yyyy-mm-dd").parse(trans.get(i).get(2).toString()));

                socio.setCognome(trans.get(i).get(3).toString());
                socio.setNome(trans.get(i).get(4).toString());
                socio.setNascita(new SimpleDateFormat("yyyy-mm-dd").parse(trans.get(i).get(5).toString()));
                socio.setLuogoNascita(trans.get(i).get(6).toString());
                socio.setVia(trans.get(i).get(7).toString());
                socio.setCitta(trans.get(i).get(8).toString());
                socio.setCap(trans.get(i).get(9).toString());
                socio.setTelefono(trans.get(i).get(10).toString());
                socio.setProvincia(trans.get(i).get(11).toString());
                socio.setEmail(trans.get(i).get(12).toString());
                if(trans.get(i).get(13)!=null)
                    socio.setdataAnnullamento(new SimpleDateFormat("yyyy-mm-dd").parse(trans.get(i).get(13).toString()));
                socio.setConsenso(trans.get(i).get(14).toString());
                socio.setMinorenne(trans.get(i).get(15).toString());
                if(trans.get(i).get(16)!=null)
                    socio.setNote(trans.get(i).get(16).toString());
                this.elencoSoci.add(socio);
            }
            dbConnection.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
