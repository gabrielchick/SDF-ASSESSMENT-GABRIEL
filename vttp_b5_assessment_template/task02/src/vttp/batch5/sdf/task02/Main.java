package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Usage: java tictactoe.Main <filename>");
            return; 
        }

        String filename = args[0]; 
      
        char[][] board = readBoard(filename);
        if (board == null) { 
            System.out.println("Failed to read board from file.");
            return; 
        }

        // map for utility
        Map<String, Integer> utility = evaluateUtility(board);

        // key-value pair for position and utility
        for (Map.Entry<String, Integer> entry : utility.entrySet()) {
            System.out.println(entry.getKey() + ", utility=" + entry.getValue());
        }
    }

    // read board config file
    private static char[][] readBoard(String filename) {
        char[][] board = new char[3][3]; 
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename)); 
            for (int i = 0; i < 3; i++) { 
                String line = br.readLine(); 
                board[i] = line.toCharArray(); 
            }
            br.close(); 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return board;
    }

    // evaluate the utility of placing X
    public static Map<String, Integer> evaluateUtility(char[][] board) {
        Map<String, Integer> utility = new HashMap<>(); 
        List<int[]> emptyPositions = getEmptyPos(board); 

        // loop through each empty position and save score
        for (int[] pos : emptyPositions) {
            char[][] newBoard = cloneBoard(board); 
            newBoard[pos[0]][pos[1]] = 'X'; 
            int score = evaluateBoard(newBoard); 
            utility.put("y=" + pos[0] + ", x=" + pos[1], score); 
        }

        return utility; 
    }

    // check for empty positions, then add to list
    private static List<int[]> getEmptyPos(char[][] board) {
        List<int[]> emptyPositions = new ArrayList<>(); 
        for (int i = 0; i < board.length; i++) { 
            for (int j = 0; j < board[i].length; j++) { 
                if (board[i][j] == '.') { 
                    emptyPositions.add(new int[] { i, j }); 
                }
            }
        }
        return emptyPositions; 
    }

    // clone current board
    private static char[][] cloneBoard(char[][] board) {
        char[][] newBoard = new char[3][3]; 
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 3; j++) { 
                newBoard[i][j] = board[i][j]; 
            }
        }
        return newBoard; 
    }
    // method to check for 3 in a row win condition
      private static boolean isLine(char a, char b, char c) {
        return (a == b && b == c && a != '.'); 
    }
    // method to check for win conditions
    private static int evaluateBoard(char[][] board) {
        // vertical and horizontal checks
        for (int i = 0; i < 3; i++) {
            if (isLine(board[i][0], board[i][1], board[i][2])) {
                return board[i][0] == 'X' ? 1 : -1;
            
            }
            if (isLine(board[0][i], board[1][i], board[2][i])) {
                return board[0][i] == 'X' ? 1 : -1; 
            }
        }

        // check for diagonal line
        if (isLine(board[0][0], board[1][1], board[2][2])) {
            return board[1][1] == 'X' ? 1 : -1;
        }
        if (isLine(board[0][2], board[1][1], board[2][0])) {
            return board[1][1] == 'X' ? 1 : -1; 
        }

        // checking 2 O and 1 SPACE
        for (int i = 0; i < 3; i++) {
            if (isTwoCircles(board[i][0], board[i][1], board[i][2])) {
                return -1; // Return -1 if this condition is met
            }
            if (isTwoCircles(board[0][i], board[1][i], board[2][i])) {
                return -1; // Check columns too
            }
        }
        if (isTwoCircles(board[0][0], board[1][1], board[2][2])) {
            return -1; // Check first diagonal
        }
        if (isTwoCircles(board[0][2], board[1][1], board[2][0])) {
            return -1; // Check second diagonal
        }

        return 0; 
    }

    private static boolean isTwoCircles(char a, char b, char c) {
        return (a == 'O' && b == 'O' && c == '.') ||
                (a == 'O' && c == 'O' && b == '.') ||
                (b == 'O' && c == 'O' && a == '.'); // Return true if condition is met
    }

  
}

//high-level pseudocode to determine the utility of a position
//tttboard = read board config file
//empty_pos := tttboard.get_all_empty_pos()
//utility := map
//for every pos in empty_pos, begin
//	new_board clone tttboard
// 	new_tttboard.place(X, pos)
// 	evaluate horizontal, vertical, and diagonal rows on new_tttboard
// 		if there are 3 X
// 			utility[pos] := 1
// 		else if there are 2 O and 1 SPACE 
// 			utility[pos] :=-1
// 		else
// 			utility[pos] := 0
//end

//expected output
//y=0, x=0, utility=0
//y=0, x=1, utility=-1
//y=2, x=1, utility=-1
//y=2, x=2, utility=1



