package com.gestionaleonstage.test;

import com.gestionaleonstage.database.DbConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    @Test
    public void insert() throws SQLException {
        DbConnection dbConnection=new DbConnection();
        String querySoci= " create table if not exists prova(id int primary key, nome varchar(50), nascita date)";
        Connection db=dbConnection.getConnection();
        Statement statement=db.createStatement();
        int rs = statement.executeUpdate(querySoci);
        rs=statement.executeUpdate("INSERT INTO prova VALUES (18,'Federico',DATE '1998-05-09')");
        dbConnection.closeConnection();
    }
}
