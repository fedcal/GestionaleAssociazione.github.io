package com.gestionaleonstage.soci;

import com.gestionaleonstage.HomeApplication;
import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.Example;
import com.gestionaleonstage.database.TableData;
import com.gestionaleonstage.entity.Soci;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;


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

    /**
     * Metodo per visualizzare la vista per modificare i soci
     */
    public void modificaSoci( ) {
    }

    /**
     * metodo per l'export dei soci
     */
    public void exportSoci() throws IOException {
        String filePath= "./EstrazioneDati/soci.xlsx";
        FileInputStream inputStream=new FileInputStream(filePath);
        XSSFWorkbook fileExcel=new XSSFWorkbook(inputStream);
        DbConnection dbConnection=new DbConnection();
        TableData tableData=new TableData(dbConnection);
        LinkedList<Example> trans;
        LinkedList<Soci> elencoSoci= new LinkedList<>();
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
                elencoSoci.add(socio);
            }
            dbConnection.closeConnection();
        }catch (Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione!!!\n Non è stato possibile recuperare la lsita dei soci");
            alert.show();
        }
    }
}
