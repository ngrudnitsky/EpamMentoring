package by.epam.nickgrudnitsky.homework5.task3;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FastFileMover {
    private static final String SEPARATOR = "/";
    private static final int BUFFER_SIZE = 100 * 1024;

    public void moveFileVersionOne(String path, String target) throws IOException {
        if (isFileExists(path) && isPathCorrect(target)) {
            try (FileInputStream fileInputStream = new FileInputStream(path);
                 FileOutputStream fileOutputStream = new FileOutputStream(target + SEPARATOR + Paths.get(path).getFileName())) {

                int data = fileInputStream.read();
                while (data != -1) {
                    fileOutputStream.write(data);
                    data = fileInputStream.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            new File(path).delete();
        }
    }

    public void moveFileVersionTwo(String path, String target) throws IOException {
        if (isFileExists(path) && isPathCorrect(target)) {
            try (InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(path), BUFFER_SIZE);
                 OutputStream outputStream = new BufferedOutputStream(
                         new FileOutputStream(target + SEPARATOR + Paths.get(path).getFileName()), BUFFER_SIZE)) {

                int data = inputStream.read();
                while (data != -1) {
                    outputStream.write(data);
                    data = inputStream.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            new File(path).delete();
        }
    }

    public void moveFileVersionThree(String path, String target) throws IOException {
        if (isFileExists(path) && isPathCorrect(target)) {
            try (FileChannel source = new FileInputStream(path).getChannel();
                 FileChannel destination =
                         new FileOutputStream(target + SEPARATOR + Paths.get(path).getFileName()).getChannel()) {
                source.transferTo(0, source.size(), destination);
                new File(path).delete();
            }
        }
    }

    public void moveFileVersionFour(String path, String target) throws IOException {
        if (isFileExists(path) && isPathCorrect(target)) {
            Files.move(Paths.get(path), Paths.get(target + SEPARATOR + Paths.get(path).getFileName()));
        }
    }

    public void moveFileVersionFive(String path, String target) throws IOException {
        if (isFileExists(path) && isPathCorrect(target)) {
            File file = new File(path);
            if (file.renameTo(new File(target + SEPARATOR + Paths.get(path).getFileName()))) {
                file.delete();
            }
        }
    }


    private static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    private static boolean isPathCorrect(String path) {
        File file = new File(path);
        return file.isDirectory();
    }
}
