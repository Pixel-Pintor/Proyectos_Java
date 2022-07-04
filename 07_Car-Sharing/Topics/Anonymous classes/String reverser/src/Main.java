import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringReverser reverser = str -> {
            StringBuilder strBuild = new StringBuilder(str);
            return strBuild.reverse().toString();
        };

        System.out.println(reverser.reverse(line));
    }

    interface StringReverser {

        String reverse(String str);
    }

}