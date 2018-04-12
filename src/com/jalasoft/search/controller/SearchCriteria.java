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
 * SearchCriteria: Construct a basic search criteria
 * @author Brayan Rosas
 * @version 0.1
 * @since 03/25/2018
 */
public class SearchCriteria {

    private String [] criteria;
    private String pathToSearch;
    private boolean isHidden;
    private String content;
    private String extension;
    private long size;
    private int mode; //0 for equal, 1 for major than, 2 for minor than
    private String modificationDate;
    private String creationDate;
    private String accessDate;
    private String owner;


    /**
     * SearchCriteria Constructor
     * Inicialize the path and the text to search(criteria)
     */
    public SearchCriteria(String path , String textToSearch){

        this.criteria=splitTextToSearch(textToSearch);
        this.pathToSearch=path;
    }

    /**
     * Overwrite of construct methos with the search criteria advanced
     * @param path
     * @param searchFor
     * @param isHidden
     * @param content
     * @param extension
     * @param size
     * @param mode
     * @param modificationDate
     * @param creationDate
     * @param accessDate
     * @param owner
     */
    public SearchCriteria(String path, String searchFor, boolean isHidden , String content, String extension , long size , int mode , String modificationDate, String creationDate , String accessDate, String owner){
        this.pathToSearch=path;
        this.criteria=splitTextToSearch(searchFor);
        this.isHidden=isHidden;
        this.content=content;
        this.extension=extension;
        this.size=size;
        this.mode=mode;
        this.modificationDate=modificationDate;
        this.creationDate=creationDate;
        this.accessDate=accessDate;
        this.owner=owner;

    }

    /**
     * Get the path
     * @return the path of file
     */
    public String getPath(){ return pathToSearch; }

    /**
     * Get the criteria(textToSearch)
     * @return the criteria
     */
    public String[] getCriteria(){ return criteria; }

    /**
     * Get the the hidden flase or true
     * @return
     */
    public boolean getIsHidden(){ return isHidden; }

    /**
     * Get the content
     * @return
     */
    public String getContent()  { return content;}

    /**
     * Get the extension
     * @return
     */
    public String getExtension()  { return extension;}

    /**
     * Get the size in bytes
     * @return
     */
    public long getSize()  { return size;}

    /**
     * Get the mode
     * @return
     */
    public int getMode () { return mode;}

    /**
     * Get the creation date
     * @return
     */
    public String getCreationDate() {return creationDate;}

    /**
     * Get the modification date
     * @return
     */
    public String getModificationDate() {return modificationDate;}

    /**
     * Get the creation date
     * @return
     */
    public String getAccessDate() {return accessDate;}

    /**
     * Get the owner name
     * @return
     */
    public String getOwner() {return owner;}

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


