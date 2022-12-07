package com.gestionaleonstage.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TableSchema {
    private List<Column> tableSchema=new ArrayList<Column>();
    private HashMap<String,String> mapSQL_JAVATypes=new HashMap<String, String>();

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

    public int getColumnNumber(){
        return this.tableSchema.size();
    }
    public HashMap<String,String> getHashMap(){
        return this.mapSQL_JAVATypes;
    }
    public Column getColumn(int index){
        return tableSchema.get(index);
    }
    public Iterator<Column> iterator() {

        return tableSchema.iterator();
    }
}
