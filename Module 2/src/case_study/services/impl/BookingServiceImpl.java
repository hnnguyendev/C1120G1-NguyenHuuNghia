package case_study.services.impl;

import case_study.models.Customer;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IBookingService;
import case_study.utils.comparison.CompareCustomerById;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements IBookingService {

    public static final String FILE_NAME = "booking.csv";

    IRepository repository = new RepositoryImpl();

    @Override
    public void save(Customer customer, String serviceId) {
        List<Customer> customerList = new ArrayList<>();
        customer.setCustomerService(serviceId);
        customerList.add(customer);
        repository.writeFile(FILE_NAME, customerList, true);
    }

    @Override
    public List<Customer> findALl() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<Customer> customerList = new ArrayList<>();
        for (String[] strings : listString) {
            Customer customer = new Customer(strings);
            customerList.add(customer);
        }
        customerList.sort(new CompareCustomerById());

        return customerList;
    }

    @Override
    public boolean isBookingService(String id) {
        List<Customer> customerList = findALl();
        for (Customer customer : customerList) {
            if (customer.getCustomerService().equals(id)) {
                return false;
            }
        }

        return true;
    }
}
