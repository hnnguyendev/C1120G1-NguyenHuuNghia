package case_study.utils.validation;

import case_study.utils.exception.NameException;

import java.time.LocalDate;

public class CustomerValidation {

    private static final String CUSTOMER_NAME = "^[A-Z][a-z]+(\\s[A-Z]([a-z]+))*$";
    private static final String BIRTHDAY = "";
    private static final String EMAIL = "^[^@.\\\\s]{1,}+[@]{1}+[a-zA-Z]{1,}+[.]{1}+[a-zA-Z]{1,}$";

    public static void validateCustomerName(String str) throws NameException {
        if (!str.matches(EMAIL)) {
            throw new NameException("Sai ten");
        }
    }

    public static boolean validateBirthday(String str) {
        int year = Integer.parseInt(str.substring(6, 10));
        LocalDate localDate = LocalDate.now();
        int systemYear = localDate.getYear();
        if (!str.matches(BIRTHDAY)) {
            System.out.println("Correct format: dd/MM/yyyy, please re-enter!");
            return false;
        }
        if ((systemYear - year) < 18) {
            System.out.println("You are not old enough, age must be over 18");
            return false;
        }
        return true;
    }
}
