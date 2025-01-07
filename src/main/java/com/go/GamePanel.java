package com.go;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private final Board board;

    public GamePanel(Board board) {
        this.board = board;

        // Add mouse listener for clicks
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellWidth = getWidth() / Board.BOARD_SIZE;
                int cellHeight = getHeight() / Board.BOARD_SIZE;

                // map clicks to coords
                int x = e.getX() / cellWidth;
                int y = Board.BOARD_SIZE - 1 - (e.getY() / cellHeight); // Flip y-axis (for 0,0 is bottom left)
                board.play(x, y); 
                board.print();
                System.out.println("");
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellWidth = getWidth() / Board.BOARD_SIZE;
        int cellHeight = getHeight() / Board.BOARD_SIZE;

        // Drawing Grid (board)
        g.setColor(Color.BLACK);
        for (int i = 0; i <= Board.BOARD_SIZE; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }

        // Draw Stones
        for (int x = 0; x < Board.BOARD_SIZE; x++) {
            for (int y = 0; y < Board.BOARD_SIZE; y++) {
                int stone = board.getStoneAt(x, y);
                if (stone == Board.WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x * cellWidth + cellWidth / 4, (Board.BOARD_SIZE - 1 - y) * cellHeight + cellHeight / 4, cellWidth / 2, cellHeight / 2);
                } else if (stone == Board.BLACK) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x * cellWidth + cellWidth / 4, (Board.BOARD_SIZE - 1 - y) * cellHeight + cellHeight / 4, cellWidth / 2, cellHeight / 2);
                }
            }
        }
    }
}
