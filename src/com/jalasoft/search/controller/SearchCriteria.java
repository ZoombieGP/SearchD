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

    private String criteriaName;
    private String getCriteriaType;
    private String [] criteria;
    private String pathToSearch;
    private boolean isHidden;
    private String content;
    private String extension;
    private long size;
    private int modeSize; //0 for equal, 1 for major than, 2 for minor than
    private String modificationDate;
    private String creationDate;
    private String accessDate;
    private String owner;
    private boolean isDirectory;
    private int modeMdate;
    private int modeCdate;
    private int modeAdate;

    public boolean isDirectory() {
        return isDirectory;
    }

    public int getModeMdate() {
        return modeMdate;
    }

    public int getModeCdate() {
        return modeCdate;
    }

    public int getModeAdate() {
        return modeAdate;
    }

    /**
     * SearchCriteria Constructor
     * Inicialize the path and the text to search(criteria)
     */
    public SearchCriteria(String path , String textToSearch , String extension, String criteriaName){

        this.criteriaName=criteriaName;
        this.getCriteriaType="Basic";
        this.criteria=splitTextToSearch(textToSearch);
        this.pathToSearch=path;
        this.extension=extension;
        this.isHidden=false;
        this.content=null;
        this.size=-1;
        this.modeSize=0;
        this.modificationDate=null;
        this.creationDate=null;
        this.accessDate=null;
        this.isDirectory=false;
    }

    /**
     * Overwrite of construct methos with the search criteria advanced
     * @param path
     * @param searchFor
     * @param isHidden
     * @param content
     * @param extension
     * @param size
     * @param modeSize
     * @param modificationDate
     * @param creationDate
     * @param accessDate
     * @param owner
     */
    public SearchCriteria(String path, String searchFor, boolean isHidden , String content, String extension , long size , int modeSize ,
                          String modificationDate, String creationDate , String accessDate, String owner , boolean isDirectory , int modeMdate ,
                          int modeCdate , int modeAdate , String criteriaName){
        this.criteriaName=criteriaName;
        this.getCriteriaType="Advanced";
        this.pathToSearch=path;
        this.criteria=splitTextToSearch(searchFor);
        this.isHidden=isHidden;
        this.content=content;
        this.extension=extension;
        this.size=size;
        this.modeSize=modeSize;
        this.modificationDate=modificationDate;
        this.creationDate=creationDate;
        this.accessDate=accessDate;
        this.owner=owner;
        this.isDirectory=isDirectory;
        this.modeCdate=modeCdate;
        this.modeMdate=modeMdate;
        this.modeAdate=modeAdate;
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
    public int getModeSize () { return modeSize;}

    /**
     * Get the creation date
     * @return
     */
    public String getCreationDate() {
        return creationDate;
    }

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

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public String getCriteriaName(){ return criteriaName;}

    public String getGetCriteriaType(){ return getCriteriaType;}

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


