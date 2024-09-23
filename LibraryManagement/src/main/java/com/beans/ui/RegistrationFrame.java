package com.beans.ui;

import java.awt.*;
import java.awt.event.*;
import com.beans.dao.UserDAO;
import com.beans.model.User;

public class RegistrationFrame extends Frame {
    TextField usernameField = new TextField(20);
    TextField passwordField = new TextField(20);
    Button registerButton = new Button("Register");
    Button backButton = new Button("Back");

    public RegistrationFrame() {
        setTitle("User Registration");
        setLayout(new FlowLayout());
        passwordField.setEchoChar('*');

        add(new Label("Username: "));
        add(usernameField);
        add(new Label("Password: "));
        add(passwordField);
        add(registerButton);
        add(backButton);

        registerButton.addActionListener(e -> registerUser());
        backButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setSize(300, 200);
        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Username and Password cannot be empty.");
            return;
        }

        UserDAO userDAO = new UserDAO();
        User existingUser = userDAO.getUserByUsername(username); // Implement this method in UserDAO

        if (existingUser != null) {
            showMessage("Username already exists.");
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Consider hashing the password

        userDAO.save(newUser);
        showMessage("Registration successful! You can now log in.");
        dispose();
        new LoginFrame();
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
