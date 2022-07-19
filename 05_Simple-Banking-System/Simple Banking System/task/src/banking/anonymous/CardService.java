package banking.anonymous;

import java.util.Random;

public class CardService {

    private static final int BIN = 400000;
    private static final int MAX_ACC_ID = 999999999;
    private static final int MAX_PIN = 9999;
    private static final int RADIX = 10;

    private final CardRepository cardRepository;

    public CardService() {
        cardRepository = new CardRepository();
    }

    public Card findByNumber(String number) {
        return cardRepository.findByNumber(number);
    }

    public Card createAcc() {
        Card card = new Card();
        Random random = new Random();
        String accId = String.format("%09d", random.nextInt(MAX_ACC_ID));
        String checksum = String.valueOf(generateCheckSum(BIN + accId));
        String pin = String.format("%04d", random.nextInt(MAX_PIN));

        card.setNumber(BIN + accId + checksum);
        card.setPin(pin);
        card.setBalance(0);

        cardRepository.save(card);

        return card;
    }

    private int generateCheckSum(String num) {
        char[] binAccId = num.toCharArray();
        int sum = 0;
        for (int i = 0; i < binAccId.length; i++) {
            int no = Character.getNumericValue(binAccId[i]);
            if (i % 2 == 0) {
                binAccId[i] = Character.forDigit(no * 2 > 9 ? no * 2 - 9 : no * 2, RADIX);
                sum += Character.getNumericValue(binAccId[i]);
                continue;
            }
            sum += no;
        }

        return 10 - (sum % 10) == 10 ? 0 : 10 - (sum % 10);
    }
}
