package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean isCoincidence = true;
            for (Map.Entry<String, String> data: where.entrySet()) {
                if (!book.containsValue(data.getValue())) {
                    isCoincidence = false;
                }
            }
            if (isCoincidence) {
                result.add(book);
            }

        }
        return result;
    }
}
//END
