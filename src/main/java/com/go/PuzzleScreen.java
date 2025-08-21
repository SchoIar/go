package com.go;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.List;

public class PuzzleScreen extends JFrame {
    public PuzzleScreen() {
        setTitle("Solve Puzzle");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load puzzles from DB
        List<PuzzleLoader.PuzzleData> puzzles = PuzzleLoader.loadAllPuzzles();
        if (puzzles.isEmpty()) {
            System.out.println("ERROR: no puzzles found in db");
            System.exit(1);
        }

        // load first puzzle. TODO: Change to random or something? or selection? 
        PuzzleLoader.PuzzleData puzzle = puzzles.get(0);
        Level level = puzzle.level;
        boolean playerToMoveIsWhite = puzzle.playerIsWhite;

        PuzzlePanel puzzlePanel = new PuzzlePanel(level, playerToMoveIsWhite);
        add(puzzlePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
