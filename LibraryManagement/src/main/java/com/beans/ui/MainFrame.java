package com.beans.ui;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
    public MainFrame() {
        setTitle("Library Management System");
        setSize(600, 400);
        setLayout(new FlowLayout());

        Button loginButton = new Button("Login");
        loginButton.addActionListener(e -> new LoginFrame());
        add(loginButton);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new LoginFrame(); //
    }
}
