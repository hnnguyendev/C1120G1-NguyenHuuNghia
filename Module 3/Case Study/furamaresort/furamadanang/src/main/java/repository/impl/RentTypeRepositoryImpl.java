package repository.impl;

import mapper.RentTypeMapper;
import model.RentType;
import repository.IRentTypeRepository;

import java.util.List;

public class RentTypeRepositoryImpl extends BaseRepositoryImpl<RentType> implements IRentTypeRepository {

    public static final String SELECT_ALL_RENT_TYPE = "select * from renttypes;";
    public static final String SELECT_RENT_TYPE_BY_ID = "select * from renttypes where id = ?;";

    @Override
    public List<RentType> findAll() {
        return select(SELECT_ALL_RENT_TYPE, new RentTypeMapper());
    }

    @Override
    public RentType findById(Long id) {
        List<RentType> rentTypeList = select(SELECT_RENT_TYPE_BY_ID, new RentTypeMapper(), id);

        return rentTypeList.isEmpty() ? null : rentTypeList.get(0);
    }
}
