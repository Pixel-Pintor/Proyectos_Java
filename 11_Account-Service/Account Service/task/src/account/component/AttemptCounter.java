package account.component;

import java.util.HashMap;
import java.util.Map;

public class AttemptCounter {
    private static AttemptCounter instance;
    public Map<String, Integer> counter = new HashMap<>();

    private AttemptCounter () {}

    public static AttemptCounter getInstance() {
        if (instance == null) {
            instance = new AttemptCounter();
        }
        return instance;
    }

    public Integer get(String key) {
        return counter.getOrDefault(key, 0);
    }

    public void set(String key, Integer value) {
        counter.put(key, value);
    }
}