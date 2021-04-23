package repository.impl;

import mapper.ServiceMapper;
import model.Service;
import repository.IServiceRepository;

import java.util.List;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service> implements IServiceRepository {

    public static final String INSERT_SERVICE = "insert into services (servicecode, name, area, cost, maxpeople, " +
            "roomstandard, description, poolarea, numberoffloor, flag, renttypeid, servicetypeid) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_SERVICES = "select * from services where flag = ?;";
    public static final String SELECT_SERVICE_BY_ID = "select * from services where id = ?;";
    public static final String UPDATE_SERVICE = "update services set servicecode = ?, name = ?, area = ?, cost = ?, " +
            "maxpeople = ?, roomstandard = ?, description = ?, poolarea = ?, numberoffloor = ?, renttypeid = ?, " +
            "servicetypeid = ? where id = ?;";
    public static final String DELETE_SERVICE = "update services set flag = ? where id = ?;";
    public static final String SEARCH_SERVICE = "call searchService(?);";

    @Override
    public void save(Service service) {
        update(INSERT_SERVICE,
                service.getServiceCode(),
                service.getName(),
                service.getArea(),
                service.getCost(),
                service.getMaxPeople(),
                service.getRoomStandard(),
                service.getDescription(),
                service.getPoolArea(),
                service.getNumberOfFloor(),
                service.getFlag(),
                service.getRentType().getId(),
                service.getServiceType().getId());
    }

    @Override
    public List<Service> findAll() {
        return select(SELECT_ALL_SERVICES, new ServiceMapper(), 1);
    }

    @Override
    public Service findById(Long id) {
        List<Service> serviceList = select(SELECT_SERVICE_BY_ID, new ServiceMapper(), id);

        return serviceList.isEmpty() ? null : serviceList.get(0);
    }

    @Override
    public void update(Long id, Service service) {
        update(UPDATE_SERVICE,
                service.getServiceCode(),
                service.getName(),
                service.getArea(),
                service.getCost(),
                service.getMaxPeople(),
                service.getRoomStandard(),
                service.getDescription(),
                service.getPoolArea(),
                service.getNumberOfFloor(),
                service.getRentType().getId(),
                service.getServiceType().getId(),
                id
        );
    }

    @Override
    public void remove(Long id) {
        update(DELETE_SERVICE, 0, id);
    }

    @Override
    public List<Service> search(String txtSearch) {
        return select(SEARCH_SERVICE, new ServiceMapper(), txtSearch);
    }
}
