package com.gestionaleonstage.soci;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.Example;
import com.gestionaleonstage.database.TableData;
import com.gestionaleonstage.entity.Soci;
import com.gestionaleonstage.exception.EmptySetException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Controller della view per visualizzare tutti i soci
 */
public class ControllerSociView implements Initializable {
    /**
     * TreeSet che contiene tutto l'elenco dei soci
     */
    private final TreeSet<Soci> elencoSoci=new TreeSet<>();
    /**
     * fx:id legato alla ListView in cui vengono visualizzati tutti i soci
     */
    @FXML
    private ListView listaSociView;
    /**
     * fx:id relativo al Label per visualizzare il numero della tessera
     */
    @FXML
    private Label tessera;
    /**
     * fx:id relativo al Label per visualizzare il nome del socio
     */
    @FXML
    private Label nome;
    /**
     * fx:id relativo al Label per visualizzare il cognome del
     */
    @FXML
    private Label cognome;
    /**
     * fx:id relativo al Label per visualizzare la data di nascita il socio
     */
    @FXML
    private Label dataNascita;
    /**
     * fx:id relativo al Label per visualizzare la città di nascita del socio
     */
    @FXML
    private Label luogoNascita;
    /**
     * fx:id relativo al Label per visualizzare l'indirizzo incui risiede il socio
     */
    @FXML
    private Label indirizzo;
    /**
     * fx:id relativo al Label per visualizzare la città in cui risiede il socio
     */
    @FXML
    private Label citta;
    /**
     * fx:id relativo al Label per visualizzare il cap della città in cui risiede il socio
     */
    @FXML
    private Label cap;
    /**
     * fx:id relativo al Label per visualizzare la provincia in cui risiede il socio
     */
    @FXML
    private Label provincia;
    /**
     * fx:id relativo al Label per visualizzare l'email del socio
     */
    @FXML
    private Label email;
    /**
     * fx:id relativo al Label per visualizzare il numero di cellulare del socio
     */
    @FXML
    private Label cellulare;
    /**
     * fx:id relativo al Label per visualizzare se il socio ha prestato il consenso per il trattamento dei dati
     */
    @FXML
    private Label consensoDati;
    /**
     * fx:id relativo al Label per visualizzare se il socio è minorenne o meno
     */
    @FXML
    private Label minorenne;
    /**
     * fx:id relativo al Label per visualizzare la data di annullamento dell'iscrizione del socio
     */
    @FXML
    private Label dataAnnullamento;
    /**
     * fx:id relativo al Label per visualizzare la data di iscrizione del socio
     */
    @FXML
    private Label dataIscrizione;
    /**
     * fx:id relativo al Label per visualizzare le note relative al socio
     */
    @FXML
    private Label note;

    /**
     * Funzione che visualizza i dati del socio selezionato
     */
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
            while (iterator.hasNext() && !trovato) {
                Soci socio = iterator.next();
                if (socio.getTessera() == idTessera) {
                    trovato = true;
                    this.tessera.setText(Integer.toString(socio.getTessera()));
                    this.nome.setText(socio.getNome());
                    this.cognome.setText(socio.getCognome());
                    this.dataNascita.setText(socio.getNascita() == null ? " " : new SimpleDateFormat("dd-MM-yyyy").format(socio.getNascita()));
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
                    this.dataAnnullamento.setText(socio.getdataAnnullamento() == null ? "" : new SimpleDateFormat("dd-MM-yyyy").format(socio.getdataAnnullamento()));
                    this.dataIscrizione.setText(new SimpleDateFormat("dd-MM-yyyy").format(socio.getDataIscrizione()));
                }
            }
        }
    }

    /**
     * Inizializza gli attributi di classe
     * @param url URL Url relativo al file xml relativo all'interfaccia grafica
     * @param resourceBundle ResourceBundle
     */
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
        LinkedList<Example> trans;
        TableData tableData=new TableData(dbConnection);
        TreeSet<String> setSoci=new TreeSet<>();
        try {
            trans=tableData.getTransazioni("select * from socio","socio");

            for (Example tran : trans) {

                String socioElab = "";
                socioElab += tran.get(0).toString() + " ";
                socioElab += tran.get(4).toString() + " ";
                socioElab += tran.get(3).toString();
                setSoci.add(socioElab);
            }
        } catch (SQLException | EmptySetException e) {
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
        LinkedList<Example> trans;
        try{
            trans=tableData.getTransazioni("select * from socio","socio");

            for (Example tran : trans) {
                Soci socio = new Soci();
                socio.setTessera(Integer.parseInt(tran.get(0).toString()));
                socio.setDataIscrizione(new SimpleDateFormat("yyyy-MM-dd").parse(tran.get(1).toString()));

                if (tran.get(2) != null)
                    socio.setDataApprovazione(new SimpleDateFormat("yyyy-MM-dd").parse(tran.get(2).toString()));

                socio.setCognome(tran.get(3).toString());
                socio.setNome(tran.get(4).toString());
                socio.setNascita(new SimpleDateFormat("yyyy-MM-dd").parse(tran.get(5).toString()));
                socio.setLuogoNascita(tran.get(6).toString());
                socio.setVia(tran.get(7).toString());
                socio.setCitta(tran.get(8).toString());
                socio.setCap(tran.get(9).toString());
                socio.setTelefono(tran.get(10).toString());
                socio.setProvincia(tran.get(11).toString());
                socio.setEmail(tran.get(12).toString());
                if (tran.get(13) != null)
                    socio.setdataAnnullamento(new SimpleDateFormat("yyyy-MM-dd").parse(tran.get(13).toString()));
                socio.setConsenso(tran.get(14).toString());
                socio.setMinorenne(tran.get(15).toString());
                if (tran.get(16) != null)
                    socio.setNote(tran.get(16).toString());
                this.elencoSoci.add(socio);
            }
            dbConnection.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
