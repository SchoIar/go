package com.go;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        List<int[]> solution = Arrays.asList(
            new int[]{0, 1, Board.WHITE}
        );

        List<int[]> initialWhite = Arrays.asList(
            new int[]{1, 1}  // White stone at (1, 1)
        );

        List<int[]> initialBlack = Arrays.asList(
            new int[]{0, 0}
        );
        
        Level level = new Level(board, solution, initialWhite, initialBlack);
        
        level.print();

        if(level.isSolved()){
            System.out.println("1: Solved");
        } else{
            System.out.println("1: Not Solved");
        }
        int x = 0; int y = 0;

        level.playMove(x, y, true);

        if(level.isSolved()){
            System.out.println("2: Solved");
        } else{
            System.out.println("2: Not Solved");
        }

        level.playMove(x, y, true);

        if(level.isSolved()){
            System.out.println("3: Solved");
        } else{
            System.out.println("3: Not Solved");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (x y): ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println("You entered move: (" + x + ", " + y + ")");
        scanner.close();

        level.playMove(x, y, true);

        level.print();
        
        if(level.isSolved()){
            System.out.println("4: Solved");
        } else{
            System.out.println("4: Not Solved");
        }
        
    }
}