package mapper;

import model.Service;
import repository.IRentTypeRepository;
import repository.IServiceTypeRepository;
import repository.impl.RentTypeRepositoryImpl;
import repository.impl.ServiceTypeRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements IRowMapper<Service> {

    IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();

    @Override
    public Service mapRow(ResultSet resultSet) {
        Service service = new Service();
        try {
            service.setId(resultSet.getLong("id"));
            service.setServiceCode(resultSet.getString("servicecode"));
            service.setName(resultSet.getString("name"));
            service.setArea(resultSet.getInt("area"));
            service.setCost(resultSet.getDouble("cost"));
            service.setMaxPeople(resultSet.getInt("maxpeople"));
            service.setRoomStandard(resultSet.getString("roomstandard"));
            service.setDescription(resultSet.getString("description"));
            service.setPoolArea(resultSet.getInt("poolarea"));
            service.setNumberOfFloor(resultSet.getInt("numberoffloor"));
            service.setFlag(resultSet.getInt("flag"));
            service.setRentType(rentTypeRepository.findById(resultSet.getLong("renttypeid")));
            service.setServiceType(serviceTypeRepository.findById(resultSet.getLong("servicetypeid")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }
}