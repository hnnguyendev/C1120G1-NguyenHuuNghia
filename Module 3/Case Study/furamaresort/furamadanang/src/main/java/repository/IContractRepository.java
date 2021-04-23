package repository;

import model.Contract;

import java.util.List;

public interface IContractRepository {

    void save(Contract contract);

    List<Contract> findAll();

    Contract findById(Long id);
}
