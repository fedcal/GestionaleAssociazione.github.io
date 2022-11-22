package com.gestionaleonstage;

import com.gestionaleonstage.database.DbConnection;
import com.gestionaleonstage.database.DbScript;

import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        DbConnection dbConnection=new DbConnection();
        DbScript dbScript=new DbScript();
        dbScript.initTable(dbConnection.getConnection());
        HomeApplication.main(args);
        try {
            dbConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
