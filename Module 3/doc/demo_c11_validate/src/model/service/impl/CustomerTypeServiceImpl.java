package model.service.impl;


import model.bean.CustomerType;
import model.repository.CustomerTypeRepository;
import model.repository.CustomerTypeRepositoryImpl;
import model.service.CustomerTypeService;

import java.util.List;


public class CustomerTypeServiceImpl implements CustomerTypeService {

    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl() ;

    @Override
    public List<CustomerType> getAll() {
        return customerTypeRepository.selectAllCustomerType();
    }

    @Override
    public CustomerType getCusTypeById(int id) {
        return customerTypeRepository.selectTypeNote(id);
    }
}
