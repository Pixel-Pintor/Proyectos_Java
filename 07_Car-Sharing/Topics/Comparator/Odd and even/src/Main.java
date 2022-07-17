import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {

        List<Integer> finalOrder = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0)
                evenNumbers.add(num);
            else
                oddNumbers.add(num);
        }
        oddNumbers.sort(Comparator.naturalOrder());
        evenNumbers.sort(Comparator.reverseOrder());

        finalOrder.addAll(oddNumbers);
        finalOrder.addAll(evenNumbers);

        return finalOrder;
    }
}