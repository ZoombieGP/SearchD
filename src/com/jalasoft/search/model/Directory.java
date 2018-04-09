/*
 * Directory.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.model;
/**
 Class Directory inherit from ASSET and creates Objects with Properties of Directories since a Search has been performed
 * @version  1.0
 * @author Gilmar Pozzo
 */
public class Directory extends Asset{

    private boolean isDirectory;

    /**
     * Directory Method Constructor
     */
    public void Directory (){
    }

    /**
     * isDirectory method returns a boolean true when the attribute of directory is detected
     * @return
     * boolean when search criteria found a directory as match
     */
    public boolean isDirectory() {
        return isDirectory;
    }

    /**
     * setIsDirectory method sets a boolean value true when the serach criteria returns as valida a folder.
     * @param directory
     * Boolean that contains true if it is a folder.
     */
    public void setIsDirectory(boolean directory) {
        isDirectory = directory;
    }
}
