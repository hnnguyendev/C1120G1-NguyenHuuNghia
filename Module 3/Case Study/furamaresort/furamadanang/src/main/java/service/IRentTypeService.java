package service;

import model.RentType;

import java.util.List;

public interface IRentTypeService {

    List<RentType> findAll();

    RentType findById(Long id);

}
