package by.epam.nickgrudnitsky.homework5.examples;

import java.io.*;

public class ReadBytesDemo {
    public static void main(String[] args) throws IOException {
        OutputStream output = new FileOutputStream("/Users/txt.txt");
        output.write("Hello World".getBytes());

        InputStream input = new FileInputStream(
                "/Users/Nikita/IdeaProjects/EpamMentoring/src/main/java/by/epam/nickgrudnitsky/homework5" +
                        "/example/CatalogRetriever.java");
        int data = input.read();
        while (data!= -1){
            System.out.println(data);
            data = input.read();
        }
        input.close();
        output.close();
    }
}
