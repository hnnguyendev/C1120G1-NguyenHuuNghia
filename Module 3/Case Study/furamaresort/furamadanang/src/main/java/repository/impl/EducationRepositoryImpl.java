package repository.impl;

import mapper.EducationMapper;
import model.Education;
import repository.IEducationRepository;

import java.util.List;

public class EducationRepositoryImpl extends BaseRepositoryImpl<Education> implements IEducationRepository {

    public static final String SELECT_ALL_EDUCATIONS = "select * from educations;";
    public static final String SELECT_EDUCATION_BY_ID = "select * from educations where id = ?;";

    @Override
    public List<Education> findAll() {
        return select(SELECT_ALL_EDUCATIONS, new EducationMapper());
    }

    @Override
    public Education findById(Long id) {
        List<Education> educationList = select(SELECT_EDUCATION_BY_ID, new EducationMapper(), id);

        return educationList.isEmpty() ? null : educationList.get(0);
    }
}
