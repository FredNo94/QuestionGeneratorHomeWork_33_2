package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static Random random = new Random();

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
        String fileWithQuestions = "src/main/resources/Questions.txt";
        String fileWithStudents = "src/main/resources/Students.txt";

        String[] arrayWithQuestions = getDataFromFile(fileWithQuestions);
        String[] arrayWithStudents = getDataFromFile(fileWithStudents);

        createFileWithStudentsAndQuestion(arrayWithStudents, arrayWithQuestions);
    }

    public static void createFileWithStudentsAndQuestion(String[] arrayWithStudents, String[] arrayWithQuestions) throws IOException {
        if (arrayWithStudents == null || arrayWithStudents == null) {
            throw new RuntimeException("Получены нулевые массивы данных");
        }

        String fileName = "Students and Questions " + new SimpleDateFormat("YYYY_MM_dd").format(new Date()) + ".txt";
        clearFileBeforeWrite(fileName);

        FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_8, true);
        PrintWriter printWriter = new PrintWriter(writer);

        for (int i = 0; i < arrayWithStudents.length; i++) {
            printWriter.println(arrayWithStudents[i] + " " + arrayWithQuestions[random.nextInt(arrayWithQuestions.length)]);
        }

        writer.close();
    }

    public static String[] getDataFromFile(String urlDataFile) throws IOException {
        String tempValueFromData;
        ArrayList<String> listData = new ArrayList<>();

        Path path = Paths.get(urlDataFile);
        Scanner scanner = new Scanner(path, StandardCharsets.UTF_8);

        while (scanner.hasNextLine()) {
            tempValueFromData = scanner.nextLine();
            if (tempValueFromData.length() > 0) {
                listData.add(tempValueFromData);
            }
        }
        return listData.toArray(new String[listData.size()]);
    }

    private static void clearFileBeforeWrite(String fileName) throws IOException {
        new FileOutputStream(fileName, false).close();
    }
}
