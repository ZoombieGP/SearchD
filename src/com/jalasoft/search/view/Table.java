package com.jalasoft.search.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Table extends JPanel {

    private String [] columnNames;
    private Object [] [] data;

    public Table(){
        super(new GridLayout(1,0));

        columnNames = new String[]{"Path", "FileName", "Extension", "Creation Date", "Owner"};        //Column Names
        data = new Object[][]{};                                                                      //Table Elements

        /**
         * Table creation and configuration
         */
        final JTable table=new JTable(data ,columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(725, 400));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
