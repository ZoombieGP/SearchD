/*
 * FileSearch.java
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
 Class FileSearch inherit from ASSET and creates Objects with Properties of Files since a Search has been performed
 * @version  1.0
 * @author Gilmar Pozzo
 */
public class FileSearch extends Asset{
    private String extension;
    private String content;
    /**
     * FileSearch Method Constructor
     */
    public void FileSearch (){}

    /**
     * getExtension method returns the extension of some file
     * @return
     * String that contains the extension of file
     */
    public String getExtension() {
        return extension;
    }

    /**
     * setExtension method sets the value of extension of a file
     * @param extension
     * String that contains the extension of a file
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * getContens method returns a String with search criteria value
     * @return
     * String that contains the search criteria
     */
    public String getContent() {
        return content;
    }

    /**
     * setContains method, sets the content search criteria as string
     * @param content
     * String that contains the search criteria
     */
    public void setContent(String content) {
        this.content = content;
    }
}
