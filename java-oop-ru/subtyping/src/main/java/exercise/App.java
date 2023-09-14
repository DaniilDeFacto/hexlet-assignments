package exercise;

import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Set<String> keySet = data.toMap().keySet();
        for (var key : keySet) {
            var value = data.get(key, "defaultValue");
            data.unset(key);
            data.set(value, key);
        }
    }
}
// END
