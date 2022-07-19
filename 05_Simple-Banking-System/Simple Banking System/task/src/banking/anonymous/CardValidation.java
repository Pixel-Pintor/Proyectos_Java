package banking.anonymous;

import java.util.Objects;

public class CardValidation {

    private final CardRepository cardRepository;

    public CardValidation() {
        cardRepository = new CardRepository();
    }

    public boolean isValid(String number, String pin) {
        Card card = cardRepository.findByNumber(number);

        if (card == null) {
            return false;
        }

        return Objects.equals(card.getPin(), pin);
    }
}
