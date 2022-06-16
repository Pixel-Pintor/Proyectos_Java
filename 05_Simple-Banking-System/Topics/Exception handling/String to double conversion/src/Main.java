import java.util.Random;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (RuntimeException e) {
            return 0;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        int a = generator.nextInt(3);
        int b = generator.nextInt(2) + 1;
        int c = generator.nextInt(4);
        System.out.println(a + " " + b + " " + c);
    }
}