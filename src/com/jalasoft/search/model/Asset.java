/*
 * Asset.java
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
 Class Assert creates Objects with Properties of Files since a Search has been performed
 * @version  1.0
 * @author Gilmar Pozzo
 */
public class Asset {
    private String path;
    private String fileName;
    private String ModificationDate;
    private String CreationDate;
    private String accessDate;
    private String owner;
    private Long size;
    private boolean isHidden;
    private boolean isDirectory;



    public void Asset (){
    }

    /**
     * getPath method returns path value as string
     * @return
     * String path
     */
    public String getPath() {
        return path;
    }

    /**
     * setPath method sets the path value
     * @param path
     * String route of finding files
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * getFileName method returns Name value of directory or file
     * @return
     * String fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * setFileName method sets the fileName value as String
     * @param fileName
     * String that contains the folder or file name.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * getModificationDate method returns as String the last modification date of a file or folder.
     * @return
     * String modificationDate
     */
    public String getModificationDate() {
        return ModificationDate;
    }

    /**
     * setModificationDate method sets as String the last date when Folder or File has been modified
     * @param modificationDate
     * String that contains the modification date.
     */
    public void setModificationDate(String modificationDate) {
        ModificationDate = modificationDate;
    }

    /**
     * getCreationDate method returns as String the creation date of a file or folder
     * @return
     * String that contains the creation date.
     */
    public String getCreationDate() {
        return CreationDate;
    }

    /**
     * setCreationDate method sets as String the creation date of a file or folder
     * @param creationDate
     * String that contains the creation date
     */
    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    /**
     * getAccessDate method returns as String the last date  that a file or folder has been acceded
     * @return
     * String that contains the last access into a file or folder
     */
    public String getAccessDate() {
        return accessDate;
    }

    /**
     * setAccessDate method sets as String the last date when a file or folder has been acceded
     * @param accessDate
     * String that contains the value od last access into a file or folder
     */
    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    /**
     * getOwner method returns as String the owner of file or folder
     * @return
     * STring that contains the Owner of file or folder
     */
    public String getOwner() {
        return owner;
    }

    /**
     * setOwner method sets as String the Owner of file or Folder
     * @param owner
     * String that contains the Owner of filer or folder
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * getSize method returns a Long with the Size of file or Folder
     * @return
     * Long that contains the Size of file or Folder
     */
    public Long getSize() {
        return size;
    }

    /**
     * setSize method sets the file or folder size as Long
     * @param size
     * Long that contains the size of file or folder
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * isHidden method returns boolean value when the file or folder is hidden
     * @return
     * true if file or folder has hidden attribute enabled else false
     */
    public boolean isHidden() {
        return isHidden;
    }

    /**
     * setIsDirectory method sets a boolean value true when the serach criteria returns as valida a folder.
     * @param directory
     * Boolean that contains true if it is a folder.
     */
    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    /**
     * setHidden method sets boolen value true when file or folder has enabled  its hidden attribute
     * @param hidden
     * boolean value for hidden attribute of file or folder.
     */
    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    /**
     * getIsDirectory method returns true if in its attributes isDirectory is true
     * @return
     * treu if it is Folder, and false if it is a file
     */
    public boolean getIsDirectory() {
        return isDirectory;
    }
}
