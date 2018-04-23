/*
 * SearchQuery.java
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implements the queries methods for get data from Data Base SEARCH
 * @author Brayan Rosas
 * @version 0.1
 * @since 04/8/2018
 */
public class SearchQuery {

    private static Connection con;

    /**
     * Construct method that made the DB connection
     */
    public SearchQuery(){

        con= DBConnection.getInstance().getCon();
    }

    public String addCriteria (String criteriaJSON)
    {
        String query="INSERT INTO SEARCH (ID,CRITERIA)\n" +
                "VALUES (?,?);";
        try {
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setString(2,criteriaJSON);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Criteria cannot be inserted";
        }
        return "The criteria was inserted";
    }

    public ResultSet getAllCriteria() throws SQLException {

            Statement statement=con.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM SEARCH;");
            return resultSet;

    }
}
