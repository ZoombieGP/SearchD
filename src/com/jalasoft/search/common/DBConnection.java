/*
 * DBConnection.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implements the DB connection using Singleton pattern
 * @author Brayan Rosas
 * @version 0.1
 * @since 04/8/2018
 */
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

    /**
     * Return an instance of DBConnection
     * @return
     */
    public static  DBConnection getInstance(){
        if(dbConnection==null)
            dbConnection=new DBConnection();
        return dbConnection;
    }

    /**
     * Connect with the Db and create the tabale that contents the search criteria
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:search.db");
        Statement state=con.createStatement();
        state.execute("CREATE TABLE SEARCH(\n" +
                "   ID   INT              NOT NULL,\n" +
                "   CRITERIA VARCHAR (90),       \n" +
                "   PRIMARY KEY (ID)\n" +
                ");");
    }

    /**
     * Return the current DB connection
     * @return
     */
    public  Connection getCon(){
        return con;
    }


}
