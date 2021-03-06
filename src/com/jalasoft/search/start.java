package com.jalasoft.search;
/*
 * Start .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */

import com.jalasoft.search.common.SaveCriteria;
import com.jalasoft.search.common.SearchQuery;
import com.jalasoft.search.controller.Controller;
import com.jalasoft.search.controller.LoggerCreator;
import com.jalasoft.search.controller.SearchCriteria;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.view.Window;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class start {

    public static void main(String [ ] args) {
        LoggerCreator.getInstance().getLogger().info("Enter");
        Search search = new Search();
        Window win =new Window();
        win.setVisible(true);
        Controller controller = new Controller(search,win);
        LoggerCreator.getInstance();
        LoggerCreator.getInstance().getLogger().info("Exit");
    }
}
