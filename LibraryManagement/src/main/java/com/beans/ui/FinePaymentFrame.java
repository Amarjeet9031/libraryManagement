package com.beans.ui;

import java.awt.*;
import java.awt.event.*;

public class FinePaymentFrame extends Frame {
    Checkbox finePaidCheckbox = new Checkbox("Fine Paid");
    Button confirmButton = new Button("Confirm");

    public FinePaymentFrame() {
        setTitle("Fine Payment");
        setLayout(new FlowLayout());

        add(finePaidCheckbox);
        add(confirmButton);

        confirmButton.addActionListener(e -> confirmPayment());

        setSize(300, 200);
        setVisible(true);
    }

    private void confirmPayment() {
        // Handle fine payment confirmation logic
    }
}
