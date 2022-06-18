package tictactoe.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    final char DASH = '-';
    final char PLEAT = '|';
    final char SPACE = ' ';
    final char SUB = '_';
    final char OU = 'O';
    final char EX = 'X';
    final int COLS = 8;
    final int ROWS = 4;
    final int TWO = 2;
    final Scanner scanner = new Scanner(System.in);
    final List<Integer> indexCol = List.of(2, 4, 6);
    final List<Integer> indexRow = List.of(1, 2, 3);

    List<List<Character>> boardList;

    public void startTicTacToeGame() {
        boardList = createBoard(getUserInput());
        printGameBoard(boardList);
        boolean validCoord = false;
        do {
            List<String> coordinates = getCoordinates();
            if (checkCoordinates(coordinates)) {
                printGameBoard(boardList);
                validCoord = true;
            }
        } while (!validCoord);
        /*
        START
        DO
            VAR coordenadas = solicitarCoordenadas()
            IF verificarCoordenadas()
                insertarCaracterEnTabla()
                imprimirTablero()
        WHILE !verificarCoordenadas()
        STOP
         */
        // System.out.println("Vertical game: " + findVerticalGame(boardList));
        // System.out.println("Horizontal game: " + findHorizontalGame(boardList));
        // System.out.println("Diagonal game: " + findDiagonalGame(boardList));
        // System.out.println("Empty space: " + findEmptySpace(boardList));
        // System.out.println("Difference: " + findDifference(boardList));

        // verifica e imprime el resultado del juego
        // checkGame(boardList);
    }

    private String getUserInput() {
        System.out.print("Enter cells: ");
        return scanner.nextLine();
    }

    private List<List<Character>> createBoard(String input) {
        int index = 0;
        char[] inputArray = input.toCharArray();
        List<List<Character>> boardList = new ArrayList<>();
        for (int i = 0; i <= ROWS; i++) {
            List<Character> listRow = new ArrayList<>();
            for (int j = 0; j <= COLS; j++) {
                if (i == 0 || i == ROWS) {
                    listRow.add(DASH);
                } else if (j == 0 || j == COLS) {
                    listRow.add(PLEAT);
                } else if (indexCol.contains(j)) {
                    listRow.add(inputArray[index++]);
                } else {
                    listRow.add(SPACE);
                }
            }
            boardList.add(listRow);
        }
        return boardList;
    }

    private void checkGame(List<List<Character>> boardList) {
        // verifica el juego vertical
        List<Character> vertical = findVerticalGame(boardList);
        // verifica el juego horizontal
        List<Character> horizontal = findHorizontalGame(boardList);
        // verifica el juego diagonal
        char diagonal = findDiagonalGame(boardList);
        // verifica un espacio vacio
        boolean empty = findEmptySpace(boardList);
        // verifica la diferencia de cantidad entre x y O
        int difference = findDifference(boardList);

        // Existe una ficha ganadora
        // Game not finished: no hay ningun juego y existen espacios vacio
        // Draw: no hay ningun juego y no existen espacios vacios
        // X wins: juego para X
        // O wins: juego para O
        // Impossible: existe juego para X y O
        // o la diferencia entre X y O es igual o mayor que 2

        // verifica que alguien gano
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
        } else if (twoGames || difference > 1) {
            System.out.println("Impossible");
        } else {
            if (empty) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        }
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
                if (boardList.get(numX).get(numY) == SUB) {
                    // establece la jugadd
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
        for (int i = 0; i < boardList.size(); i++) {
            for (int j = 0; j < boardList.get(i).size(); j++) {
                if (i == numX && j == numY) {
                    boardList.get(numX).set(numY, EX);
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
            for (Character character : characters) {
                if (character == SUB) {
                    return true;
                }
            }
        }
        return false;
    }

    private int findDifference(List<List<Character>> boardList) {
        int exes = 0;
        int ous = 0;
        for (List<Character> characters : boardList) {
            for (Character character : characters) {
                if (character == EX) {
                    exes++;
                } else if (character == OU) {
                    ous++;
                }
            }
        }
        return Math.abs(exes - ous);
    }
}