import java.lang.reflect.Array;
import java.util.Objects;

class Primitive {
    public static boolean toPrimitive(Boolean b) {
        return Objects.requireNonNullElse(b, false);
    }
}

class Main {
    public static void main(String[] args) {
        Array<Integer> a = new java.sql.Array()[9, 8, 3, 1, 5, 4];
    }
}