package com.jalasoft.search.common;
import com.google.gson.Gson;
import com.jalasoft.search.controller.SearchCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SaveCriteria {

    public  String saveCriteria(SearchCriteria searchCriteriaBasic){
        SearchQuery searchQuery=new SearchQuery();
        Gson gson=new Gson();
        String criteriaString = gson.toJson(searchCriteriaBasic);
        searchQuery.addCriteria(criteriaString);

        return "Success";

    }

    public Map<Integer , SearchCriteria> getAllData () throws SQLException {
        Map<Integer,SearchCriteria> searchCriteriaBasicMap = new HashMap<>();
        SearchQuery searchQuery= new SearchQuery();

        ResultSet resultSet=searchQuery.getAllCriteria();
        Gson gson= new Gson();
        while (resultSet.next()){
            SearchCriteria searchCriteriaBasic= gson.fromJson(resultSet.getString("CRITERIA" ) ,SearchCriteria.class);
            int id= resultSet.getInt("ID");
            searchCriteriaBasicMap.put(id,searchCriteriaBasic);
        }
        return searchCriteriaBasicMap;

    }
}
