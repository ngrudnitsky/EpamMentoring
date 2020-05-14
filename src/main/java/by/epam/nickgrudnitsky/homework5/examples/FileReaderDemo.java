package by.epam.nickgrudnitsky.homework5.examples;

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("/Users/txt/txt");
        writer.write("Hello World");

        Reader reader = new FileReader("/Users/Nikita/IdeaProjects/EpamMentoring/src/main/java/by/epam" +
                "/nickgrudnitsky/homework5/example/CatalogRetriever.java");
        int data = reader.read();
        while (data != -1) {
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = reader.read();
        }
        reader.close();
        writer.close();
    }
}
