/*
 * SearchCriteriaBasic .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.controller;

/**
 * SearchCriteriaBasic: Construct a basic search criteria
 * @author Brayan Rosas
 * @version 0.1
 * @since 03/25/2018
 */
public class SearchCriteriaBasic {

    private String [] criteria;
    private String pathToSearch;


    /**
     * SearchCriteriaBasic Constructor
     * Inicialize the path and the text to search(criteria)
     */
    public SearchCriteriaBasic(String path ,String textToSearch){

        this.criteria=splitTextToSearch(textToSearch);
        this.pathToSearch=path;
    }

    /**
     * Get the path
     * @return the path of file
     */
    public String getPath(){
        return pathToSearch;
    }

    /**
     * Get the criteria(textToSearch)
     * @return the criteria
     */
    public String[] getCriteria(){
        return criteria;
    }

    /**
     * Split the criteris by ";"
     * @param textToSearch
     * @return String array of criterias
     */
    private String [] splitTextToSearch(String textToSearch){
        String [] criteria=textToSearch.split(";");
        return criteria;
    }
}

