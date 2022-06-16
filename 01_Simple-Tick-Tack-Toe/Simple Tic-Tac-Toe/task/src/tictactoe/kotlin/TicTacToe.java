package tictactoe.kotlin;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    final char DASH = '-';
    final char PLEAT = '|';
    final char SPACE = ' ';
    final int COLS = 8;
    final int ROWS = 4;
    final Scanner scanner = new Scanner(System.in);

    ArrayList<ArrayList<Character>> boardList;

    public void startTicTacToeGame() {
        boardList = createBoard(getUserInput());
        printGameBoard(boardList);
    }

    private String getUserInput() {
        System.out.print("Enter cells: ");
        return scanner.nextLine();
    }

    private ArrayList<ArrayList<Character>> createBoard(String input) {
        int index = 0;
        char[] inputArray = input.toCharArray();
        ArrayList<ArrayList<Character>> boardList = new ArrayList<>();
        for (int i = 0; i <= ROWS; i++) {
            ArrayList<Character> listRow = new ArrayList<>();
            for (int j = 0; j <= COLS; j++) {
                if (i == 0 || i == ROWS) {
                    listRow.add(DASH);
                } else if (j == 0 || j == COLS) {
                    listRow.add(PLEAT);
                } else if (j % 2 == 0) {
                    listRow.add(inputArray[index++]);
                } else {
                    listRow.add(SPACE);
                }
            }
            boardList.add(listRow);
        }
        return boardList;
    }

    private void printGameBoard(ArrayList<ArrayList<Character>> boardList) {
        for (ArrayList<Character> characters : boardList) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private String[] findVerticalGame(ArrayList<ArrayList<Character>> boardList) {

    }

    private String[] findHorizontalGame(ArrayList<ArrayList<Character>> boardList) {

    }

    private String[] findDiagonalGame(ArrayList<ArrayList<Character>> boardList) {
        
    }
}
