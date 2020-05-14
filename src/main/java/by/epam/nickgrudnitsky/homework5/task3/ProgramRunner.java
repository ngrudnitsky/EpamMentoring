package by.epam.nickgrudnitsky.homework5.task3;

import java.io.IOException;

public class ProgramRunner {
    public static void main(String[] args) throws IOException {
        String path1 = "/Users/Nikita/IdeaProjects/EpamMentoring/src/main/java/by/epam/nickgrudnitsky/" +
                "homework5/task3/files/one";
        String path2 = "/Users/Nikita/IdeaProjects/EpamMentoring/src/main/java/by/epam/nickgrudnitsky/" +
                "homework5/task3/files/two";
        String fileName = "/toBeMoved.txt";
        FastFileMover fastFileMover = new FastFileMover();
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        fastFileMover.moveFileVersionOne(path1 + fileName, path2);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time with FileStreams: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        fastFileMover.moveFileVersionTwo(path2 + fileName, path1);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time with FileStreams with buffer: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        fastFileMover.moveFileVersionThree(path1 + fileName, path2);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time with FileChannel: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        fastFileMover.moveFileVersionFour(path2 + fileName, path1);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time with NIO 2 File API v.1: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        fastFileMover.moveFileVersionFive(path1 + fileName, path2);
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time with NIO 2 File API v.2: " + (endTime-startTime) + "ms");
    }
}
