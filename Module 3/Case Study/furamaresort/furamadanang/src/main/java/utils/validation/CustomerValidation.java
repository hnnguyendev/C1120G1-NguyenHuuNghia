package utils.validation;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.Date;
import java.util.List;

public class CustomerValidation {

    static ICustomerService customerService = new CustomerServiceImpl();

    public static String validateCustomerCode(String code) {
        String message = null;
        String regex = "^CU-\\d{4}$";
        if (!code.matches(regex)) {
            message = "Customer code is invalid (CU-XXXX)";
        }

        List<Customer> customerList = customerService.findAll();
        for (Customer customer : customerList) {
            if (customer.getCustomerCode().equals(code)) {
                message = "Customer code is exist";
                break;
            }
        }
        return message;
    }

    public static String validateCustomerName(String name) {
        String message = null;
        String regex = "^[A-Z][a-z]+(\\s[A-Z]([a-z]+))*$";
        if (!name.matches(regex)) {
            message = "Customer name is invalid";
        }
        return message;
    }

    public static String validateCustomerBirthday(Date birthday) {
        return null;
    }

    public static String validateIdNumber(String idNumber) {
        String message = null;
        String regex = "^[1-9]\\d{8}|[1-9]\\d{11}$";
        if (!idNumber.matches(regex)) {
            message = "Id number must be 9 digits or 12 digits";
        }
        return message;
    }

    public static String validatePhoneNumber(String phoneNumber) {
        return null;
    }

    public static String validateEmail(String email) {
        String message = null;
        String regex = "^[a-z0-9]+[\\.]?+[a-z0-9]+[@][a-z]+[.][a-z]+([.][a-z]+)?$";
        if (!email.matches(regex)) {
            message = "Email is invalid";
        }
        return message;
    }

    public static String validateAddress(String address) {
        String message = null;
        String regex = "^[A-Z][a-z]+(\\s[A-Z]([a-z]+))*$";
        if (!address.matches(regex)) {
            message = "Address is invalid";
        }
        return message;
    }
}
