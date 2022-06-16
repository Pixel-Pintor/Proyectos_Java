package banking;

class Account {

    String cardNumber;
    long pinNumber;
    long balance;

    public Account(String cardNumber, long pinNumber, long balance) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public long getPinNumber() {
        return pinNumber;
    }

    public long getBalance() {
        return balance;
    }
}