package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BullsCows {

    private final Scanner scanner = new Scanner(System.in);
    private String numToGuess;
    private int turns = 0;
    boolean gameOn = true;
    boolean gameWin = false;

    public void startGame() {
        generateNumToGuess();
        // System.out.println("Number: " + numToGuess);
        while (gameOn) {
            System.out.printf("Turn %d:\n", ++turns);
            String inputNumber = getInputNumber(); // numero del usuario
            List<Integer> bullsCows = checkInputNumber(inputNumber);
            printBullsAndCows(bullsCows);
        }
        if (gameWin)
            System.out.println("Congratulations! You guessed the secret code.");
    }

    private String getInputNumber() {
        return scanner.nextLine();
    }

    private void generateNumToGuess() {

        CodeGenerator numGenerator = new CodeGenerator();
        numToGuess = numGenerator.setSecretCode();
        if (Objects.equals(numToGuess, "None"))
            gameOn = false;
        else
            System.out.println("Okay, let's start a game!");
    }

    private List<Integer> checkInputNumber(String number) {

        int bulls = 0;
        int cows = 0;
        List<Integer> numbers = new ArrayList<>();

        List<String> digitsToGuess = List.of(numToGuess.split(""));
        List<String> answer = List.of(number.split(""));

        for (String s : answer) {
            if (digitsToGuess.contains(s))
                cows++;
        }

        for (int i = 0; i < digitsToGuess.size(); i++) {
            for (int j = 0; j < digitsToGuess.size(); j++) {
                if (j == i && Objects.equals(digitsToGuess.get(i), answer.get(j)))
                    bulls++;
            }
        }

        numbers.add(bulls);
        numbers.add(cows);
        return numbers;
    }

    private void printBullsAndCows(List<Integer> bullsCows) {

        int bulls = bullsCows.get(0);
        int cows = bullsCows.get(1);
        String outBulls = bulls != 1 ? "bulls" : "bull";
        String outCows = cows != 1 ? "cows" : "cow";

        String outputString = "Grade: " + bulls +
                " " +
                outBulls +
                " " +
                cows +
                " " +
                outCows;

        if (bulls == numToGuess.length()) {
            gameOn = false;
            gameWin = true;
        }
        System.out.println(outputString);
    }
}
