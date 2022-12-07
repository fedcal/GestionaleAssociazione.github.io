package com.gestionaleonstage.database;

import com.gestionaleonstage.exception.EmptySetException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TableData {
    private DbConnection db;

    public TableData(DbConnection db) {
        this.db = db;
    }

    public LinkedList<Example> getTransazioni(String query, String table) throws SQLException, EmptySetException {
        LinkedList<Example> transazioni= new LinkedList<>();
        boolean emptySet=true;
        Statement statement= this.db.getConnection().createStatement();
        ResultSet rs=statement.executeQuery(query);
        TableSchema tSchema = new TableSchema(db, table);
        while(rs.next()){
            emptySet=false;
            Example currentTuple= new Example();
            for (int i=0; i<tSchema.getColumnNumber();i++){
                if(tSchema.getColumn(i).isNumber()){
                    currentTuple.add(rs.getInt(i+1));
                }else if(tSchema.getColumn(i).isVarChar()){
                    currentTuple.add(rs.getString(i+1));
                }else if(tSchema.getColumn(i).isDate()){
                    currentTuple.add(rs.getDate(i+1));
                } else if (tSchema.getColumn(i).isFloater()) {
                    currentTuple.add(rs.getDouble(i+1));
                }
            }
            transazioni.add(currentTuple);
        }
        rs.close();
        statement.close();
        return transazioni;
    }
}
