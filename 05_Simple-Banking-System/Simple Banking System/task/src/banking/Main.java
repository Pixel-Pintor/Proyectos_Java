package banking;

import banking.anonymous.CardController;
import banking.anonymous.DBUtils;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Bank newBank = new Bank();
        // newBank.startBank();

        if (args.length > 0 && Objects.equals(args[0], "-fileName")) {
            DBUtils.filename = args[1];
        }

        CardController cardController = new CardController();
        cardController.start();
    }
}

