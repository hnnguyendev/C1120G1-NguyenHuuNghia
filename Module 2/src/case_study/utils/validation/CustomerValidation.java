package case_study.utils.validation;

import case_study.utils.exception.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerValidation {

    private static final String CUSTOMER_NAME = "^[A-Z][a-z]+(\\s[A-Z]([a-z]+))*$";
    private static final String BIRTHDAY = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((190[1-9])|(19[1-9][0-9])|([2-9][0-9]{3}))$";
    private static final String GENDER = "^male|female|unknown$";
    private static final String ID_NUMBER = "^\\d{9}$";
    private static final String PHONE_NUMBER = "^0[1-9]{9}";
    private static final String EMAIL = "^[a-z0-9]+[\\.]?+[a-z0-9]+[@][a-z]+[.][a-z]+([.][a-z]+)?$";
    private static final String CUSTOMER_TYPE = "^[A-Z](([a-z0-9])*)+(\\s[a-z0-9]+)*$";
    private static final String ADRESS = "^[A-Z][a-z]+(\\s[A-Z]([a-z]+))*$";


    public static void validateCustomerName(String str) throws NameException {
        if (!str.matches(CUSTOMER_NAME)) {
            throw new NameException("Invalid customer name, please re-enter!");
        }
    }

    public static void validateBirthday(String str) throws BirthdayException {

        Date birthday = null;

        if (!str.matches(BIRTHDAY)) {
            throw new BirthdayException("Correct format: dd/MM/yyyy, please re-enter!");
        }

        String[] birthdayArr = str.split("/");
        int year = Integer.parseInt(birthdayArr[2]) + 18;
        String birthdayStr = birthdayArr[0] + "/" + birthdayArr[1] + "/" + year;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            birthday = simpleDateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (birthday.compareTo(new Date()) > 0) {
            throw new BirthdayException("You are not old enough, age must be over 18");
        }
    }

    public static void validateGender(String str) throws GenderException {
        str = str.toLowerCase();
        if (!str.matches(GENDER)) {
            throw new GenderException("Gender (male, female, unknown), please re-enter!");
        }
    }

    public static void validateIdNumber(String str) throws IdNumberException {
        if (!str.matches(ID_NUMBER)) {
            throw new IdNumberException("Invalid id number, please re-enter!");
        }
    }

    public static boolean validatePhoneNumber(String str) {
        if (!str.matches(PHONE_NUMBER)) {
            System.out.println("Invalid phone number, please re-enter!");
            return false;
        }
        return true;
    }

    public static void validateCustomerEmail(String str) throws EmailException {
        if (!str.matches(EMAIL)) {
            throw new EmailException("Incorrect format, please re-enter!");
        }
    }

    public static boolean validateCustomerType(String str) {
        if (!str.matches(CUSTOMER_TYPE)) {
            System.out.println("Invalid customer type, please re-enter!");
            return false;
        }
        return true;
    }

    public static boolean validateAddress(String str) {
        if (!str.matches(ADRESS)) {
            System.out.println("Invalid address, please re-enter!");
            return false;
        }
        return true;
    }

}
