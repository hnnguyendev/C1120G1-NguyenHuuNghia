package repository.impl;

import mapper.CustomerMapper;
import mapper.CustomerTypeMapper;
import model.CustomerType;
import repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeRepositoryImpl extends BaseRepositoryImpl<CustomerType> implements ICustomerTypeRepository {

    public static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customertypes;";
    public static final String SELECT_CUSTOMER_TYPE_BY_ID = "select * from customertypes where id = ?;";

    @Override
    public List<CustomerType> findAll() {
        return select(SELECT_ALL_CUSTOMER_TYPE, new CustomerTypeMapper());
    }

    @Override
    public CustomerType findById(Long id) {
        List<CustomerType> customerTypeList = select(SELECT_CUSTOMER_TYPE_BY_ID, new CustomerTypeMapper(), id);

        return customerTypeList.isEmpty() ? null : customerTypeList.get(0);
    }
}
