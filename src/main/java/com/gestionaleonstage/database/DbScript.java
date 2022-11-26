package com.gestionaleonstage.database;

import com.gestionaleonstage.entity.Soci;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Classe dedicata agli script per la gestione del database, dalla creazione delle tabelle alla loro modifica ed eliminazione
 */
public class DbScript {
    /**
     * Cotruttore di classe di default
     */
    public DbScript(){}

    /**
     * Inizializzaziione della tabella soci
     * @param db Connection - connessione al db
     */
    public void initTableSoci(Connection db){
        String querySoci= " create table if not exists soci(tessera int primary key, data_iscrizione date not null, data_approvazione date not null" +
                ", cognome varchar(50) not null, nome varchar(50) not null, nascita date not null, luogo_nascita varchar(50), indirizzo varchar(150) not null," +
                "citta varchar(50) not null, telefono varchar(15) not null, provincia varchar(50) not null, email varchar(200) not null," +
                "ruolo varchar(30) not null, data_annullamento date, note varchar(500) )";
        try {
            Statement statement=db.createStatement();
            int rs = statement.executeUpdate(querySoci);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String queryEventi="";

    }

    /**
     * Metodo per ottenere i soci all'interno del database
     * @param db connessione al database
     * @return LinkediList - Lista di soci
     */
    public LinkedList<Soci> obtainSoci(Connection db){
        //TODO implement obtainSoci that retrival soci's info from dataabse
        return null;
    }
}
