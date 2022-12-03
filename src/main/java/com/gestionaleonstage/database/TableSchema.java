package com.gestionaleonstage.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TableSchema implements Iterable<Column>{
    private List<Column> tableSchema=new ArrayList<Column>();

    public TableSchema(DbConnection db, String tableName) throws SQLException{
        HashMap<String,String> mapSqlType= new HashMap<String, String>();
        mapSqlType.put("CHAR","string");
        mapSqlType.put("VARCHAR","string");
        mapSqlType.put("LONGVARCHAR","string");
        mapSqlType.put("BIT","string");
        mapSqlType.put("SHORT","number");
        mapSqlType.put("INT","number");
        mapSqlType.put("LONG","number");
        mapSqlType.put("FLOAT","number");
        mapSqlType.put("DOUBLE","number");
        mapSqlType.put("DATE","date");
        Connection con=db.getConnection();
        DatabaseMetaData meta = con.getMetaData();
        ResultSet res = meta.getColumns(null, null, tableName, null);

        while(res.next()){
            if(mapSqlType.containsKey(res.getString("TYPE_NAME"))) {
                this.tableSchema.add(new Column(res.getString("COLUMN_NAME"), mapSqlType.get(res.getString("TYPE_NAME"))));
            }
        }
        res.close();
    }
    /**
     *Metodo che restituisce il numero di colonne del database
     * @return Rappreseta il numero di colonne, e quindi di attributi discreti o continui, presenti nella tabella del database
     */
    public int getNumberOfAttributes(){
        return tableSchema.size();
    }
    /**
     * Restituisce la colonna del database idicizzata dal parametro in input
     * @param index indice della colonna che si vuole
     * @return Column
     */
    public Column getColumn(int index){
        return tableSchema.get(index);
    }

    public Iterator<Column> iterator() {

        return tableSchema.iterator();
    }

}
