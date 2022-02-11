package com.company;

import javax.swing.*;
import java.awt.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class mainWindow extends JFrame{

    mainWindow(){
        timeLabel date = new timeLabel();
        timeLabel day = new timeLabel();
        timeLabel time = new timeLabel();
        time.setFont(new Font("Arial", Font.BOLD, 50));

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                date.setText(dateFormat.format(now));
                String currentDay = dayFormat.format(now);
                day.setText(currentDay.substring(0,1).toUpperCase(Locale.ROOT) + currentDay.substring(1));
                time.setText(timeFormat.format(now));

            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        JPanel timePanel = new JPanel();
        timePanel.setBounds(150,50,500,200);
        timePanel.setBackground(Color.black);
        timePanel.setLayout(new GridLayout(3,1));
        timePanel.add(date);
        timePanel.add(time);
        timePanel.add(day);

        startStopperButton button = new startStopperButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("Clock");
        this.setBackground(Color.black);
        this.setLayout(null);

        this.add(timePanel);
        this.add(button);
        this.setVisible(true);
    }
}
