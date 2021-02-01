package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Validation {

    private static final String SN = "^[A-Z]\\w+(\\s\\w+)*$";
    private static final String SC = "^[A-Z]\\w+(\\s[A-Z](\\w+)*)*$";
    private static final String VL = "";

    public static boolean validateSN(String str) {
        return str.matches(SN);
    }

    public static void main(String[] args) throws ParseException {
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);

        SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
        String s = "11/11/2011";
        Date d = a.parse(s);

          
        System.out.println(d);
    }
}
