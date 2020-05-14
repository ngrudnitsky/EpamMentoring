package by.epam.nickgrudnitsky.homework5.task2;

public class ProgramRunner {
    public static void main(String[] args){
        String path = "/Users/Nikita/IdeaProjects/EpamMentoring";
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();

        System.out.println(String.format("File with max s number:%n\t %s", diskAnalyzer.findFileWithMaxSLetters(path)));

        System.out.println("Five biggest files:");
        diskAnalyzer.findFiveBiggestFiles(path).forEach(e -> System.out.println("\t" + e.getName()));

        System.out.println(String.format("Average files size is:%n\t%f", diskAnalyzer.findAverageFileSize(path)));

        System.out.println("Files count grouped by first letter:");
        System.out.println(diskAnalyzer.groupByFirstLetter(path));
    }
}
