package com.jalasoft.search.common;
import com.google.gson.Gson;
import com.jalasoft.search.controller.SearchCriteriaBasic;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class SaveCriteria {

    public  String SaveCriterias(SearchCriteriaBasic searchCriteriaBasic){
        SearchQuery searchQuery=new SearchQuery();
        Gson gson=new Gson();
        String criteriaString = gson.toJson(searchCriteriaBasic);
        searchQuery.addCriteria(criteriaString);

        return "Success";

    }

    public Map<Integer , SearchCriteriaBasic> getAllData (){
        Map<Integer,SearchCriteriaBasic> searchCriteriaBasicMap = new HashMap<>();
        SearchQuery searchQuery= new SearchQuery();
        ResultSet resultSet=searchQuery.getAllCriteria();
    }
}
