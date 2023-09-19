package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            String jsonRepresentation = Files.readString(path);
            return Car.unserialize(jsonRepresentation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
