package case_study.utils.comparison;

import case_study.models.Customer;

import java.util.Comparator;

public class CompareCustomerById implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
