package com.go;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.List;

public class PuzzleScreen extends JFrame {
    public PuzzleScreen() {
        setTitle("Solve Puzzle");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Board board = new Board();
        List<int[]> solution = Arrays.asList(
            new int[]{1, 1, Board.WHITE},
            new int[]{0, 1, Board.BLACK},
            new int[]{0, 2, Board.WHITE}
        );
        List<int[]> initialBlack = Arrays.asList(new int[]{0, 0});
        List<int[]> initialWhite = Arrays.asList(new int[]{1, 0});

        Level level = new Level(board, solution, initialWhite, initialBlack);

        PuzzlePanel puzzlePanel = new PuzzlePanel(level); // Custom JPanel for board rendering
        add(puzzlePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
