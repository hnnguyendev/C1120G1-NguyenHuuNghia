package service.impl;

import model.ExtraService;
import repository.IExtraServiceRepository;
import repository.impl.ExtraServiceRepositoryImpl;
import service.IExtraServiceService;

import java.util.List;

public class ExtraServiceServiceImpl implements IExtraServiceService {

    IExtraServiceRepository extraServiceRepository = new ExtraServiceRepositoryImpl();

    @Override
    public List<ExtraService> findAll() {
        return extraServiceRepository.findAll();
    }

    @Override
    public ExtraService findById(Long id) {
        return extraServiceRepository.findById(id);
    }
}
