package com.beans.ui;

import java.awt.*;
import java.awt.event.*;

public class MembershipFrame extends Frame {
    TextField membershipNumberField = new TextField(20);
    Button addButton = new Button("Add Membership");
    Button updateButton = new Button("Update Membership");

    public MembershipFrame() {
        setTitle("Membership Management");
        setLayout(new FlowLayout());

        add(new Label("Membership Number: "));
        add(membershipNumberField);
        add(addButton);
        add(updateButton);

        addButton.addActionListener(e -> addMembership());
        updateButton.addActionListener(e -> updateMembership());

        setSize(300, 200);
        setVisible(true);
    }

    private void addMembership() {
        // Handle adding membership logic
    }

    private void updateMembership() {
        // Handle updating membership logic
    }
}
