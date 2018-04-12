/*
 * Search.java
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

import com.jalasoft.search.controller.SearchCriteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Searches Files by content, extension, name, and some other attributes receives a Object Criteria, evaluates it and returns a list of  fileSearch Object.
 * @version  1.0
 * @author Gilmar Pozzo
 */


public class Search {

     /**
     * searchByPath method, returns recursively a List of Paths of all files that belongs to giving Path
     * @param path
     * input initial Path where the search is recovering Folders and files
     * @return
     * a List of Path
     */
    private List <Path> searchByPath(Path path){
        List<Path> files = new ArrayList<>();
        try (DirectoryStream <Path> directoryStream = Files.newDirectoryStream (path)){
            for (Path subPath: directoryStream){
                if(Files.isDirectory(subPath)){
                    files.add(subPath);
                    searchByPath(subPath);
                }else {
                    files.add(subPath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return(files);
    }

    /**
     * searchByName method, searches into a List of Paths specific files giving a file Name and returns a filtered List of Path
     * @param inputFiles
     * receives a list of Path
     * @param fileName
     * Filter criteria
     * @return
     * List of Path filtered by file name criteria
     */
    private List <Path> searchByName(List <Path> inputFiles, String fileName){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).getFileName().toFile().getName().contains(fileName)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchByHidden method, searches into a List of Path specific files that have Hidden attribute enabled and returns List of Path
     * @param inputFiles
     * receives a list of Path
     * @return
     * List of Path filtered by Hidden attribute criteria
     */
    private List <Path> searchByHidden(List <Path> inputFiles){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).toFile().isHidden()){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchByContent method, searches into a file that belongs to List of Path finding out for an specific String and returns List of Path
     * @param inputFiles
     * receives a list of Path
     * @param content
     * receives a search criteria
     * @return
     * List of Path filtered by Contend attribute criteria
     */
    private List <Path> searchByContent(List <Path> inputFiles, String content){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                try {
                       final BufferedReader reader = new BufferedReader(
                                new FileReader((inputFiles.get(i).toFile()))
                        );
                        String line = "";
                        while((line = reader.readLine())!= null){
                            if(line.indexOf(content)!= -1){
                                filterResults.add(inputFiles.get(i));
                            }
                        }
                        reader.close();
                    } catch (FileNotFoundException e) {e.printStackTrace();
                    } catch (IOException e) {e.printStackTrace();}
                }
            }
            return(filterResults);
        }

    /**
     * searchByExtension method searches into a List of Path specific file that have an specific extension and returns List of Path
     * @param inputFiles
     * receives a list of Path
     * @param extension
     * receives a search criteria
     * @return
     * List of Path filtered by Extension criteria
     */
    private List <Path> searchByExtension(List <Path> inputFiles, String extension){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).toFile().getName().endsWith(extension)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchBySize method searches into a List of Path specific files that have an specific size , major and minor then returns a List of Path
     * @param inputFiles
     * receives a list of Path
     * @param size
     * receives a search criteria
     * @param mode
     * 0 for equal, 1 for major than, 2 for minor than
     * @return
     * List of Path filtered by Size criteria
     */
    private List <Path> searchBySize(List <Path> inputFiles, long size, int mode){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if (mode == 0){ // equal than
                    if(inputFiles.get(i).toFile().length() == size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
                if (mode == 1){ // major than
                    if(inputFiles.get(i).toFile().length() >= size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
                if (mode == 2){ // minor than
                    if(inputFiles.get(i).toFile().length() <= size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
            }
        }
        return (filterResults);
    }

    /**
     * dateToString method changes Dates to String
     * @param attDate
     * input Date as file attribute
     * @return
     * a String with yyyy-dd-MM format
     */
    private String dateToString(FileTime attDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        String dateToCompare = dateFormat.format(attDate.toMillis());
        return (dateToCompare);
    }

    /**
     * searchByModificationDate method searches into a List of Path specific files that have an modification date and returns List of Path
     * @param inputFiles
     * receives a list of Path
     * @param modification
     * receives a search criteria
     * @return
     * List of Path filtered by modification date criteria
     */
    private List <Path> searchByModificationDate(List <Path> inputFiles, String modification) throws IOException {
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                BasicFileAttributes attributes = Files.readAttributes(inputFiles.get(i), BasicFileAttributes.class);
                FileTime attDate = attributes.lastModifiedTime();
                String dateToCompare = dateToString(attDate);
                if(dateToCompare.equals(modification)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchByCreationDate method searches into a List of Path specific files that have an specifc creation date and returns List of Path
     * @param inputFiles
     * receives a list of Paths
     * @param date
     * receives a search criteria
     * @return
     * List of Path filtered by creation date criteria.
     * @throws IOException
     * in case there is not a file with search criteria.
     */
    private List <Path> searchByCreationDate(List <Path> inputFiles, String date) throws IOException {
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                BasicFileAttributes attributes = Files.readAttributes(inputFiles.get(i), BasicFileAttributes.class);
                FileTime attDate = attributes.creationTime();
                String dateToCompare = dateToString(attDate);
                if(dateToCompare.equals(date)){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchByAccessDate method searches into a List of Path specific files that have an specifc access date and returns List of Path
     * @param inputFiles
     * receives a list of Paths
     * @param access
     * receives a search criteria
     * @return
     * List of Path filtered by access date criteria.
     * @throws IOException
     * in case there is not a file with search criteria.
     */
    private List <Path> searchByAccessDate(List <Path> inputFiles, String access) throws IOException {
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                BasicFileAttributes attributes = Files.readAttributes(inputFiles.get(i), BasicFileAttributes.class);
                FileTime attDate = attributes.lastAccessTime();
                String dateToCompare = dateToString(attDate);
                if(dateToCompare.equals(access)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * searchByOwner method searches into a List of Path specific files that have an specifc owner and returns List of Path
     * @param inputFiles
     * receives a list of Paths
     * @param owner
     * receives a search criteria
     * @return
     * @throws IOException
     * in case there is not a file with search criteria.
     */
    private List <Path> searchByOwner(List <Path> inputFiles, String owner) throws IOException {
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                UserPrincipal ownerP = Files.getOwner(inputFiles.get(i));
                String userName = ownerP.getName();
                if(userName.equals(owner)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    /**
     * fillAsset method sets all properties of files than acommplish with search criteria
     * @param inputFiles
     * receives a list of Paths
     * @return
     */
    private List<Asset> fillAsset (List <Path> inputFiles) throws IOException {
        List<Asset> matchs = new ArrayList<>();
        if(inputFiles.size()>= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                if(inputFiles.get(i).toFile().isDirectory()){
                    Directory addDirectory = new Directory();
                    addDirectory.setPath(inputFiles.get(i).toFile().getPath());
                    addDirectory.setFileName(inputFiles.get(i).toFile().getName());
                    addDirectory.setDirectory(inputFiles.get(i).toFile().isDirectory());
                    addDirectory.setSize(inputFiles.get(i).toFile().length());
                    addDirectory.setHidden(inputFiles.get(i).toFile().isHidden());
                    UserPrincipal ownerP = Files.getOwner(inputFiles.get(i));
                    String userName = ownerP.getName();
                    addDirectory.setOwner(userName);
                    BasicFileAttributes attributes = Files.readAttributes(inputFiles.get(i), BasicFileAttributes.class);
                    FileTime attDate = attributes.lastAccessTime();
                    FileTime modDate = attributes.lastModifiedTime();
                    FileTime creationDate = attributes.creationTime();
                    addDirectory.setAccessDate(dateToString(attDate));
                    addDirectory.setModificationDate(dateToString(modDate));
                    addDirectory.setCreationDate(dateToString(creationDate));
                    matchs.add(addDirectory);
                }else{
                    FileSearch addFile = new FileSearch();
                    addFile.setPath(inputFiles.get(i).toFile().getPath());
                    addFile.setFileName(inputFiles.get(i).toFile().getName());
                    addFile.setHidden(inputFiles.get(i).toFile().isHidden());
                    addFile.setSize(inputFiles.get(i).toFile().length());
                    addFile.setHidden(inputFiles.get(i).toFile().isHidden());
                    addFile.setDirectory(false);
                    UserPrincipal ownerP = Files.getOwner(inputFiles.get(i));
                    String userName = ownerP.getName();
                    addFile.setOwner(userName);
                    BasicFileAttributes attributes = Files.readAttributes(inputFiles.get(i), BasicFileAttributes.class);
                    FileTime attDate = attributes.lastAccessTime();
                    FileTime modDate = attributes.lastModifiedTime();
                    FileTime creationDate = attributes.creationTime();
                    addFile.setAccessDate(dateToString(attDate));
                    addFile.setModificationDate(dateToString(modDate));
                    addFile.setCreationDate(dateToString(creationDate));
                    matchs.add(addFile);
                }
            }
        }
        return (matchs);
    }
    /**
     * getResults method under construction to test the functionality of Search Class
     */
    public List<Asset> getResults(SearchCriteria criteria) throws IOException {
        Path path = Paths.get(criteria.getPath());
        String fileName = criteria.getCriteria()[0];
        List <Path> swapFiles ;
        List <Path> swapFilesTemp;
        List<Asset> results = null;

        if(fileName.equals("")){
            swapFiles = searchByPath(path);
            try {
                results = fillAsset(swapFiles);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            swapFiles = searchByPath(path);
            swapFilesTemp = searchByName(swapFiles, fileName);
            results = fillAsset(swapFilesTemp);
        }
        return (results);
    }


}
