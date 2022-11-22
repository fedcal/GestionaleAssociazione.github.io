package com.gestionaleonstage.database;

import com.gestionaleonstage.entity.Soci;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DbScript {

    public DbScript(){}

    public void initTable(Connection db){
        String query= " create table if not exists soci(tessera int primary key, data_iscrizione date not null, data_approvazione date not null" +
                ", cognome varchar(50) not null, nome varchar(50) not null, nascita date not null, luogo_nascita varchar(50), indirizzo varchar(150) not null," +
                "citta varchar(50) not null, telefono varchar(15) not null, provincia varchar(50) not null, email varchar(200) not null," +
                "ruolo varchar(30) not null, data_annullamento date, note varchar(500) )";
        try {
            Statement statement=db.createStatement();
            int rs = statement.executeUpdate(query);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;
    }
    public LinkedList<Soci> obtainSoci(Connection db){
        //TODO implement obtainSoci that retrival soci's info from dataabse
        return null;
    }
}
