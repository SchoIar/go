package com.go;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the go board.
 *
 * @author AI
 * @version 1.0
 */
public class Board {
    /**
     * Maps 0 to empty space, 1 maps to white, 2 maps to black.
     * in format [x, y] where 0,0 is the bottom left corner.
     * 
     */
    private int[][] layout;
    private List<int[]> initialWhite; 
    private List<int[]> initialBlack; 
    public static final int WHITE = 1;
    public static final int BLACK = 2;
    public static final int EMPTY = 0;
    private static final int BOARD_SIZE = 8;

    public Board() {
        this.layout = new int[BOARD_SIZE][BOARD_SIZE];
        this.initialWhite = new ArrayList<>();
        this.initialBlack = new ArrayList<>();
        emptyBoard();
    }

    public void setIntialStones(List<int[]> whiteStones, List<int[]> blackStone){
        this.initialBlack = blackStone;
        this.initialWhite = whiteStones;
        restart();
    }

    private void emptyBoard(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                layout[i][j] = EMPTY;
            }
        }
    }

    public void restart() {
        emptyBoard();

        for (int[] stone : initialWhite) {
            layout[stone[0]][stone[1]] = WHITE;
        }

        for (int[] stone : initialBlack) {
            layout[stone[0]][stone[1]] = BLACK;
        }
    }

    public boolean play(int x, int y, boolean isWhite) {
        // TODO: Check for validity. If this move is valid, it is played. Else, it is
        // not played.
        if (layout[x][y] != EMPTY) {
            return false;
        }

        // Check if this move is invalid (stone dies.)

        // Check for Ko

        if (isWhite) {
            layout[x][y] = WHITE;
        } else {
            layout[x][y] = BLACK;
        }
        return true;
    }

    public int getStoneAt(int x, int y) {
        return layout[x][y];
    }

    public void print() {
        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < BOARD_SIZE; j++) {

                if (layout[i][j] == WHITE) {
                    System.out.print("W ");
                } else if (layout[i][j] == BLACK) {
                    System.out.print("B ");
                } else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
