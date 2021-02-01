package case_study.services;

import case_study.models.Customer;

import java.util.List;

public interface ICustomerService extends ICrudService<Customer> {

    List<Customer> findAllSortByNameAndBirthday();

}
