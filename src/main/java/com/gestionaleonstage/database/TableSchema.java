package com.gestionaleonstage.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Classe per rappresentare lo schema di una tabella presente nel database
 */
public class TableSchema {
    /**
     * Schema contenente le colonne della tabella
     */
    private List<Column> tableSchema=new ArrayList<>();
    /**
     * Map contenente le relazioni tra i tipi in sql e i tipi in java
     */
    private HashMap<String,String> mapSQL_JAVATypes=new HashMap<String, String>();

    /**
     * Costruttore di classe che avvalora l'hashmap e le colonne della tabella
     *
     * @param db DbConnection Connessione al database
     * @param tableName String Nome della tabella di cui si vuole recuperare lo schema
     * @throws SQLException Eccezione lanciata nel caso in cui non si riesca a ricavare lo schema della tabella
     */
    public TableSchema(DbConnection db, String tableName) throws SQLException {


        this.mapSQL_JAVATypes.put("CHAR","string");
        this.mapSQL_JAVATypes.put("VARCHAR","string");
        this.mapSQL_JAVATypes.put("LONGVARCHAR","string");
        this.mapSQL_JAVATypes.put("BIT","string");
        this.mapSQL_JAVATypes.put("SHORT","number");
        this.mapSQL_JAVATypes.put("INT","number");
        this.mapSQL_JAVATypes.put("LONG","number");
        this.mapSQL_JAVATypes.put("FLOAT","number");
        this.mapSQL_JAVATypes.put("DOUBLE","number");
        this.mapSQL_JAVATypes.put("DATE","date");
        Connection con=db.getConnection();
        DatabaseMetaData meta = con.getMetaData();
        ResultSet res = meta.getColumns(null, null, tableName, null);
        while (res.next()) {
            if(mapSQL_JAVATypes.containsKey(res.getString("TYPE_NAME")))
                tableSchema.add(new Column(res.getString("COLUMN_NAME"),mapSQL_JAVATypes.get(res.getString("TYPE_NAME"))));
        }
        res.close();

    }

    /**
     * Costruttore di classe che avvalora l'attributo di classe HasMap
     */
    public TableSchema(){
        this.mapSQL_JAVATypes.put("CHAR","string");
        this.mapSQL_JAVATypes.put("VARCHAR","string");
        this.mapSQL_JAVATypes.put("LONGVARCHAR","string");
        this.mapSQL_JAVATypes.put("BIT","string");
        this.mapSQL_JAVATypes.put("SHORT","number");
        this.mapSQL_JAVATypes.put("INT","number");
        this.mapSQL_JAVATypes.put("LONG","floater");
        this.mapSQL_JAVATypes.put("FLOAT","floater");
        this.mapSQL_JAVATypes.put("DOUBLE","floater");
        this.mapSQL_JAVATypes.put("DATE","date");
    }

    /**
     * Metodo che restituisce la dimensione della lista di colonne
     * @return int numero di colonne presenti all'interno della tabella
     */
    public int getColumnNumber(){
        return this.tableSchema.size();
    }

    /**
     * Restituisce il mapping che mette in correlazione i tipi dei valori in SQL con quelli di java
     * @return HashMap {@literal <String,String>}
     */
    public HashMap<String,String> getHashMap(){
        return this.mapSQL_JAVATypes;
    }

    /**
     * Restituisce la colonna relativa a una determinata posizione all'interno dello schema
     * @param index int Posizione della colonna da restituire
     * @return Column La colonna con i relativi valori
     */
    public Column getColumn(int index){
        return tableSchema.get(index);
    }

    /**
     * Restituisce un iteratore sulla lista di colonne
     * @return Iterator {@literal <Column>}
     */
    public Iterator<Column> iterator() {

        return tableSchema.iterator();
    }
}
