package com.go;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("Go Game - Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton playButton = new JButton("Play Game");
        playButton.setBounds(300, 200, 200, 50);
        playButton.addActionListener((ActionEvent e) -> {
            dispose();
            new GameScreen();
        });
        add(playButton);

        JButton solvePuzzleButton = new JButton("Solve Puzzle");
        solvePuzzleButton.setBounds(300, 300, 200, 50);
        solvePuzzleButton.addActionListener((ActionEvent e) -> {
            dispose();
            new PuzzleScreen();
        });
        add(solvePuzzleButton);

        setVisible(true);
    }
}
