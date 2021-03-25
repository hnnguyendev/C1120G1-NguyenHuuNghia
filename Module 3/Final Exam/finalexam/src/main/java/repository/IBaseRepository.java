package repository;

import mapper.IRowMapper;

import java.util.List;

public interface IBaseRepository<T> {

    <T> List<T> select(String sql, IRowMapper<T> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

}
