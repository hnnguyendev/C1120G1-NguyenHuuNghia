package service;

import model.Education;

import java.util.List;

public interface IEducationService {

    List<Education> findAll();

    Education findById(Long id);
}
