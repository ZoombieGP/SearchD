package com.jalasoft.search;
import com.jalasoft.search.view.Window;
import com.jalasoft.search.controller.SearchCriteriaBasic;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */

public class start {
    public static void main(String [ ] args) {
        Window w=new Window();
        Object[] obj = new Object[] { "a", "b", "c" };
        String path="ddsd;dsds;dsd;";
        SearchCriteriaBasic searchCriteriaBasic=new SearchCriteriaBasic(path,path);
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(searchCriteriaBasic.getPath());
        System.out.println(temp);
    }
}
