package com.go;
import java.util.List;
import javax.swing.SwingUtilities;        
/**
 * Represents a specific go puzzle. 
 *
 * @author AI
 * @version 1.0
 */
public class Level {
    private Board board;
    private List<int[]> solution; //lists ordered set of moves to solve the puzzle, in format x,y, isWhite
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

    // Add validation elsewhere
    // private boolean validateSoln(List<int[]> solution){
    //     int prevColor = 3;
    //     for(int[] move : solution){
    //         int color = move[2];
    //         if(prevColor != color){
    //             prevColor = color;
    //         } else{ //error, two repeated moves. 
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /**
     * Checks if current move is the correct move. If so, it can be played, else, level resets.
     * Plays move for current color, and subsequent follow up move for next.
     * 
     * @param x
     * @param y
     * @param isWhite
     * @return
     */
    public boolean playMove(int x, int y, boolean isWhite){
        if(isSolved()){
            SwingUtilities.invokeLater(() -> new StartScreen());

        }
        int[] expectedMove = solution.get(current);
        if(x == expectedMove[0] && y == expectedMove[1]){
            board.play(x, y, isWhite);
            current ++;

            if (current < solution.size()) {
                int[] opponentMove = solution.get(current);
                board.play(opponentMove[0], opponentMove[1], !isWhite);
                current ++;
            }

            if(isSolved())
                System.out.println("SOLVED"); 

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

    public int getStoneAt(int x, int y){
        return board.getStoneAt(x, y);
    }

}
