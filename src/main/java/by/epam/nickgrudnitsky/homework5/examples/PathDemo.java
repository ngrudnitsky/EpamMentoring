package by.epam.nickgrudnitsky.homework5.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/Nikita/IdeaProjects/EpamMentoring/temp.out");
        System.out.println(path.getFileName() + " in " + path.getFileSystem());
        System.out.println(path.getRoot());
        for (Path element : path){
            System.out.println(element);
        }

        Path pathDir = Paths.get("/Users/Nikita/Bob");
        try {
            Path newDir = Files.createDirectory(pathDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
