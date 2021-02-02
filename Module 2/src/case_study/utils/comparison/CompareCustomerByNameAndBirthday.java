package case_study.utils.comparison;

import case_study.models.Customer;
import case_study.utils.standardization.Standardization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareCustomerByNameAndBirthday implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        if (Standardization.standardizedFirstName(o1.getName()).equals(Standardization.standardizedFirstName(o2.getName()))) {
            try {
                date1 = simpleDateFormat.parse(o1.getBirthday());
                date2 = simpleDateFormat.parse(o2.getBirthday());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return date1.compareTo(date2);
        } else {
            return Standardization.standardizedFirstName(o1.getName()).compareTo(Standardization.standardizedFirstName(o2.getName()));
        }
    }

}
