package converter;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private final static int A = 10;
    private final static int B = 11;
    private final static int C = 12;
    private final static int D = 13;
    private final static int E = 14;
    private final static int F = 15;
    private final static int BIN = 2;
    private final static int OCT = 8;
    private final static int HEX = 16;

    public static void main(String[] args) {
        int number = getNumber();
        int base = getBase();
        switch (base) {
            case BIN:
                conversionResult(convertToBinary(number));
                break;
            case OCT:
                conversionResult(convertToOctal(number));
                break;
            case HEX:
                conversionResult(convertToHexadecimal(number));
                break;
        }
    }

    public static void conversionResult(String result) {
        String str = String.format("Conversion result: %s", result);
        System.out.println(str);
    }

    public static int getNumber() {
        System.out.print("Enter the number in decimal system: ");
        return scanner.nextInt();
    }

    public static int getBase() {
        System.out.print("Enter de target base: ");
        return scanner.nextInt();
    }

    public static String convertToBinary(int number) {
        StringBuilder binary = new StringBuilder();
        int decimal = number;

        do {
            int module = decimal % 2;
            binary.append(module);
            decimal /= 2;
        } while (decimal > 1);

        binary.append(decimal);
        binary.reverse();
        return binary.toString();
    }

    public static String convertToOctal(int number) {
        StringBuilder octal = new StringBuilder();
        int decimal = number;

        do {
            int module = decimal % 8;
            octal.append(module);
            decimal /= 8;
        } while (decimal > 8);

        octal.append(decimal);
        octal.reverse();
        return octal.toString();
    }

    public static String convertToHexadecimal(int number) {
        StringBuilder hexadecimal = new StringBuilder();
        int decimal = number;

        while (decimal > 16) {
            int module = decimal % 16;
            if (module <= 9) {
                hexadecimal.append(module);
            } else {
                switch (module) {
                    case A:
                        hexadecimal.append("A");
                        break;
                    case B:
                        hexadecimal.append("B");
                        break;
                    case C:
                        hexadecimal.append("C");
                        break;
                    case D:
                        hexadecimal.append("D");
                        break;
                    case E:
                        hexadecimal.append("E");
                        break;
                    case F:
                        hexadecimal.append("F");
                        break;
                }
            }
            decimal /= 16;
        }

        hexadecimal.append(decimal);
        hexadecimal.reverse();
        return hexadecimal.toString();
    }
}
