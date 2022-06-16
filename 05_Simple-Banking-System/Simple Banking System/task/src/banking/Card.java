package banking;

import java.util.ArrayList;
import java.util.Random;

class Card {
    final int LOWER = 0;
    final int UPPER = 9;
    final int FOUR = 4;
    final int RANGE = UPPER - LOWER + 1;
    final Random randomGenerator = new Random();
    String cardNumber = newCardNumber();
    int pinNumber = newPinNumber();

    public String newCardNumber() {
        String startNumber = "400000";
        String midNumber;
        long luhnNumber;
        do {
            midNumber = generateAccountNumber();
            luhnNumber = Long.parseLong(startNumber + midNumber);
        } while (!checkDivisibleByTen(luhnNumber));
        int lastNumber = generateFinalNumber(luhnNumber);
        return String.valueOf(luhnNumber) + lastNumber;
    }

    // TODO : verificar la generacion del PIN
    public int newPinNumber() {
        StringBuilder pin = new StringBuilder();
        for (int i = LOWER; i < FOUR; i++) {
            pin.append(randomGenerator.nextInt(RANGE));
        }
        return Integer.parseInt(pin.toString());
    }

    private String generateAccountNumber() {
        StringBuilder number = new StringBuilder();
        for (int i = LOWER; i < UPPER; i++) {
            number.append(randomGenerator.nextInt(RANGE));
        }
        return number.toString();
    }

    private boolean checkDivisibleByTen(long number) {
        return number % 10 == 0;
    }

    private int generateFinalNumber(long number) {
        String digits = Long.toString(number);
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            allNumbers.add(Integer.parseInt(String.valueOf(digits.charAt(i))));
        }
        ArrayList<Integer> evenArray = new ArrayList<>();
        for (int i = 0; i < allNumbers.size(); i++) {
            if (i % 2 == 0) {
                evenArray.add(allNumbers.get(i));
            }
        }
        evenArray.replaceAll(integer -> integer * 2);
        for (int i = 0; i < evenArray.size(); i++) {
            if (evenArray.get(i) > 9) {
                evenArray.set(i, evenArray.get(i) - 9);
            }
        }
        int indexOdd = 0;
        for (int i = 0; i < allNumbers.size(); i++) {
            if (i % 2 == 0) {
                allNumbers.set(i, evenArray.get(indexOdd));
                indexOdd++;
            }
        }
        int sum = 0;
        for (int num : allNumbers) {
            sum += num;
        }
        int lastNumber = 10 - (sum % 10);
        if (lastNumber > 9) {
            return 0;
        } else {
            return lastNumber;
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }
}