package battleship;

import java.util.ArrayList;
import java.util.List;

public class BattleField {

    final String FOG = "~";
    final String SPACE = " ";
    final List<Integer> columns = List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
    final List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    final List<String> letters = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
    final int TEN = 10;
    final int TWENTY = 20;
    final int ZERO = 0;

    public void startBattleFieldGame() {
        List<List<String>> gameField = createGameField();
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
}