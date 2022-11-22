package com.gestionaleonstage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";/** Driver esterno per la gestione del database*/
    private final String DBMS = "jdbc:mysql";
    private final String SERVER = "localhost";/**Contiene l'identificativo del server su cui risiede la base di dati*/
    private final String DATABASE = "associazione";/**Contiene il nome della base di dati*/
    private final int PORT = 3306;/**La porta su cui il DBMS MySQL accetta le connessioni*/
    private final String USER_ID = "root";/**Contiene il nome dell'utente per l'accesso alla base di dati*/
    private final String PASSWORD = "root";/**Contiene la password di autenticazione per l'utente identificato da USER_ID*/
    private Connection conn;/**Gestisce la connessione*/

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

    public Connection getConnection() {
        return this.conn;
    }
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
