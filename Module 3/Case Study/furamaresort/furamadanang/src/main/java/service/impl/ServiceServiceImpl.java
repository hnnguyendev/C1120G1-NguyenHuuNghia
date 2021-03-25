package service.impl;

import model.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.IServiceService;

import java.util.List;

public class ServiceServiceImpl implements IServiceService {

    IServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void update(Long id, Service service) {
        serviceRepository.update(id, service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.remove(id);
    }

    @Override
    public List<Service> search(String txtSearch) {
        return serviceRepository.search(txtSearch);
    }
}
