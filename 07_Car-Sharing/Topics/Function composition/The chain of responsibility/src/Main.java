import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

class ChainOfResponsibilityDemo {


    // Don't change the code below
    public static void main(String[] args) throws Exception {

        List<Integer> numbers = Arrays.asList(12, 2, 13, 4, 15, 6);

        numbers.sort((i1, i2) -> !i1.equals(i2) ? 0 : i2 - i1);

        System.out.println(numbers);
    }
}