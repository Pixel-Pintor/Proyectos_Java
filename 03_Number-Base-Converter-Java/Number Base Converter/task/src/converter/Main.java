package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Converter converter = new Converter();
        int number = converter.getNumberDecimal();
        int base = converter.getBaseTargetBase();
        if (base == IbidEnum.BINARY.getNumBaseObject().getNumberBase()) {
            converter.conversionResult(converter.convertToBinary(number));
        } else if (base == IbidEnum.OCTAL.getNumBaseObject().getNumberBase()) {
            converter.conversionResult(converter.convertToOctal(number));
        } else if (base == IbidEnum.HEXADECIMAL.getNumBaseObject().getNumberBase()) {
            converter.conversionResult(converter.convertToHexadecimal(number));
        }
    }
}
