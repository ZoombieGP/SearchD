/*
 * File.java
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
 Class FileSearch inherit form ASSET and creates Objects with Properties of Files since a Search has been performed
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


    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
