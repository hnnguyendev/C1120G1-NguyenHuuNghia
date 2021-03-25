package repository;

import model.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {

    List<CustomerType> findAll();

    CustomerType findById(Long id);

}
