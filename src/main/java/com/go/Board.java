package com.go;

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
    public static final int WHITE = 1;
    public static final int BLACK = 2;
    public static final int EMPTY = 0;

    public Board(){
        this.restart();
    }

    public void restart(){
        this.layout = new int[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                layout[i][j] = EMPTY;
            }
        }  
    }

    public boolean play(int x, int y, boolean isWhite){
        //TODO: Check for validity. If this move is valid, it is played. Else, it is not played.
        if(layout[x][y] != EMPTY){
            return false;
        }

        //Check if this move is invalid (stone dies.)

        //Check for Ko
        
        if(isWhite){
            layout[x][y] = WHITE;
        }
        else{
            layout[x][y] = BLACK;
        }
        return true;
    }
}
