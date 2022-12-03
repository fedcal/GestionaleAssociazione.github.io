package com.gestionaleonstage.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class TableData {
    private DbConnection db;

    public enum QUERY_TYPE{
        MIN,MAX
    }
    public TableData(DbConnection db){
        this.db=db;
    }

    public List<Rows> getTransazioni(String table) throws SQLException{
        LinkedList<Rows> tranSet= new LinkedList<Rows>();
        Statement statement;
        TableSchema tSchema= new TableSchema(db,table);
        String query="select * from "+table;
        statement = this.db.getConnection().createStatement();
        ResultSet rs=statement.executeQuery(query);
        boolean empty=true;
        while(rs.next()){
            empty=false;
            Rows row= new Rows();
            for(int i=0;i<tSchema.getNumberOfAttributes();i++){
                if(tSchema.getColumn(i).isNumber()){
                    row.add(rs.getDouble(i+1));
                } else if (tSchema.getColumn(i).isDate()) {
                    row.add(rs.getDate(i+1));
                } else if (tSchema.getColumn(i).isString()) {
                    row.add(rs.getString(i+1));
                }
            }
        }
        rs.close();
        statement.close();
        return tranSet;
    }
}
