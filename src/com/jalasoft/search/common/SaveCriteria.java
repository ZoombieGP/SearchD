package com.jalasoft.search.common;
import com.google.gson.Gson;
import com.jalasoft.search.controller.SearchCriteriaBasic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SaveCriteria {

    public  String saveCriteria(SearchCriteriaBasic searchCriteriaBasic){
        SearchQuery searchQuery=new SearchQuery();
        Gson gson=new Gson();
        String criteriaString = gson.toJson(searchCriteriaBasic);
        searchQuery.addCriteria(criteriaString);

        return "Success";

    }

    public Map<Integer , SearchCriteriaBasic> getAllData () throws SQLException {
        Map<Integer,SearchCriteriaBasic> searchCriteriaBasicMap = new HashMap<>();
        SearchQuery searchQuery= new SearchQuery();

        ResultSet resultSet=searchQuery.getAllCriteria();
        Gson gson= new Gson();
        while (resultSet.next()){
            SearchCriteriaBasic searchCriteriaBasic= gson.fromJson(resultSet.getString("CRITERIA" ) ,SearchCriteriaBasic.class);
            int id= resultSet.getInt("ID");
            searchCriteriaBasicMap.put(id,searchCriteriaBasic);
        }
        return searchCriteriaBasicMap;

    }
}
