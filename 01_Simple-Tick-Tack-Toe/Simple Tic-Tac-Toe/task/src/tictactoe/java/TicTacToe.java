package tictactoe.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    final char DASH = '-';
    final char PLEAT = '|';
    final char SPACE = ' ';
    final char OU = 'O';
    final char EX = 'X';
    final int COLS = 8;
    final int ROWS = 4;
    final int TWO = 2;
    final Scanner scanner = new Scanner(System.in);
    final List<Integer> indexCol = List.of(2, 4, 6);
    final List<Integer> indexRow = List.of(1, 2, 3);

    List<List<Character>> boardList;
    boolean firstPlayer = true;

    public void startTicTacToeGame() {
        boolean endGame = false;
        boardList = createEmptyBoard();
        printGameBoard(boardList);
        do {
            List<String> coordinates = getCoordinates();
            if (checkCoordinates(coordinates)) {
                printGameBoard(boardList);
                if (checkGame(boardList)) {
                    endGame = true;
                } else {
                    firstPlayer = !firstPlayer;
                }
            }
        } while (!endGame);
    }

    private List<List<Character>> createEmptyBoard() {
        List<List<Character>> boardList = new ArrayList<>();
        for (int i = 0; i <= ROWS; i++) {
            List<Character> listRow = new ArrayList<>();
            for (int j = 0; j <= COLS; j++) {
                if (i == 0 || i == ROWS) {
                    listRow.add(DASH);
                } else if (j == 0 || j == COLS) {
                    listRow.add(PLEAT);
                } else {
                    listRow.add(SPACE);
                }
            }
            boardList.add(listRow);
        }
        return boardList;
    }

    private boolean checkGame(List<List<Character>> boardList) {
        boolean endGame = false;
        List<Character> vertical = findVerticalGame(boardList);
        List<Character> horizontal = findHorizontalGame(boardList);
        char diagonal = findDiagonalGame(boardList);
        boolean empty = findEmptySpace(boardList);

        boolean winner = vertical.size() == TWO || horizontal.size() == TWO || diagonal != SPACE;
        boolean twoGames = vertical.size() > TWO || horizontal.size() > TWO;

        if (winner) {
            char winnerChar = diagonal;
            if (vertical.size() == TWO) {
                winnerChar = vertical.get(1);
            } else if (horizontal.size() == TWO) {
                winnerChar = horizontal.get(1);
            }
            System.out.println(winnerChar + " wins");
            endGame = true;
        } else if (twoGames || !empty) {
            System.out.println("Draw");
            endGame = true;
        }
        return endGame;
    }

    private List<String> getCoordinates() {
        System.out.print("Enter the coordinates: ");
        return List.of(scanner.nextLine().split(" "));
    }

    private boolean checkCoordinates(List<String> coordinates) {
        int numX;
        int numY;
        boolean validCoord = false;
        List<Integer> converted = convertCoordinatesToInteger(coordinates);
        if (!converted.isEmpty()) {
            numX = converted.get(0);
            numY = converted.get(1);
            if (indexRow.contains(numX) && numY >= 1 && numY <= 3) {
                numY = indexCol.get(numY - 1);
                if (boardList.get(numX).get(numY) == SPACE) {
                    setPlayInBoardList(numX, numY);
                    validCoord = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        } else {
            System.out.println("You Should enter numbers!");
        }
        return validCoord;
    }

    private List<Integer> convertCoordinatesToInteger(List<String> coordinates) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers.add(Integer.parseInt(coordinates.get(0)));
            numbers.add(Integer.parseInt(coordinates.get(1)));
        } catch (Exception ignored) {}
        return numbers.size() == TWO ? numbers : new ArrayList<>();
    }

    private void setPlayInBoardList(int numX, int numY) {
        char simbol = firstPlayer ? EX : OU;
        for (int i = 0; i < boardList.size(); i++) {
            for (int j = 0; j < boardList.get(i).size(); j++) {
                if (i == numX && j == numY) {
                    boardList.get(numX).set(numY, simbol);
                }
            }
        }
    }

    private void printGameBoard(List<List<Character>> boardList) {
        for (List<Character> characters : boardList) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private List<Character> findVerticalGame(List<List<Character>> boardList) {
        char firstChar;
        List<Character> charArray = new ArrayList<>();
        charArray.add(SPACE);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                firstChar = boardList.get(indexRow.get(i)).get(indexCol.get(j));
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(indexRow.get(i) + 1).get(indexCol.get(j))) {
                        if (firstChar == boardList.get(indexRow.get(i) + 2).get(indexCol.get(j))) {
                            charArray.add(firstChar);
                        }
                    }
                }
            }
        }
        return charArray;
    }

    private List<Character> findHorizontalGame(List<List<Character>> boardList) {
        char firstChar;
        List<Character> charArray = new ArrayList<>();
        charArray.add(SPACE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                firstChar = boardList.get(indexRow.get(i)).get(indexCol.get(j));
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(indexRow.get(i)).get(indexCol.get(j + 1))) {
                        if (firstChar == boardList.get(indexRow.get(i)).get(indexCol.get(j + 2))) {
                            charArray.add(firstChar);
                        }
                    }
                }
            }
        }
        return charArray;
    }

    private char findDiagonalGame(List<List<Character>> boardList) {
        char firstChar;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                firstChar = boardList.get(indexRow.get(i)).get(indexCol.get(j));
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(indexRow.get(i + 1)).get(indexCol.get(j + 1))) {
                        if (firstChar == boardList.get(indexRow.get(i + 2)).get(indexCol.get(j + 2))) {
                            return firstChar;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 2; j > 1; j--) {
                firstChar = boardList.get(indexRow.get(i)).get(indexCol.get(j));
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(indexRow.get(i + 1)).get(indexCol.get(j - 1))) {
                        if (firstChar == boardList.get(indexRow.get(i + 2)).get(indexCol.get(j - 2))) {
                            return firstChar;
                        }
                    }
                }
            }
        }
        return SPACE;
    }

    private boolean findEmptySpace(List<List<Character>> boardList) {
        for (List<Character> characters : boardList) {
            for (int j = 0; j < characters.size(); j++) {
                if (indexCol.contains(j) && characters.get(j) == SPACE) {
                    return true;
                }
            }
        }
        return false;
    }
}