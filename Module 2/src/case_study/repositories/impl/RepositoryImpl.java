package case_study.repositories.impl;

import case_study.repositories.IRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl<T> implements IRepository<T> {

    private static final String PATH = "src/case_study/data/";

    @Override
    public void writeFile(String fileName, List<T> list, boolean append) {
        File file = new File(PATH + fileName);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (T t : list) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            System.out.println("File error!!!");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<String[]> readFile(String fileName) {
        List<String[]> list = new ArrayList<>();
        File file = new File(PATH + fileName);
        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] stringArr;
            while ((line = bufferedReader.readLine()) != null) {
                stringArr = line.split(",");
                list.add(stringArr);

            }

        } catch (Exception e) {
            System.out.println("File error!!!");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
