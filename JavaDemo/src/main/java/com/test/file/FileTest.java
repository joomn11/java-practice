package com.test.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

    public static void main(String[] args) {

        Path file = Paths.get("test.txt");

        Path path = Paths.get("dir");
        Path path2 = Paths.get("dir2/test");

        Path walkPath = Paths.get("src");

        System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));

        try {

            System.out.println(Files.createFile(file));
            Files.writeString(file, "ttttt");
            Files.delete(file);

            Path dirTest = Files.createDirectory(path);
            System.out.println(dirTest);
            System.out.println(Files.exists(dirTest));
            Files.delete(dirTest);

            Path dirTest2 = Files.createDirectories(path2);
            System.out.println(dirTest2);

            System.out.println(dirTest);
            System.out.println(Files.exists(dirTest));
            // Path dirTest = Files.createFile(path);

            // Files.walk(walkPath).forEach(p -> System.out.println(p));

            System.out.println("-- walk file  --");
            // Stream<Path> stream = Files.walk(walkPath);
            Files.walk(walkPath).filter(Files::isRegularFile).forEach(p -> System.out.println(p));

            System.out.println("-- walk dir  --");
            Files.walk(walkPath).filter(Files::isDirectory).forEach(p -> System.out.println(p));

            System.out.println("-- walk file tree --");
            Files.walkFileTree(walkPath, new SimpleFileVisitor());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
