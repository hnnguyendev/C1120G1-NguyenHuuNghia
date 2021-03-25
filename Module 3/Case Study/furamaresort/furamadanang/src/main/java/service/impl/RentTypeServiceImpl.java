package service.impl;

import model.RentType;
import repository.IRentTypeRepository;
import repository.impl.RentTypeRepositoryImpl;
import service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {

    IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id);
    }
}
