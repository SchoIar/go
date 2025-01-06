package com.go;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Play Go, 2: Play Go Puzzles ");
        int choice = scanner.nextInt();
        if(choice == 1){
            playGo();
        }
        else{
            playPuzzle();
        }

        scanner.close();

    }

    private static void playGo(){
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        int i = 0, x, y;
        while(true){
            System.out.println("Enter X,Y values for current play");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if(board.play(x, y, i % 2 == 0)){
                board.print();
                i++;
                continue;
            } //invalid move - try again
            System.out.println("invalid move, try again");

            if(x == -1){
                scanner.close();
                break;
            }
        }
        
    }


    private static void playPuzzle(){
        Board board = new Board();

        List<int[]> solution = Arrays.asList(
            new int[]{0, 1, Board.WHITE}
        );

        List<int[]> initialWhite = Arrays.asList(
            new int[]{1, 0}  // White stone at (1, 1)
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