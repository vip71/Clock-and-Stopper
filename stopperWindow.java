package com.company;

import javax.swing.*;
import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;

public class stopperWindow extends JFrame{
    boolean is_stopped = true;
    JLabel stopperText = new JLabel("00:00:00");
    JButton stopButton = new JButton("Start");
    int i = 0;

    stopperWindow(){
        stopButton.setBounds(100,250,150, 50);
        stopButton.setFont(new Font("Arial", Font.BOLD, 30));
        stopButton.setFocusable(false);
        stopButton.addActionListener(e -> startStopTimer());

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(350, 250, 150,50);
        resetButton.setFont(new Font("Arial", Font.BOLD, 30));
        resetButton.setFocusable(false);
        resetButton.addActionListener(e -> reset());


        stopperText.setBounds(100, 50, 400, 150);
        stopperText.setFont(new Font("Arial", Font.BOLD, 40));
        stopperText.setForeground(Color.WHITE);
        stopperText.setBackground(Color.BLACK);
        stopperText.setHorizontalAlignment(JLabel.CENTER);
        stopperText.setOpaque(true);

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                if(!is_stopped){
                    int h = i/3600;
                    int min = (i-3600*h)/60;
                    int sek = i-(3600*h)-(60*min);
                    stopperText.setText(String.format("%02d:%02d:%02d", h, min, sek));
                    i++;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Stopper");
        this.setSize(600,400);
        this.setResizable(false);
        this.add(stopperText);
        this.add(stopButton);
        this.add(resetButton);
        this.setVisible(true);
    }

    private void startStopTimer(){
        if(is_stopped){
            is_stopped = false;
            stopButton.setText("Stop");
        }
        else{
            is_stopped = true;
            stopButton.setText("Start");
        }
    }

    private void reset(){
        is_stopped = false;
        startStopTimer();
        stopperText.setText("00:00:00");
        i = 0;
    }
}
