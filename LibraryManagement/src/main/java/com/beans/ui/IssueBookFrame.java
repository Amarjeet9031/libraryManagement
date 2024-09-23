package com.beans.ui;

import java.awt.*;
import java.awt.event.*;
import com.beans.dao.BookDAO;
import com.beans.model.Book;

public class IssueBookFrame extends Frame {
    TextField bookNameField = new TextField(20);
    TextField authorNameField = new TextField(20);
    Button issueButton = new Button("Issue Book");

    public IssueBookFrame() {
        setTitle("Issue Book");
        setLayout(new FlowLayout());

        add(new Label("Book Name: "));
        add(bookNameField);
        add(new Label("Author Name: "));
        authorNameField.setEditable(false);
        add(authorNameField);
        add(issueButton);

        issueButton.addActionListener(e -> issueBook());

        setSize(300, 200);
        setVisible(true);
    }

    private void issueBook() {
        String bookName = bookNameField.getText();
        // Populate author name and validate the form
        // Call DAO to issue the book
    }
}
