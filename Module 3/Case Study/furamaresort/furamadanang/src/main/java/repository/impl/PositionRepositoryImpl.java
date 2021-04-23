package repository.impl;

import mapper.PositionMapper;
import model.Employee;
import model.Position;
import repository.IPositionRepository;

import java.util.List;

public class PositionRepositoryImpl extends BaseRepositoryImpl<Employee> implements IPositionRepository {

    public static final String SELECT_ALL_POSITIONS = "select * from positions;";
    public static final String SELECT_POSITION_BY_ID = "select * from positions where id = ?;";

    @Override
    public List<Position> findAll() {
        return select(SELECT_ALL_POSITIONS, new PositionMapper());
    }

    @Override
    public Position findById(Long id) {
        List<Position> positionList = select(SELECT_POSITION_BY_ID, new PositionMapper(), id);

        return positionList.isEmpty() ? null : positionList.get(0);
    }
}
