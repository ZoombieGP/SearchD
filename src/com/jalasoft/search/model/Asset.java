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


    public void Asset (){
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModificationDate() {
        return ModificationDate;
    }

    public void setModificationDate(String modificationDate) {
        ModificationDate = modificationDate;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public boolean isHidden(boolean hidden) {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }


}
