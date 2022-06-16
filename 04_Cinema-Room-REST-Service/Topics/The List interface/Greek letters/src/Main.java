import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<GreekLetter> letterList = new ArrayList<>();

        final int gamma = 3;
        final int omega = 24;
        final int alpha = 1;

        letterList.add(new GreekLetter("Gamma",  gamma));
        letterList.add(new GreekLetter("Omega", omega));
        letterList.add(new GreekLetter("Alpha",  alpha));

        for (GreekLetter greekLetter : letterList) {
            System.out.println(greekLetter);
        }
    }

    static class GreekLetter {

        private final String letter;
        private final Integer position;

        public GreekLetter(String letter, Integer position) {
            this.letter = letter;
            this.position = position;
        }

        @Override
        public String toString() {
            return "{" +
                    "letter='" + letter + '\'' +
                    ", position=" + position +
                    '}';
        }
    }
}