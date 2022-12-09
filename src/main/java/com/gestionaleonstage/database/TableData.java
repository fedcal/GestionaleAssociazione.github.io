package com.gestionaleonstage.database;

import com.gestionaleonstage.exception.EmptySetException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


/**
 * Classe che racchiude tutti gli elementi di una tabella
 */
public class TableData {
    /**
     * Connessione al database
     */
    private DbConnection db;

    /**
     * Costruttore di classe che valorizza l'attributo di classe
     * @param db DbConnection rappresentante la connessione al database
     */
    public TableData(DbConnection db) {
        this.db = db;
    }

    /**
     * Metodo per ottenere tutte le transazioni di una tabella
     * @param query String rappresentante la query da eseguire
     * @param table String rappresentante il nome della tabella di cui bisogna ottenere lo schema
     * @return LinkedList {@literal <Example>} lista di Example rappresentante ogni riga della tabella
     * @throws SQLException Genera un SQLException se la query non viene eseguita correttamente
     * @throws EmptySetException Genera un EmptySetException se la tabella è vuota
     */
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
