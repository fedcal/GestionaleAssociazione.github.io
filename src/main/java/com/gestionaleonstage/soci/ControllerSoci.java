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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        DbConnection dbConnection=new DbConnection();
        TableData tableData=new TableData(dbConnection);
        LinkedList<Example> trans;
        LinkedList<Soci> elencoSoci= new LinkedList<>();

        //Ottenere i soci
        try{
            trans=tableData.getTransazioni("select * from socio","socio");

            for (Example tran : trans) {
                Soci socio = new Soci();
                socio.setTessera(Integer.parseInt(tran.get(0).toString()));
                System.out.println("Tessera: "+socio.getTessera());

                socio.setDataIscrizione(tran.get(1).toString());
                System.out.println("DataIscrizione: "+socio.getDataIscrizione());

                if (tran.get(2) != null)
                    socio.setDataApprovazione(tran.get(2).toString());
                System.out.println("DataApprovazione: "+socio.getDataApprovazione());

                socio.setCognome(tran.get(3).toString());
                System.out.println("Cognome: "+socio.getCognome());

                socio.setNome(tran.get(4).toString());
                System.out.println("Nome: "+socio.getNome());

                socio.setNascita(tran.get(5).toString());
                System.out.println("DataNscita: "+socio.getNascita());

                socio.setLuogoNascita(tran.get(6).toString());
                System.out.println("LuogoNascita: "+socio.getLuogoNascita());

                socio.setVia(tran.get(7).toString());
                System.out.println("Via: "+socio.getVia());

                socio.setCitta(tran.get(8).toString());
                System.out.println("Citta: "+socio.getCitta());

                socio.setCap(tran.get(9).toString());
                System.out.println("CAP: "+socio.getCap());

                socio.setTelefono(tran.get(10).toString());
                System.out.println("telefono: "+socio.getTelefono());

                socio.setProvincia(tran.get(11).toString());
                System.out.println("provincia: "+socio.getProvincia());

                socio.setEmail(tran.get(12).toString());
                if (tran.get(13) != null)
                    socio.setdataAnnullamento(tran.get(13).toString());


                System.out.println("Data annullamento: "+socio.getdataAnnullamento());

                socio.setConsenso(tran.get(14).toString());
                System.out.println("Consenso: "+socio.getConsenso());

                socio.setMinorenne(tran.get(15).toString());
                System.out.println("Consenso: "+socio.getMinorenne());
                if (tran.get(16) != null)
                    socio.setNote(tran.get(16).toString());
                System.out.println("Note: "+socio.getNote());
                System.out.println(socio);
                elencoSoci.add(socio);
               // System.out.println("===============");
            }
            dbConnection.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione!!!\n Non è stato possibile recuperare la lista dei soci");
            alert.show();
        }

        try {

            String filePath= "./EstrazioneDati/soci.xlsx";
            FileOutputStream outputStream=new FileOutputStream(filePath);
            XSSFWorkbook workbook= new XSSFWorkbook();
            XSSFSheet sheet= workbook.createSheet("Sheet1");
            //Create excel
            //1. riga header
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue("Tessera");
            cell = row.createCell(1);
            cell.setCellValue("Data Iscrizione");
            cell = row.createCell(2);
            cell.setCellValue("Data Approvazione");
            cell = row.createCell(3);
            cell.setCellValue("Cognome");
            cell = row.createCell(4);
            cell.setCellValue("Nome");
            cell = row.createCell(5);
            cell.setCellValue("Data di nascita");
            cell = row.createCell(6);
            cell.setCellValue("Luogo di nascita");
            cell = row.createCell(7);
            cell.setCellValue("Indirizzo");
            cell = row.createCell(8);
            cell.setCellValue("Città di residenza");
            cell = row.createCell(9);
            cell.setCellValue("Cap");
            cell = row.createCell(10);
            cell.setCellValue("Telefono");
            cell = row.createCell(11);
            cell.setCellValue("Provincia");
            cell = row.createCell(12);
            cell.setCellValue("Email");
            cell = row.createCell(13);
            cell.setCellValue("Consenso");
            cell = row.createCell(14);
            cell.setCellValue("Minorenne");
            cell = row.createCell(15);
            cell.setCellValue("Note");
            cell = row.createCell(16);
            cell.setCellValue("Data Annullamento");

            // Ciclo for per inserire i dati dalla lista all'interno del database
            for (int r = 1; r <= elencoSoci.size(); r++) {

                row = sheet.createRow(r);

                cell = row.createCell(0);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(1);
                cell.setCellValue(elencoSoci.get(r - 1).getDataIscrizione());

                if (elencoSoci.get(r - 1).getDataApprovazione() != null) {
                    cell = row.createCell(2);
                    cell.setCellValue(elencoSoci.get(r - 1).getTessera());
                } else {
                    cell = row.createCell(2);
                    cell.setCellValue("");
                }

                cell = row.createCell(3);
                cell.setCellValue(elencoSoci.get(r - 1).getCognome());

                cell = row.createCell(4);
                cell.setCellValue(elencoSoci.get(r - 1).getNome());

                cell = row.createCell(5);
                cell.setCellValue(elencoSoci.get(r - 1).getNascita());

                cell = row.createCell(6);
                cell.setCellValue(elencoSoci.get(r - 1).getLuogoNascita());

                cell = row.createCell(7);
                cell.setCellValue(elencoSoci.get(r - 1).getVia());

                cell = row.createCell(8);
                cell.setCellValue(elencoSoci.get(r - 1).getCitta());

                cell = row.createCell(9);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(10);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(11);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(12);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(13);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(14);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(15);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(16);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());

                cell = row.createCell(17);
                cell.setCellValue(elencoSoci.get(r - 1).getTessera());
            }
            workbook.write(outputStream);
            outputStream.close();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("File excel creato correttamente.");
            alert.show();
        }catch (Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Attenzione. Errore nella creazione dell'excel.");
            alert.show();

        }

    }
}
