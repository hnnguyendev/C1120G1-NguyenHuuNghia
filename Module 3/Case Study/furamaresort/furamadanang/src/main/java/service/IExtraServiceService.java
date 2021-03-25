package service;

import model.ExtraService;

import java.util.List;

public interface IExtraServiceService {

    List<ExtraService> findAll();

    ExtraService findById(Long id);
}
