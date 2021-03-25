package repository.impl;

import mapper.CustomerMapper;
import model.Customer;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements ICustomerRepository {

    public static final String INSERT_CUSTOMER = "insert into customers (customercode, fullname, birthday, gender, " +
            "idnumber, phonenumber, email, address, flag, customertypeid) values(?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_CUSTOMERS = "select * from customers where flag = ?;";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from customers where id = ?;";
    public static final String UPDATE_CUSTOMER = "update customers set customercode = ?, fullname = ?, birthday = ?, " +
            "gender = ?, idnumber = ?, phonenumber = ?, email = ?, address = ?, customertypeid = ? where id = ?;";
    public static final String DELETE_CUSTOMER = "update customers set flag = ? where id = ?;";
    public static final String SEARCH_CUSTOMER = "call searchCustomer(?);";

    @Override
    public void save(Customer customer) {
        update(INSERT_CUSTOMER,
                customer.getCustomerCode(),
                customer.getFullName(),
                customer.getBirthday(),
                customer.getGender(),
                customer.getIdNumber(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getFlag(),
                customer.getCustomerType().getId());

    }

    @Override
    public List<Customer> findAll() {
        return select(SELECT_ALL_CUSTOMERS, new CustomerMapper(), 1);
    }

    @Override
    public Customer findById(Long id) {
        List<Customer> customerList = select(SELECT_CUSTOMER_BY_ID, new CustomerMapper(), id);

        return customerList.isEmpty() ? null : customerList.get(0);
    }

    @Override
    public void update(Long id, Customer customer) {
        update(UPDATE_CUSTOMER,
                customer.getCustomerCode(),
                customer.getFullName(),
                customer.getBirthday(),
                customer.getGender(),
                customer.getIdNumber(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getCustomerType().getId(),
                id
        );

    }

    @Override
    public void remove(Long id) {
        update(DELETE_CUSTOMER, 0, id);
    }

    @Override
    public List<Customer> search(String txtSearch) {
        return select(SEARCH_CUSTOMER, new CustomerMapper(), txtSearch);
    }
}
