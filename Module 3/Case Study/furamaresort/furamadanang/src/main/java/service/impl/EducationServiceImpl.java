package service.impl;

import model.Education;
import repository.IEducationRepository;
import repository.impl.EducationRepositoryImpl;
import service.IEducationService;

import java.util.List;

public class EducationServiceImpl implements IEducationService {

    IEducationRepository educationRepository = new EducationRepositoryImpl();

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(Long id) {
        return educationRepository.findById(id);
    }
}
