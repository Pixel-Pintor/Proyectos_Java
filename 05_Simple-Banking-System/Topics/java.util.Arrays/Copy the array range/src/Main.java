import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int[] arr = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        int[] newArr = {scanner.nextInt(), scanner.nextInt()};

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, newArr[0], newArr[1])));*/

        byte[] arr = {5, 2, 4, 1};
        byte key = 5;
        Arrays.sort(arr);

        System.out.println(Arrays.binarySearch(arr, key));
    }
}