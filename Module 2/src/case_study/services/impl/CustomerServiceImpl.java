package case_study.services.impl;

import case_study.models.Customer;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.ICustomerService;
import case_study.utils.comparison.CompareCustomerByNameAndBirthday;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private static final String FILE_NAME = "customer.csv";

    IRepository<Customer> repository = new RepositoryImpl<>();

    @Override
    public Customer findById(String id) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList) {
            if (id.equals(customer.getId())) {
                return customer;
            }
        }

        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<Customer> customerList = new ArrayList<>();
        for (String[] strings : listString) {
            Customer customer = new Customer(strings);
            customerList.add(customer);
        }

        return customerList;
    }

    @Override
    public void save(Customer customer) {
        List<Customer> customerList = findAll();
        customerList.add(customer);
        repository.writeFile(FILE_NAME, customerList, false);

    }

    @Override
    public void update(Customer customer, String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Customer> findAllSortByNameAndBirthday() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<Customer> customerList = new ArrayList<>();
        for (String[] strings : listString) {
            Customer customer = new Customer(strings);
            customerList.add(customer);
        }
        customerList.sort(new CompareCustomerByNameAndBirthday());

        return customerList;
    }
}
