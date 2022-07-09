package converter;

import java.util.Scanner;

public class Converter {

    private final static Scanner scanner = new Scanner(System.in);
    private final static Base ZERO = new Base(0);
    private final static Base ONE = new Base(1);
    private final static Base TWO = new Base(2);
    private final static Base THREE = new Base(3);
    private final static Base FOUR = new Base(4);
    private final static Base FIVE = new Base(5);
    private final static Base SIX = new Base(6);
    private final static Base SEVEN = new Base(7);
    private final static Base EIGHT = new Base(8);
    private final static Base NINE = new Base(9);
    private final static Base A = new Base("A",10);
    private final static Base B = new Base("B", 11);
    private final static Base C = new Base("C",12);
    private final static Base D = new Base("D", 13);
    private final static Base E = new Base("E", 14);
    private final static Base F = new Base("F",15);

    public void conversionResult(String result) {
        String str = String.format("Conversion result: %s", result);
        System.out.println(str);
    }

    public int getNumberDecimal() {
        System.out.print("Enter the number in decimal system: ");
        return scanner.nextInt();
    }

    public int getBaseTargetBase() {
        System.out.print("Enter de target base: ");
        return scanner.nextInt();
    }

    public String convertToBinary(int number) {
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

    public String convertToOctal(int number) {
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

    public String convertToHexadecimal(int number) {
        StringBuilder hexadecimal = new StringBuilder();
        int decimal = number;

        while (decimal > 16) {
            int module = decimal % 16;
            if (module <= 9) {
                hexadecimal.append(module);
            } else {
                if (module == A.getNumber()) {
                    hexadecimal.append(A.getLetter());
                } else if (module == B.getNumber()) {
                    hexadecimal.append(B.getLetter());
                } else if (module == C.getNumber()) {
                    hexadecimal.append(C.getLetter());
                } else if (module == D.getNumber()) {
                    hexadecimal.append(D.getLetter());
                } else if (module == E.getNumber()) {
                    hexadecimal.append(E.getLetter());
                } else if (module == F.getNumber()) {
                    hexadecimal.append(F.getLetter());
                }
            }
            decimal /= 16;
        }

        hexadecimal.append(decimal);
        hexadecimal.reverse();
        return hexadecimal.toString();
    }
}
