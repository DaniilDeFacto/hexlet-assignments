package exercise;


import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .filter(name -> name.endsWith("gmail.com") || name.endsWith("yandex.ru") || name.endsWith("hotmail.com"))
                .collect(Collectors.counting());
    }
}
// END
