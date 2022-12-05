package com.gestionaleonstage;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.DbScript;

import java.sql.SQLException;

/**
 * Classe di supporto per la creazione del jar. Istanzia la connessione al DB e avvia l'appicazione
 */
public class Launcher {
    /**
     * Main della classe all'interno del quale evengono effettuate tutte le operazioni preliminari per avviiare l'applicazione
     * @param args argomenti dell'applicazione
     */
    public static void main(String[] args) throws SQLException {

        DbConnection dbConnection=new DbConnection();
        DbScript dbScript=new DbScript();
        dbScript.initTableSoci(dbConnection.getConnection());
        try {
            dbConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        HomeApplication.main(args);

    }
}
