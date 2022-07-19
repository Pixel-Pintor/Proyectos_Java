package banking.anonymous;

public class CardController {

    private static final int CREATE_ACCOUNT = 1;
    private static final int LOG_IN = 2;
    private static final int BALANCE = 1;
    private static final int LOG_OUT = 2;
    private static final int EXIT = 0;

    private final CardService cardService;
    private final CardValidation cardValidation;

    public CardController() {
        cardService = new CardService();
        cardValidation = new CardValidation();
    }

    public void start() {
        showStartMenu();
    }

    private void showStartMenu() {
        int option;

        while (true) {
            System.out.println("1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");

            option = InputUtil.getIntegerInput();

            switch (option) {
                case CREATE_ACCOUNT:
                    processCreateAcc();
                    break;
                case LOG_IN:
                    processLogin();
                    break;
                case EXIT:
                    System.out.println("\nBye!");
                    return;
            }
        }
    }

    private void processCreateAcc() {
        Card card = cardService.createAcc();
        showCardInfo(card);
    }

    private void processLogin() {
        System.out.println("\nEnter your card number:");
        String number = InputUtil.getStringInput();
        System.out.println("Enter your PIN:");
        String pin = InputUtil.getStringInput();

        if (cardValidation.isValid(number, pin)) {
            showLoginMenu(cardService.findByNumber(number));
        } else {
            System.out.println("\nWrong card number or PIN!\n");
        }
    }

    private void showCardInfo(Card card) {
        System.out.println("\nYour card has been created\n" +
                "Your card number:\n" +
                card.getNumber() + "\n" +
                "Your card PIN:\n" +
                card.getPin() + "\n");
    }

    private void showLoginMenu(Card card) {
        int option;

        System.out.println("\nYou have successfully logged in!\n");

        while (true) {
            System.out.println("1. Balance\n" +
                    "2. Log out\n" +
                    "0. Exit");

            option = InputUtil.getIntegerInput();

            switch (option) {
                case BALANCE:
                    System.out.println("\nBalance: " + card.getBalance() + "\n");
                    break;
                case LOG_OUT:
                    System.out.println("\nYou have successfully logged out!\n");
                    return;
                case EXIT:
                    System.out.println("\nBye!");
                    System.exit(0);
            }
        }
    }
}
