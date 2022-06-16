import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = (long x) -> {
        long val;
        if (x % 2 == 0) {
            val = x + 2;
        } else {
            val = x + 1;
        }
        return val;
    };
}