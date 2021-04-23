package service.impl;

import model.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.ContractDetailRepositoryImpl;
import service.IContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {

    IContractDetailRepository contractDetailRepository = new ContractDetailRepositoryImpl();

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
