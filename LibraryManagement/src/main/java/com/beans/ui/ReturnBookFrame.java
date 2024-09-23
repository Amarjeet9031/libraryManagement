package com.beans.ui;

import java.awt.*;
import java.awt.event.*;

public class ReturnBookFrame extends Frame {
    TextField bookNameField = new TextField(20);
    TextField authorNameField = new TextField(20);
    TextField serialNoField = new TextField(20);
    Button returnButton = new Button("Return Book");

    public ReturnBookFrame() {
        setTitle("Return Book");
        setLayout(new FlowLayout());

        add(new Label("Book Name: "));
        add(bookNameField);
        add(new Label("Author Name: "));
        authorNameField.setEditable(false);
        add(authorNameField);
        add(new Label("Serial No: "));
        add(serialNoField);
        add(returnButton);

        returnButton.addActionListener(e -> returnBook());

        setSize(300, 200);
        setVisible(true);
    }

    private void returnBook() {
        String bookName = bookNameField.getText();
        String serialNo = serialNoField.getText();
        // Validate and call DAO to return the book
    }
}
