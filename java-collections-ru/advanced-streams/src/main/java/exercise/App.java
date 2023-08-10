package exercise;

import java.util.List;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String json) {
        String[] lines = json.split("\n");
        List<String> result = Stream.of(lines)
                .filter(line -> line.startsWith("environment"))
                .flatMap(line -> Stream.of(line.split("\"")))
                .filter(variables -> !variables.startsWith("environment"))
                .flatMap(variables -> Stream.of(variables.split(",")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replaceAll("X_FORWARDED_", ""))
                .toList();
        return String.join(",", result);
    }
}
//END
