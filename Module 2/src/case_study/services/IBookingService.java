package case_study.services;

import case_study.models.Customer;

public interface IBookingService {

    void save(Customer customer, String serviceId);
}
