package service.impl;

import model.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepositoryImpl;
import service.IContractService;

import java.util.List;

public class ContractServiceImpl implements IContractService {

    IContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id);
    }
}
