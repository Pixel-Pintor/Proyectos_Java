import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double k = scanner.nextDouble();
        double n = scanner.nextDouble();
        double m = scanner.nextDouble();
        long seed = 0;
        while (true) {
            Random random = new Random(seed);
            boolean allLessThanM = true;
            for (int i = 0; i < n; i++) {
                double gaussianValue = random.nextGaussian();
                allLessThanM &= gaussianValue <= m;
            }
            if (allLessThanM && seed >= k) {
                break;
            }
            seed++;
        }
        System.out.println(seed);
    }
}