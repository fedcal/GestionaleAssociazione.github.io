package com.gestionaleonstage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe di supporto per la connessione al database
 */
public class DbConnection {
    /** Driver esterno per la gestione del database*/
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    /** Nome del DBMS**/
    private final String DBMS = "jdbc:mysql";
    /**Contiene l'identificativo del server su cui risiede la base di dati*/
    private final String SERVER = "localhost";
    /**Contiene il nome della base di dati*/
    private final String DATABASE = "associazione";
    /**La porta su cui il DBMS MySQL accetta le connessioni*/
    private final int PORT = 3306;
    /**Contiene il nome dell'utente per l'accesso alla base di dati*/
    private final String USER_ID = "root";
    /**Contiene la password di autenticazione per l'utente identificato da USER_ID*/
    private final String PASSWORD = "root";
    /**Connettore al database*/
    private Connection conn;

    /**
     * Costruttore di classe che istanzia la connessione al database. Può generare un'eccezione di tip SQL
     * se non riesce a connettersi o di altro tipo se non riesce a trovare il driver o non ha i permessi per accedere
     */
    public DbConnection(){
        try{
            Class.forName(DRIVER_CLASS_NAME).newInstance();
            String connectionString = this.DBMS + "://" + this.SERVER + ":" + this.PORT + "/" + this.DATABASE
                    + "?user=" + this.USER_ID + "&password=" + this.PASSWORD + "&serverTimezone=UTC";
            this.conn = DriverManager.getConnection(connectionString);
        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo per ottenere la connessione al DB
     * @return Connection
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Metodo per la chiusura della connessione al database e del rilascio delle risorse
     * @throws SQLException Il metodo genera questa eccezione nel caso in cui non riesce a lanciare l'applicazione
     */
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
