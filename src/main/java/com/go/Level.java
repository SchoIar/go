package com.go;
import java.util.List;
/**
 * Represents a specific go puzzle. 
 *
 * @author AI
 * @version 1.0
 */
public class Level {
    private Board board;
    private List<int[]> solution; //lists ordered set of moves to solve the puzzle. 
    private int current;

    public Level(Board board, List<int[]> solution) {
        this.board = board;
        this.solution = solution;
        this.current = 0; 
    }

    public boolean isCorrectMove(int x, int y, boolean isWhite){
        int[] expectedMove = solution.get(current);
        if(x == expectedMove[0] && y == expectedMove[1]){
            board.play(x, y, isWhite);
            current ++;
            return true;
        }

        //reset the level. 
        reset();
        return false;
    }

    public void reset() {
        board.restart();
        current = 0; 
    }

}
