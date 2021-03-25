package mapper;

import model.Education;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationMapper implements IRowMapper<Education> {
    
    @Override
    public Education mapRow(ResultSet resultSet) {
        Education education = new Education();
        try {
            education.setId(resultSet.getLong("id"));
            education.setEducation(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return education;
    }
}
