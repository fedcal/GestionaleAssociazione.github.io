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
     * Costruttore di classe di default
     */
    public DbScript(){}

    /**
     * Inizializzazione della tabella soci
     * @param db Connection - connessione al db
     */
    public void initTableSoci(Connection db) throws SQLException {

        //SOCI
        String querySoci= " create table if not exists socio(tessera int primary key, data_iscrizione date not null, data_approvazione date" +
                ", cognome varchar(50) not null, nome varchar(50) not null, nascita date not null, luogo_nascita varchar(50), via varchar(150) not null," +
                "citta varchar(50) not null,cap varchar(10), telefono varchar(15) not null, provincia varchar(50) not null, email varchar(200) not null," +
                "data_annullamento date, consenso varchar(5), minorenne varchar(5),note varchar(500) )";

        Statement statement=db.createStatement();
        int rs = statement.executeUpdate(querySoci);
/*
        //EVENTI
        String queryEventi="create table if not exists eventi(idEventi int primary key, nome varchar(50) notnot null, descrizione varchar(50) not null)";
        rs=statement.executeUpdate(queryEventi);

        //EVENTI CREATI
        String queryEventiCreati="create table if not exists eventiCreati(idCreato int primary key, idEvento int not null, data date not null, foreign key (idEvento) references eventi(idEvento))";
        rs=statement.executeUpdate(queryEventiCreati);

        //PARTECIPAZIONE
        String queryPartecipazione="create table if not exists partecipazione(idPartecipazione int primary key, idCreato int, idSocio int, foreign key (idCreato) references eventiCreati(idCreato), foreign key (idSocio) referencies soci(tessera))";
        rs=statement.executeUpdate(queryPartecipazione);

        //FATTURE
        String queryFatture="create table if not exists fatture(idFattura int primary key, mittente varchar(50) not null, destinatario varchar(50) not null, data date not null, importo float(10,2))";
        rs=statement.executeUpdate(queryFatture);

        //SCONTRINO
        String queryScontrini="create table if not exists scontrini(idScontrino int primary key not null, data date not null, mittente varchar(50))";

        //COSTI EVENTII
        String queryCostiEventi="create table if not exists costiEventi(idCosto int primary key, idEventoCreato int not null, data date not null, descrizione varchar(500), costo float(10,2) not null, idFattura int not null, scontrino int not null, foreign key (idEventoCreato) references eventiCreati(idCreato),foreign key (idFattura) references fatture(idFattura)";
        rs=statement.executeUpdate(queryCostiEventi);*/
    }

    /**
     * Metodo per eseguire query sul db che inseriscono, modificano o elimina alcuni campi nel database
     * @param query String query sql da eseguire
     * @param db Connection connessione al database
     * @return boolean Se la query è stata eseguita
     * @throws SQLException può lanciare questa eccezione se la query non viene eseguita correttamente
     */
    public boolean triggerQuery(String query, Connection db) throws SQLException {
        boolean queryDone=false;
        Statement statement=db.createStatement();
        int rs = statement.executeUpdate(query);
        if(rs==1){
            return queryDone=true;
        }else{
            return queryDone;
        }
    }
}
