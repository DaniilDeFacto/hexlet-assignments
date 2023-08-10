package exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> oneMap, Map<String, Object> twoMap) {
        Set<String> oneSet = new HashSet<>(oneMap.keySet());
        Set<String> twoSet = new HashSet<>(twoMap.keySet());

        Set<String> addedSet = new HashSet<>(twoSet);
        addedSet.removeAll(oneSet);

        Set<String> deletedSet = new HashSet<>(oneSet);
        deletedSet.removeAll(twoSet);

        Set<String> intersetionSet = new HashSet<>(oneSet);
        intersetionSet.retainAll(twoSet);

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (var key : addedSet) {
            result.put(key, "added");
        }
        for (var key : deletedSet) {
            result.put(key, "deleted");
        }
        for (var key : intersetionSet) {
            if (oneMap.get(key).equals(twoMap.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }
        return result;
    }
}
//END
