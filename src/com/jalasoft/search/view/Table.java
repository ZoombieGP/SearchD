package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.*;

public class Table extends JPanel {

    public Table(){
        super(new GridLayout(1,0));

        String[] columnNames = {"Path",
                "FileName",
                "Extension",
                "Creation Date",
                "Owner"};

        //Crear objecto con resultado

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };
        //........pending
        final JTable table=new JTable(data ,columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }


}
