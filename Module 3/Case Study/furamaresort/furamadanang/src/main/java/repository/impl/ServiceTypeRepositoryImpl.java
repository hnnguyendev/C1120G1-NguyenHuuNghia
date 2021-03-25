package repository.impl;

import mapper.ServiceTypeMapper;
import model.ServiceType;
import repository.IServiceTypeRepository;

import java.util.List;

public class ServiceTypeRepositoryImpl extends BaseRepositoryImpl<ServiceType> implements IServiceTypeRepository {

    public static final String SELECT_ALL_SERVICE_TYPE = "select * from servicetypes;";
    public static final String SELECT_SERVICE_TYPE_BY_ID = "select * from servicetypes where id = ?;";

    @Override
    public List<ServiceType> findAll() {
        return select(SELECT_ALL_SERVICE_TYPE, new ServiceTypeMapper());
    }

    @Override
    public ServiceType findById(Long id) {
        List<ServiceType> serviceTypeList = select(SELECT_SERVICE_TYPE_BY_ID, new ServiceTypeMapper(), id);
        return serviceTypeList.isEmpty() ? null : serviceTypeList.get(0);
    }
}
