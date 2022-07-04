import java.util.function.BiFunction;
import java.util.function.Function;

class Main {
    public static void main(String... args) {
        // Printer printer = new ConsolePrinter();
        // printer.print(); // prints: This is a default message
    }
}

class ConsolePrinter implements Printer {
}

interface Printer {

    default void print() {
        System.out.println("This is a default message");
    }
}