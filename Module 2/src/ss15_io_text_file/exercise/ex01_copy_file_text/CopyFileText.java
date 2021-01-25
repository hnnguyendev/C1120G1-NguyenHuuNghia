package ss15_io_text_file.exercise.ex01_copy_file_text;

import java.io.*;

public class CopyFileText {

    public static final String PATH = "src/ss15_io_text_file/files";
    public static final String SOURCE_PATH = "src/ss15_io_text_file/files/source.txt";
    public static final String TARGET_PATH = "src/ss15_io_text_file/files/target.txt";

    public static void createFile() {

        File dir = new File(PATH);

        dir.mkdir();

        File file = new File(PATH, "source.txt");
        File file1 = new File(PATH, "target.txt");
        try {
            if (file.createNewFile() && file1.createNewFile()) {
                System.out.println("File created..");
            } else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(SOURCE_PATH);
            fileWriter.write("CodeGymDaNang\n");
            fileWriter.write("Lop C1120G1");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFile() {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;

        File file1;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {
            file = new File(SOURCE_PATH);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            file1 = new File(TARGET_PATH);
            fileWriter = new FileWriter(file1);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
                fileWriter.write(line + "\n");

            }
            System.out.println(result);

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createFile();
        writeFile();
        copyFile();
    }
}
