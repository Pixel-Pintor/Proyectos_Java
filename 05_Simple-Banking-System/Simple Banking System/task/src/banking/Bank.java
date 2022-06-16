package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Bank {

    final Scanner scanner = new Scanner(System.in);
    final int ONE = 1;
    final int ZERO = 0;
    final int TWO = 2;
    List<Account> accounts = new ArrayList<>();

    public void startBank() {
        int action;
        do {
            action = bankMenu();
            if (action == ONE) {
                Card newCard = new Card();
                String cardNumber = newCard.getCardNumber();
                int pinNumber = newCard.getPinNumber();
                printCardInfo(cardNumber, pinNumber);
                createNewBankAccount(cardNumber, pinNumber, ZERO);
            } else if (action == TWO) {
                loggingAccount();
            }
        } while (action != ZERO);
        System.out.println("\nBye!");
    }

    public int bankMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    public void printCardInfo(String cardNumber, long pinNumber) {
        System.out.println("\nYour card has been created");
        System.out.println("Your card number:");
        System.out.println(cardNumber);
        System.out.println("Your card PIN:");
        System.out.println(pinNumber);
        System.out.println();
    }

    public void loggingAccount() {
        String number = inputCardNumberLogging();
        int pin = inputPinNumberLogging();
        boolean logging = false;
        for (Account account : accounts) {
            if (Objects.equals(number, account.getCardNumber())) {
                if (pin == account.getPinNumber()) {
                    loggedAccount(account);
                    logging = true;
                    break;
                }
            }
        }
        if (!logging) {
            System.out.println("\nWrong card number or PIN!\n");
        }
    }

    private int getLoggedAction() {
        System.out.println("\n1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    private void loggedAccount(Account userAccount) {
        System.out.println("\nYou have successfully logged in!");
        int action;
        do {
            action = getLoggedAction();
            if (action == ONE) {
                System.out.println("\nBalance: " + userAccount.getBalance());
            }
        } while (action == ONE);
        System.out.println("\nYou have successfully logged out!\n");
    }

    private String inputCardNumberLogging() {
        System.out.println("\nEnter your card number:");
        return scanner.next();
    }

    private int inputPinNumberLogging() {
        System.out.println("Enter your PIN:");
        return scanner.nextInt();
    }

    private void createNewBankAccount(String cardNumber, long pingNumber, long balance) {
        Account newAccount = new Account(cardNumber, pingNumber, balance);
        accounts.add(newAccount);
    }
}