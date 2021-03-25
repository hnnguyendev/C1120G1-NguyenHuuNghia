package common;

public class Validate {

    public static String validatePhoneNumber(String idNumber) {
        String message = null;
        String regex = "^\\d{10}$";
        if (!idNumber.matches(regex)) {
            message = "Phone number invalid";
        }
        return message;
    }
}
