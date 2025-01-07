package com.go;

import javax.swing.*;
import java.awt.BorderLayout;

public class GameScreen extends JFrame {
    public GameScreen() {
        setTitle("Go Game");
        setSize(900, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Board board = new Board();
        GamePanel boardPanel = new GamePanel(board); // Custom JPanel for board rendering
        add(boardPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
