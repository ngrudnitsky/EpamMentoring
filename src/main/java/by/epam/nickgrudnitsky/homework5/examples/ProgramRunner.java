package by.epam.nickgrudnitsky.homework5.examples;

import java.io.File;


public class ProgramRunner {
    public static void main(String[] args) {
        File file = new File(
                "/Users/Nikita/IdeaProjects/EpamJava/src/by/it/nickgrudnitsky/homework1/mainTask1/task1/task.txt");
        System.out.println(file.exists());
        System.out.println(file.length());
        if (file.renameTo(new File(
                "/Users/Nikita/IdeaProjects/EpamJava/src/by/it/nickgrudnitsky/homework1/mainTask1/task1/task.txt"))) {
            file.delete();
            System.out.println(file.exists());
        }

        File dir = new File("/Users/Bob");
        System.out.println(dir.exists());
        if (dir.mkdir()){
            System.out.println(dir.exists());
            System.out.println("It's a dir " + dir.isDirectory());
        }

        dir = new File("/Users");

        String[] fileNames = dir.list();
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
        File[] files = dir.listFiles();
    }
}
