package com.jalasoft.search.model;

public class FactoryAsset {

    public static Asset createAsset(int id, String path, String fileName, String modificationDate, String creationDate, String accessDate, String owner, Long size, boolean isHidden, boolean isDirectory, String extension, String content){
        Asset asset = null;
        if(id == 0) { //Directory
            asset = new Directory();
            if(asset instanceof Directory){

                asset.setPath(path);
                asset.setFileName(fileName);
                asset.setModificationDate(modificationDate);
                asset.setCreationDate(creationDate);
                asset.setAccessDate(accessDate);
                asset.setOwner(owner);
                asset.setSize(size);
                asset.setHidden(isHidden);
                asset.setDirectory(isDirectory);
            }
        }
        if (id == 1){ //FileSearch
            asset = new FileSearch();
            if (asset instanceof FileSearch){
                asset.setPath(path);
                asset.setFileName(fileName);
                asset.setModificationDate(modificationDate);
                asset.setCreationDate(creationDate);
                asset.setAccessDate(accessDate);
                asset.setOwner(owner);
                asset.setSize(size);
                asset.setHidden(isHidden);
                asset.setDirectory(isDirectory);
                ((FileSearch) asset).setExtension(extension);
                ((FileSearch) asset).setContent(content);
            }
        }
        return(asset);
    }
}
