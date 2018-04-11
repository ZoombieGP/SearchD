package com.jalasoft.search.common;
import org.sqlite.JDBC.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection con;

    private DBConnection(){
        try {
            init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  DBConnection getInstance(){
        if(dbConnection==null)
            dbConnection=new DBConnection();
        return dbConnection;
    }
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:search.db");
        Statement state=con.createStatement();
        state.execute("CREATE TABLE IF NOT EXISTS search " +
                "(ID integer ,criteria varchar(900), " +
                " PRIMARY KEY(ID);");
    }
    public  Connection getCon(){
        return con;
    }
}
