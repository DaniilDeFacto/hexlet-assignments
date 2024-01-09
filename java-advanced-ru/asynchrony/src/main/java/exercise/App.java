package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String file3) {
        CompletableFuture<String> contentFile1 = CompletableFuture.supplyAsync(() -> {
            Path path1 = Paths.get(file1).toAbsolutePath().normalize();
            try {
                return Files.readString(path1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> contentFile2 = CompletableFuture.supplyAsync(() -> {
            Path path2 = Paths.get(file2).toAbsolutePath().normalize();
            try {
                return Files.readString(path2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return contentFile1.thenCombine(contentFile2, (content1, content2) -> {
            Path path3 = Paths.get(file3);
            var content = content1 + content2;
            try {
                Files.writeString(path3, content, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return content;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        System.out.println(unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/file3.txt"));
        // END
    }
}

