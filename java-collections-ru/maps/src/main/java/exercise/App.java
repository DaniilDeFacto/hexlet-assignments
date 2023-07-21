package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence.length() == 0) {
            return wordsCount;
        }
        String[] wordsOfSentence = sentence.split(" ");
        for (var word: wordsOfSentence) {
            var count = 0;
            for (var anotherWord: wordsOfSentence) {
                if (word.equals(anotherWord)) {
                    count += 1;
                }
            }
            wordsCount.put(word, count);
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        var result = "";
        for (Map.Entry<String, Integer> entry: wordsCount.entrySet()) {
            result += "  " + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return "{\n" + result + "}";
    }
}
//END
