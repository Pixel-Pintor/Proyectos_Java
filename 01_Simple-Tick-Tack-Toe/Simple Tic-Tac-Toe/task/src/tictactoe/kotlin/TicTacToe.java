package tictactoe.kotlin;

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
    final Scanner scanner = new Scanner(System.in);
    final List<Integer> indexCol = List.of(2, 4, 6);
    final List<Integer> indexRow = List.of(1, 2, 3);

    ArrayList<ArrayList<Character>> boardList;

    public void startTicTacToeGame() {
        boardList = createBoard(getUserInput());
        printGameBoard(boardList);
        System.out.println(findVerticalGame(boardList));
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

    private void printGameBoard(ArrayList<ArrayList<Character>> boardList) {
        for (ArrayList<Character> characters : boardList) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private ArrayList<Character> findVerticalGame(ArrayList<ArrayList<Character>> boardList) {
        // capturar caracter inicial y la columna
        char firstChar;
        ArrayList<Character> charArray = new ArrayList<>();
        charArray.add(SPACE);
        for (int i = 0; i < 1; i++) { // estoy en la primera fila
            for (int j = 0; j < 3; j++) { // recorre las tres columnas
                firstChar = boardList.get(indexRow.get(i)).get(indexCol.get(j)); // obtiene el caracter
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(indexRow.get(i) + 1).get(indexCol.get(j))) { // si el primer caracter es igual al segundo y al tercero
                        if (firstChar == boardList.get(indexRow.get(i) + 2).get(indexCol.get(j))) {
                            charArray.add(firstChar); // agrega el caracter si existe juego vertical
                        }
                    }
                }
            }
        }
        return charArray;
    }

    private ArrayList<Character> findHorizontalGame(ArrayList<ArrayList<Character>> boardList) {
        char firstChar;
        ArrayList<Character> charArray = new ArrayList<>();
        charArray.add(SPACE);
        for (ArrayList<Character> characters : boardList) {
            for (int j = 0; j < 1; j++) {
                firstChar = characters.get(j);
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == characters.get(j + 1)) {
                        if (firstChar == characters.get(j + 2)) {
                            charArray.add(firstChar);
                        }
                    }
                }
            }
        }
        return charArray;
    }

    private char findDiagonalGame(ArrayList<ArrayList<Character>> boardList) {
        // verifica si existe un juego diagonal descendente
        char firstChar;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                firstChar = boardList.get(i).get(j);
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(i + 1).get(j + 1)) {
                        if (firstChar == boardList.get(i + 2).get(j + 2)) {
                            return firstChar;
                        }
                    }
                }
            }
        }

        // verifica si existe un juego diagonal ascendente
        for (int i = 0; i < 1; i++) {
            for (int j = 2; j > 1; j--) {
                firstChar = boardList.get(i).get(j);
                if (firstChar == OU || firstChar == EX) {
                    if (firstChar == boardList.get(i + 1).get(j - 1)) {
                        if (firstChar == boardList.get(i + 2).get(j - 2)) {
                            return firstChar;
                        }
                    }
                }
            }
        }

        // retorna el caracter ganador o espacio si no hay ninguno
        return SPACE;
    }
}
