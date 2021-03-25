package repository.impl;

import mapper.ExtraServiceMapper;
import model.ExtraService;
import repository.IExtraServiceRepository;

import java.util.List;

public class ExtraServiceRepositoryImpl extends BaseRepositoryImpl<ExtraService> implements IExtraServiceRepository {

    public static final String SELECT_ALL_EXTRA_SERVICES = "select * from extraservices;";

    @Override
    public List<ExtraService> findAll() {
        return select(SELECT_ALL_EXTRA_SERVICES, new ExtraServiceMapper());
    }

    @Override
    public ExtraService findById(Long id) {
        List<ExtraService> extraServiceList = select("select * from extraservices where id = ?;", new ExtraServiceMapper(), id);

        return extraServiceList.isEmpty() ? null : extraServiceList.get(0);
    }
}
