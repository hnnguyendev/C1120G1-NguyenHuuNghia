package case_study.services.impl;

import case_study.models.Customer;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IBookingService;

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
}
