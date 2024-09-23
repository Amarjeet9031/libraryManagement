package com.beans.ui;

import java.awt.*;
import java.awt.event.*;
import com.beans.dao.UserDAO;
import com.beans.model.User;

public class LoginFrame extends Frame {
    TextField usernameField = new TextField(20);
    TextField passwordField = new TextField(20);
    Button loginButton = new Button("Login");
    Button registerButton = new Button("Register");

    public LoginFrame() {
        setTitle("Login");
        setLayout(new FlowLayout());
        passwordField.setEchoChar('*');

        add(new Label("Username: "));
        add(usernameField);
        add(new Label("Password: "));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(e -> validateLogin());
        registerButton.addActionListener(e -> {
            dispose();
            new RegistrationFrame();
        });

        setSize(300, 200);
        setVisible(true);
    }

    private void validateLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Username and Password cannot be empty.");
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username); // Implement this method in UserDAO

        if (user == null || !user.getPassword().equals(password)) {
            showMessage("Invalid username or password.");
            return;
        }

        // Proceed to the main application frame
        else {
            new IssueBookFrame();
        }
    }

    private void showMessage(String message) {
        Dialog dialog = new Dialog(this, "Message", true);
        dialog.add(new Label(message), BorderLayout.CENTER);
        Button okButton = new Button("OK");
        okButton.addActionListener(e -> dialog.dispose());
        dialog.add(okButton, BorderLayout.SOUTH);
        dialog.setSize(300, 150);
        dialog.setVisible(true);
    }
}
