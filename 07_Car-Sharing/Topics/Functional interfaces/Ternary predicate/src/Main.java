class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (v1, v2, v3) ->
            v1 != v2 && v1 != v3 && v2 != v3;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int val1, int val2, int val3);
    }
}