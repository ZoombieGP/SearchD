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

import com.jalasoft.search.controller.SearchCriteriaBasic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Class Searches Files by content, extension, name, and some other attributes receives a Object Criteria, evaluates it and return and Object.
 * @version  1.0
 * @author Gilmar Pozzo
 */


public class Search {
    List <File> filterFiles = new ArrayList<File>();

    /**
     * SearchByPath2 method, returns a List of Files, Folders,, sub Folder giving a initial Path
     * @param path
     * input initial Path where the search is recovering Folders and files
     * @return
     * a List of Files
     */
    private List <Path> searchByPath2(Path path){
        List<Path> files = new ArrayList<>();
        try (DirectoryStream <Path> directoryStream = Files.newDirectoryStream (path)){
            for (Path subPath: directoryStream){
                if(Files.isDirectory(subPath)){
                    files.addAll(searchByPath2(subPath));
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

    private List <File> searchByPath(File dir){
        File listFile[] = dir.listFiles();
        if(listFile.length >= 0){
                for (int i = 0; i< listFile.length; i++){
                    if(listFile[i].isDirectory()){
                        filterFiles.add(listFile[i]);
                        searchByPath(listFile[i]);
                    }else{
                        filterFiles.add(listFile[i]);
                    }
                }
            }
        return (filterFiles);
    }

    /**
     * searchByName method, searches into a List of Files specific ones giving a FileSearch Name and return a filter List of Files
     * @param inputFiles
     * receives a list of Files
     * @param fileName
     * Filter criteria
     * @return
     * List of Files filtered by file name criteria
     */
    private List <Path> searchByName2(List <Path> inputFiles, String fileName){
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

    private List <File> searchByName(List <File> inputFiles, String fileName){
       List <File> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).getName().contains(fileName)){
                    filterResults.add(inputFiles.get(i));
                }
            }
        }
        return (filterResults);
    }

    /**
     *searchByHidden method, searches into a List of Files specific ones that have Hidden attribute enabled and return List of Files
     * @param inputFiles
     * receives a list of Files
     * @return
     * List of Files filtered by Hidden atribute criteria
     */
    private List <Path> searchByHidden2(List <Path> inputFiles){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).getFileName().toFile().isHidden()){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }
    private List <File> searchByHidden(List<File> inputFiles){
        List <File> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                if(inputFiles.get(i).isHidden()){
                    filterResults.add(inputFiles.get(i));
                }
            }
        }
        return (filterResults);
    }

    /**
     *searchByContens method, searches into a file that belongs to List of Files finding out an specific String and return List of Files
     * @param inputFiles
     * receives a list of Path Files
     * @param contens
     * receives a search criteria
     * @return
     * List of Files filtered by Contens atribute criteria
     */
    private List <Path> searchByContens(List <Path> inputFiles, String contens){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                try {
                       final BufferedReader reader = new BufferedReader(
                                new FileReader((inputFiles.get(i).toFile()))
                        );
                        String line = "";
                        while((line = reader.readLine())!= null){
                            if(line.indexOf(contens)!= -1){
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
     *searchByExtension method searches into a List of Files specific ones that have an specific extension and return List of Files
     * @param inputFiles
     * receives a list of Files
     * @param extension
     * receives a search criteria
     * @return
     * List of Files filtered by Extension criteria
     */
    private List <Path> searchByExtension2(List <Path> inputFiles, String extension){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(inputFiles.get(i).endsWith(extension)){
                    filterResults.add(inputFiles.get(i).toAbsolutePath());
                }
            }
        }
        return (filterResults);
    }

    private List <File> searchByExtension(List <File> inputFiles, String extension){
        List <File> filterResults = new ArrayList<>();
        if(inputFiles.size()>= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                if(inputFiles.get(i).getName().endsWith(extension)){
                    filterResults.add(inputFiles.get(i));
                }
            }
        }
        return (filterResults);
    }

    /**
     *searchBySize method searches into a List of Files specific ones that have an specific size and return List of Files
     * @param inputFiles
     * receives a list of Files
     * @param size
     * receives a search criteria
     * @return
     * List of Files filtered by Size criteria
     */
    private List <Path> searchBySize2 (List <Path> inputFiles, long size, int mode){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if (mode == 0){ // equal
                    if(inputFiles.get(i).toFile().length() == size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
                if (mode == 1){ // major
                    if(inputFiles.get(i).toFile().length() >= size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
                if (mode == 2){ // minor
                    if(inputFiles.get(i).toFile().length() <= size){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
            }
        }
        return (filterResults);
    }
    private List <File> searchBySize(List <File> inputFiles, long size){
        List <File> filterResults = new ArrayList<>();
        if(inputFiles.size() >=0 ){
            for (int i = 0; i< inputFiles.size(); i++){
                if(inputFiles.get(i).length() == size){
                    filterResults.add(inputFiles.get(i));
                }
            }
        }
        return (filterResults);
    }

    /**
     *searchByModificationDate method searches into a List of Files specific ones that have an modification date and return List of Files
     * @param inputFiles
     * receives a list of Files
     * @param modification
     * receives a search criteria
     * @return
     * List of Files filtered by modification date criteria
     */
    private List <Path> searchByModificationDate2(List <Path> inputFiles, long modification, int mode){
        List <Path> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i < inputFiles.size(); i++){
                if(mode == 0 ){ // equals
                    if(inputFiles.get(i).toFile().lastModified() == modification){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
                if(mode == 1 ){ // major
                    if(inputFiles.get(i).toFile().lastModified() >= modification){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }

                if(mode == 2 ){ // minor
                    if(inputFiles.get(i).toFile().lastModified() <= modification){
                        filterResults.add(inputFiles.get(i).toAbsolutePath());
                    }
                }
            }
        }
        return (filterResults);
    }

    private List <File> searchByModificationDate(List <File> inputFiles, long modification){
        List <File> filterResults = new ArrayList<>();
        if(inputFiles.size()>= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                if(inputFiles.get(i).lastModified() == modification) {
                    filterResults.add(inputFiles.get(i));
                }
            }
        }
        return (filterResults);
    }

    private List<FileSearch> fillFile (List <File> inputFiles){
        List<FileSearch> matchs = new ArrayList<>();
        if(inputFiles.size()>= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                FileSearch addFile = new FileSearch();
                addFile.setPath(inputFiles.get(i).getPath());
                addFile.setName(inputFiles.get(i).getName());
                addFile.setIsDirectory(inputFiles.get(i).isDirectory());
                addFile.setIsHidden(inputFiles.get(i).isHidden());
                addFile.setSize(inputFiles.get(i).length());
                addFile.setDateModification(inputFiles.get(i).lastModified());
                matchs.add(addFile);
            }
        }
        return (matchs);
    }
    /**
     * getResults method under construction to test the functionality of Search Class
     */
    //public List<FileSearch> getResults(SearchCriteriaBasic criteria) {
      public void getResults() {
        Path path = Paths.get("src/com/jalasoft/search/resources/test");
        List<Path> swap = new ArrayList<>();
        List<Path> results = new ArrayList<>();
        swap = searchByPath2(path);
        results = searchByName2(swap, "tcs");
        for(int i = 0; i < results.size(); i ++){
            System.out.println(results.get(i).toAbsolutePath());
            System.out.println(results.get(i).getFileName());

        }
       /* String path = criteria.getPath();
        String fileName = criteria.getCriteria()[0];

        List <File> swapFiles = new ArrayList<>();
        List <File> swapFilesTemp = new ArrayList<>();
        List <FileSearch> results = new ArrayList<>();

        if(fileName.equals("")){
            swapFiles = searchByPath(new File(path));
            results = fillFile(swapFiles);
        }else{
            swapFiles = searchByPath(new File(path));
            swapFilesTemp = searchByName(swapFiles, fileName);
            results = fillFile(swapFilesTemp);
        }
        return (results);
*/
    }
}
