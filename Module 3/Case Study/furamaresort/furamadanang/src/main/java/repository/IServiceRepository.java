package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {

    void save(Service service);

    List<Service> findAll();

    Service findById(Long id);

    void update(Long id, Service service);

    void remove(Long id);

    List<Service> search(String txtSearch);

}
