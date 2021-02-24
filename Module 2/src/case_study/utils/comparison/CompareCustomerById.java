package case_study.utils.comparison;

import case_study.models.Customer;

import java.util.Comparator;

public class CompareCustomerById implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (Integer.parseInt(o1.getId()) > Integer.parseInt(o2.getId())) {
            return 1;
        } else if (Integer.parseInt(o1.getId()) < Integer.parseInt(o2.getId())) {
            return -1;
        } else {
            return 0;
        }
    }
}
