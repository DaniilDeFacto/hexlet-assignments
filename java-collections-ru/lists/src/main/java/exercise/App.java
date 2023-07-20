package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbolSet, String word) {
        List<String> symbolList = new ArrayList<>();
        for (var i = 0; i < symbolSet.length(); i++) {
            symbolList.add(String.valueOf(symbolSet.charAt(i)));
        }
        for (var j = 0; j < word.length(); j++) {
            String checkElement = String.valueOf(word.charAt(j));
            if (symbolList.contains(checkElement.toUpperCase()) || symbolList.contains(checkElement.toLowerCase())) {
                symbolList.remove(checkElement);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
