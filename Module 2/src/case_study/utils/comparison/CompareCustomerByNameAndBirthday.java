package case_study.utils.comparison;

import case_study.models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareCustomerByNameAndBirthday implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1;
        Date date2;
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else if (o1.getName().compareTo(o2.getName()) < 0) {
            return -1;
        } else {
            try {
                date1 = simpleDateFormat.parse(o1.getBirthday());
                date2 = simpleDateFormat.parse(o2.getBirthday());
                return date1.compareTo(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
