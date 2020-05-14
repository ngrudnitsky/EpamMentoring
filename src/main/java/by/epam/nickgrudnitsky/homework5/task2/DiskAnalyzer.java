package by.epam.nickgrudnitsky.homework5.task2;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DiskAnalyzer {
    private static List<File> files = new ArrayList<>();

    public List<File> findFiveBiggestFiles(String path) {
        analyzeDirectory(path);
        return files.stream()
                .sorted(Comparator.comparing(File::length))
                .limit(5)
                .collect(Collectors.toList());
    }

    public String findFileWithMaxSLetters(String path) {
        analyzeDirectory(path);
        Optional<File> result = files.stream()
                .filter(it -> it.getName().toLowerCase().contains("s"))
                .max(Comparator.comparingInt(e -> countMatches(e.toString(), "s")));
        return result.map(File::getName).orElse("");
    }

    public double findAverageFileSize(String path) {
        analyzeDirectory(path);
        OptionalDouble result = files.stream()
                .mapToDouble(File::length)
                .average();

        return result.orElse(0);
    }

    public Map<Character, Integer> groupByFirstLetter(String path) {
        analyzeDirectory(path);
        Map<Character, Integer> result = new HashMap<>();

        for (File file : files) {
            char firstLetter = file.getName().charAt(0);
            result.merge(firstLetter, 1, Integer::sum);
        }

        return result;
    }

    private int countMatches(String expression, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(expression);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    private void analyzeDirectory(String path) {
        files.clear();
        if (isPathCorrect(path)){
            retrieveCatalogs(new File(path));
        }
    }

    private static void retrieveCatalogs(File dir) {
        if (dir.isDirectory()) {
            File[] dirs = dir.listFiles();
            if (dirs != null) {
                for (File file : dirs) {
                    if (file.isDirectory()) {
                        retrieveCatalogs(file);
                    }
                    files.add(file);
                }
            }
        }
    }

    private static boolean isPathCorrect(String path){
        File file = new File(path);
        return file.exists();
    }
}
