/*
 * Checkbox.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 */
package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Checkbox extends JPanel {

    private JCheckBox directoriesOnly;              //Directories Only checkbox
    private JCheckBox fileContent;                  //File Content checkbox
    private JCheckBox hiddenFiles;                  //Hidden Files checkbox
    private JLabel creationDate;                    //Creation Date label
    private JTextField creationDateTextField;       //Creation Date text field
    private JLabel modificationDate;                //Modification Date label
    private JTextField modificationDateTextField;   //Modification Date text field
    private JLabel accessDate;                      //Access Date label
    private JTextField accessDateTextField;         //Access Date text field
    private JLabel owner;                           //Owner label
    private JTextField ownerTextField;              //Owner text field
    private JLabel size;                            //Size label
    private JTextField sizeTextField;               //Size text field
    private JPanel checkPanel1;                     //First panel
    private JPanel checkPanel2;                     //Second panel
    private JComboBox sizeComboBox;                 //Size combo box
    private JComboBox creationDateComboBox;         //Creation Date combo box
    private JComboBox modificationDateComboBox;     //Modification Date combo box
    private JComboBox accessDateComboBox;           //Access Date combo box

    /**
     * Creates the components and add them to respective panels
     * also the alignment is set
     */

    public Checkbox() {
        super(new BorderLayout());
        directoriesOnly = new JCheckBox("Directories Only");
        fileContent = new JCheckBox("File Content");
        hiddenFiles = new JCheckBox("Hidden Files");
        owner = new JLabel("  Owner: ");
        ownerTextField = new JTextField();
        size = new JLabel("  Size (MB): ");
        sizeTextField = new JTextField();
        sizeComboBox = new JComboBox();
        sizeComboBox.addItem("=");
        sizeComboBox.addItem(">");
        sizeComboBox.addItem("<");

        checkPanel1 = new JPanel(new GridLayout(0, 1));
        checkPanel1.add(directoriesOnly);
        checkPanel1.add(fileContent);
        checkPanel1.add(hiddenFiles);
        checkPanel1.add(owner);
        checkPanel1.add(ownerTextField);
        checkPanel1.add(size);
        checkPanel1.add(sizeComboBox);
        checkPanel1.add(sizeTextField);
        checkPanel1.setLayout(new javax.swing.BoxLayout(checkPanel1, BoxLayout.X_AXIS));
        this.add(checkPanel1, BorderLayout.NORTH);

        creationDate = new JLabel("Creation Date: ");
        creationDateTextField = new JTextField(7);
        modificationDate = new JLabel("  Modification Date: ");
        modificationDateTextField = new JTextField(7);
        accessDate = new JLabel("  Access Date: ");
        accessDateTextField = new JTextField(7);
        creationDateComboBox = new JComboBox();
        creationDateComboBox.addItem("=");
        creationDateComboBox.addItem(">");
        creationDateComboBox.addItem("<");
        modificationDateComboBox = new JComboBox();
        modificationDateComboBox.addItem("=");
        modificationDateComboBox.addItem(">");
        modificationDateComboBox.addItem("<");
        accessDateComboBox = new JComboBox();
        accessDateComboBox.addItem("=");
        accessDateComboBox.addItem(">");
        accessDateComboBox.addItem("<");

        checkPanel2 = new JPanel(new GridLayout(0, 1));
        checkPanel2.add(creationDate);
        checkPanel2.add(creationDateComboBox);
        checkPanel2.add(creationDateTextField);
        checkPanel2.add(modificationDate);
        checkPanel2.add(modificationDateComboBox);
        checkPanel2.add(modificationDateTextField);
        checkPanel2.add(accessDate);
        checkPanel2.add(accessDateComboBox);
        checkPanel2.add(accessDateTextField);
        checkPanel2.setLayout(new javax.swing.BoxLayout(checkPanel2, BoxLayout.X_AXIS));
        this.add(checkPanel2, BorderLayout.CENTER);
    }

    /**
     * Get the Creation Date text field
     * @return the current Creation Date text field object
     */
    public String getCreationDateTextField() {
        return creationDateTextField.getText();
    }

    /**
     * Get the Access Date text field
     * @return the current Access Date text field object
     */
    public String getAccessDateTextField() {
        return accessDateTextField.getText();
    }

    /**
     * Get the Modification Date text field
     * @return the current Modification Date text field object
     */
    public String getModificationDateTextField() {
        return modificationDateTextField.getText();
    }

    /**
     * Get the Directories Only checkbox
     * @return the current Directories Only checkbox object
     */
    public JCheckBox getDirectoriesOnly() {
        return directoriesOnly;
    }

    /**
     * Get the File Content checkbox
     * @return the current File Content checkbox object
     */
    public JCheckBox getFileContent() {
        return fileContent;
    }

    /**
     * Get the Hidden Filed checkbox
     * @return the current Hidden Files checkbox object
     */
    public JCheckBox getHiddenFiles() {
        return hiddenFiles;
    }

    /**
     * Get the Owner text field
     * @return the current Owner text field object
     */
    public String getOwnerTextField() {
        return ownerTextField.getText();
    }

    /**
     * Get the Size text field
     * @return the current Size text field object
     */
    public String getSizeTextField() {
        return sizeTextField.getText();
    }

    /**
     * Set the File Content Checkbox
     */
    public void setFileContent(boolean check) {

        this.fileContent.setSelected(check);
    }

    /**
     * Set the Creation Date Text Field
     */
    public void setCreationDateTextField(String text) {
        this.creationDateTextField.setText(text);
    }

    /**
     * Set the Modification Date Text Field
     */
    public void setModificationDateTextField(String text) {
        this.modificationDateTextField.setText(text);
    }

    /**
     * Set the Access Date Text Field
     */
    public void setAccessDateTextField( String text) {
        this.accessDateTextField.setText(text);
    }

    /**
     * Set the Owner Text Field
     */
    public void setOwnerTextField(String text) {
        this.ownerTextField.setText(text);
    }

    /**
     * Set the Size Text Field
     */
    public void setSizeTextField(String text) {
        this.sizeTextField.setText(text);
    }

    /**
     * Set the Size combo box
     */
    public void setSizeComboBox(int option) {
        this.sizeComboBox.setSelectedIndex(option);
    }

    /**
     * Set the Creation Date combo box
     */
    public void setCreationDateComboBox(int option) {
        this.creationDateComboBox.setSelectedIndex(option);
    }

    /**
     * Set the Modification Date combo box
     */
    public void setModificationDateComboBox(int option) {

        this.modificationDateComboBox.setSelectedIndex(option);
    }

    public JComboBox getSizeComboBox() {
        return sizeComboBox;
    }

    public JComboBox getCreationDateComboBox() {
        return creationDateComboBox;
    }

    public JComboBox getModificationDateComboBox() {
        return modificationDateComboBox;
    }

    public JComboBox getAccessDateComboBox() {
        return accessDateComboBox;
    }

    /**
     * Set the Access Date combo box
     */
    public void setAccessDateComboBox( int option) {
        this.accessDateComboBox.setSelectedIndex(option);
    }

    /**
     * Set the Hidden Files Checkbox
     */
    public void setHiddenFiles(boolean check) {
        this.hiddenFiles.setSelected(check);
    }

    /**
     * Set the Directories Only Checkbox
     */
    public void setDirectoriesOnly( boolean check) {
        this.directoriesOnly.setSelected(check);
    }
}
