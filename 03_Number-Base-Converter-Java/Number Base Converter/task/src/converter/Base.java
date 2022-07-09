package converter;

public class Base {

    private final int number;
    private String letter;

    public Base(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }
    public Base(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
    }
}
