package service;

import model.Contract;

import java.util.List;

public interface IContractService {

    void save(Contract contract);

    List<Contract> findAll();

    Contract findById(Long id);

}
