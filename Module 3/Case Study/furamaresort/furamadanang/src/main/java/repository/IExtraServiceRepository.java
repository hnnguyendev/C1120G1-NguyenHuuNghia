package repository;

import model.ExtraService;

import java.util.List;

public interface IExtraServiceRepository {

    List<ExtraService> findAll();

    ExtraService findById(Long id);
}
