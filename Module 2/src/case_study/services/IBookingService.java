package case_study.services;

import case_study.models.Customer;

import java.util.List;

public interface IBookingService {

    void save(Customer customer, String serviceId);

    List<Customer> findALl();

    boolean isBookingService(String id);

}
