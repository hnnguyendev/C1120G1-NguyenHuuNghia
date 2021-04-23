package repository;

import model.Education;

import java.util.List;

public interface IEducationRepository {

    List<Education> findAll();

    Education findById(Long id);

}
