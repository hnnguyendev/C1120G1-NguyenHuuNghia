package ss15_io_text_file.exercise.ex02_doc_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFile {

    public static final String PATH = "src/ss15_io_text_file/files/country.csv";

    public static List<String[]> readCsvFile() {
        List<String[]> countryList = new ArrayList<>();
        try {
            File file = new File(PATH);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] countries = line.split(",");
                countryList.add(countries);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public static void main(String[] args) {
        List<String[]> list = readCsvFile();
        for (String[] strings : list) {
            System.out.println(strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] +
                    "," + strings[4] + "," + strings[5]);

        }
    }
}
