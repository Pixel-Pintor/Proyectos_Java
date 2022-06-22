package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleField {

    final String FOG = "~";
    final String SPACE = " ";
    final List<Integer> columns = List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
    final List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    final List<String> letters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    final List<String> ships = List.of("Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer")
    final int TEN = 10;
    final int TWENTY = 20;
    final int ZERO = 0;
    final int FIVE = 5;
    final Scanner scanner = new Scanner(System.in);
    private List<List<String>> gameField;

    public void startBattleFieldGame() {
        boolean gameOn = true;
        boolean aircraft = false;
        boolean battleship = false;
        boolean submarine = false;
        boolean cruiser = false;
        boolean destroyer = false;
        gameField = createGameField();
        do {
            gameOn = false;
        } while (gameOn);
        printGameField(gameField);
    }

    private List<List<String>> createGameField() {
        List<List<String>> field = new ArrayList<>();
        int indexNum = ZERO;
        int indexLet = ZERO;
        for (int i = ZERO; i <= TEN; i++) {
            List<String> row = new ArrayList<>();
            for (int j = ZERO; j <= TWENTY; j++) {
                if (i == ZERO) {
                    if (columns.contains(j)) {
                        row.add(numbers.get(indexNum++));
                    } else {
                        row.add(SPACE);
                    }
                } else {
                    if (j == ZERO) {
                        row.add(letters.get(indexLet++));
                    } else if (columns.contains(j)) {
                        row.add(FOG);
                    } else {
                        row.add(SPACE);
                    }
                }
            }
            field.add(row);
        }
        return field;
    }

    private void printGameField(List<List<String>> gameField) {
        for (List<String> characters : gameField) {
            for (String character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    // metodo que pide las coordenadas de la nueva nave
    // retorna las coordenadas como una lista de String
    private List<String> getCoordinates(int ship) {
        System.out.println("Enter the coordinates of the " + ships.get(ship) + ":");
        String line = scanner.nextLine();
        List<String> coordinates = new ArrayList<>();
        for (Character ch : line.toCharArray()) {
            if (ch != ' ') {
                coordinates.add(ch.toString());
            }
        }
        return coordinates;
    }

    // metodo que verifica que exista espacio para la nueva nave
    private boolean checkAvailableSpace(List<String> coordinates, int ship) {
        String startRow = coordinates.get(0);
        String startCol = coordinates.get(1);
        String endRow = coordinates.get(2);
        String endCol = coordinates.get(3);
        for (int i = 0; i < gameField.size(); i++) {
            for (int j = 0; j < gameField.get(i).size(); j++) {
                if (gameField.get(i).get(j).equals(startRow)) {

                }
            }
        }
    }

    private void setShipOnBattleField(int cells, int ship) {
        List<String> coordinates = getCoordinates(ship);
        boolean available = checkAvailableSpace(coordinates, ship);
        if (available) {

        }
    }
}