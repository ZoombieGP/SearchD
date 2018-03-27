package com.jalasoft.search.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search {
    List <File> filterFiles = new ArrayList<File>();
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

    private List <File> searchByContens(List <File> inputFiles, String contens){
        List <File> filterResults = new ArrayList<>();
        if(inputFiles.size() >= 0){
            for (int i = 0; i< inputFiles.size(); i++){
                try {
                       final BufferedReader reader = new BufferedReader(
                                new FileReader(inputFiles.get(i))
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

    private List <File>  searchBySize(List <File> inputFiles, long size){
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

    public void getResults() {
        List <File> swapFiles = new ArrayList<>();
        List <File> swapFilesTemp = new ArrayList<>();
        List <File> swapFilesTemp2 = new ArrayList<>();
        List <File> swapFilesTemp3 = new ArrayList<>();

        swapFiles = searchByPath(new File("c:/test"));
        swapFilesTemp = searchByExtension(swapFiles, "txt");
        swapFilesTemp2 = searchByHidden(swapFilesTemp);
        swapFilesTemp3 = searchByContens(swapFilesTemp2, "POZZO");

        for(int  i = 0; i <swapFilesTemp3 .size(); i ++){
            System.out.println(swapFilesTemp3 .get(i).getAbsolutePath());
        }

    }
}
