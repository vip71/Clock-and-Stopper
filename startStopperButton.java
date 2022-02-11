package com.company;

import javax.swing.*;
import java.awt.*;

public class startStopperButton extends JButton {
    startStopperButton(){
        this.setText("Open stopper");
        this.setFont(new Font("Arial", Font.BOLD, 25));
        this.setBounds(300, 300, 200, 75);
        this.addActionListener(e -> openStopper());
        this.setFocusable(false);
    }

    private void openStopper(){
        new stopperWindow();
    }
}
