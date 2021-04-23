package repository;

import model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {

    List<ServiceType> findAll();

    ServiceType findById(Long id);

}
