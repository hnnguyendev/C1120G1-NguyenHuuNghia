package service;

import model.ServiceType;

import java.util.List;

public interface IServiceTypeService {

    List<ServiceType> findAll();

    ServiceType findById(Long id);

}
