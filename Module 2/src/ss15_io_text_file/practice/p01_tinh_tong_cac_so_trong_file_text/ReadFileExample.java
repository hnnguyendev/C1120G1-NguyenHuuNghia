package ss15_io_text_file.practice.p01_tinh_tong_cac_so_trong_file_text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileExample {

    public static final String PATH = "src/ss15_io_text_file/files/numbers.txt";

    public void readFileText(String filePath) {

        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();

            System.out.println("Sum = " + sum);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File error");
        }

    }

    public static void main(String[] args) {

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(PATH);

    }
}
