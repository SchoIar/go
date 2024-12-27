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
    private List<int[]> solution; //lists ordered set of moves to solve the puzzle, in format x,y
    private int current;

    public Level(Board board, List<int[]> solution) {
        this.board = board;
        this.solution = solution;
        this.current = 0; 
    }

    public Level(Board board, List<int[]> solution, List<int[]> initialWhiteStone, List<int[]> initialBlackStones) {
        this.board = board;
        this.solution = solution;
        this.current = 0; 

        board.setIntialStones(initialWhiteStone, initialBlackStones);

    }

    /**
     * Checks if current move is the correct move. If so, it can be played, else, level resets.
     * 
     * @param x
     * @param y
     * @param isWhite
     * @return
     */
    public boolean playMove(int x, int y, boolean isWhite){
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

    public void print(){
        board.print();
    }

    public boolean isSolved(){
        return current >= solution.size();
    }

}
