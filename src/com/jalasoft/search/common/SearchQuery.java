package com.jalasoft.search.common;


import java.sql.Connection;

public class SearchQuery {

    private static Connection con;

    public SearchQuery(){

        con= DBConnection.getInstance().getCon();
    }
}
