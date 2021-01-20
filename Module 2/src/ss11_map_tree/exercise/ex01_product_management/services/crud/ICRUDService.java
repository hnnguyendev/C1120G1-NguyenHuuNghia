package ss11_map_tree.exercise.ex01_product_management.services.crud;

import java.util.List;

public interface ICRUDService<T> {

    List<T> findALl();

    T findById(int id);

    void save(T t);

    void update(T t, int id);

    void remove(int id);

}
