package case_study.services;

import java.util.List;

/**
 * interface crud
 * @param <T>
 */
public interface ICrudService<T> {

    T findById(String id);

    List<T> findAll();

    void save(T t);

    void update(T t, String id);

    void delete(String id);

}
