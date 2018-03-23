package com.jalasoft.search.controller;

public class SearchCriteriaBasic {

    private String [] criteria;
    private String pathToSearch;


    public SearchCriteriaBasic(String textToSearch){
        this.criteria=splitTextToSearch(textToSearch);

    }

    private String [] splitTextToSearch(String textToSearch){

        String [] criterias=textToSearch.split(";");
        return criterias;
    }
}
