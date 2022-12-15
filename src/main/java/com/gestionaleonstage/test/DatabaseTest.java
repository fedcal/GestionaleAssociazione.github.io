package com.gestionaleonstage.test;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.Example;
import com.gestionaleonstage.database.TableData;
import com.gestionaleonstage.database.TableSchema;
import com.gestionaleonstage.exception.EmptySetException;
import org.junit.Test;

import java.sql.*;
import java.util.LinkedList;

/**
 * Classe per testare le funzionalità legate al database
 */
public class DatabaseTest {
    /**
     * Test relativo all'inserimento di un socio all'interno del database
     * @throws SQLException può generare un eccezione di tipo SQL
     */
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

    /**
     * Test relativo alle informazioni che si possono ottenere dallo schema di una tabella recuperata dal database
     * @throws SQLException può generare un eccezione di tipo SQL
     */
    @Test
    public void schema() throws SQLException{
        DbConnection dbConnection=new DbConnection();
        TableSchema tableSchema=new TableSchema();
        System.out.println(tableSchema.getHashMap().toString());

        Connection connection=dbConnection.getConnection();
        DatabaseMetaData meta= connection.getMetaData();
        ResultSet resultSet= meta.getColumns(null,null,"socio",null);
        while (resultSet.next()){
            System.out.println("Name column: "+resultSet.getString("COLUMN_NAME")+" Type: "+resultSet.getString("TYPE_NAME"));
        }

        dbConnection.closeConnection();
    }

    /**
     * Test relativo alle transazioni ottenute dalla tabella del database
     * @throws SQLException può generare un eccezione di tipo SQL
     * @throws EmptySetException eccezione generata se la tabella non contiene transazioni
     */
    @Test
    public void getTransazioniTest() throws SQLException, EmptySetException {
        LinkedList<Example> trans=new LinkedList<>();
        DbConnection dbConnection=new DbConnection();
        TableData tableData=new TableData(dbConnection);

        trans=tableData.getTransazioni("select * from socio","socio");
        TableSchema tableSchema=new TableSchema(dbConnection,"socio");
        for(int i=0; i< trans.size();i++){
            System.out.println("Socio");
            for(int j=0; j<tableSchema.getColumnNumber();j++){
                System.out.println(trans.get(i).get(j));
            }
            System.out.println();
        }
        dbConnection.closeConnection();
    }

    @Test
    public void dbConvertType() throws SQLException, EmptySetException {
        LinkedList<Example> trans=new LinkedList<>();
        DbConnection dbConnection=new DbConnection();
        TableData tableData=new TableData(dbConnection);
        trans=tableData.getTransazioni("select * from socio","socio");
        for(int i=0; i< trans.size();i++){
           System.out.println("i "+i+": "+Integer.parseInt(trans.get(i).get(0).toString()));
        }
    }
}
