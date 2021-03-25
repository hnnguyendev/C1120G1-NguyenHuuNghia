package model.repository;

import model.bean.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    CustomerType selectTypeNote(int id);
    List<CustomerType> selectAllCustomerType();
}
