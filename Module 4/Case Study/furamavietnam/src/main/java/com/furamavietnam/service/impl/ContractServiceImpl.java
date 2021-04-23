package com.furamavietnam.service.impl;

import com.furamavietnam.entity.Contract;
import com.furamavietnam.repository.IContractRepository;
import com.furamavietnam.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    IContractRepository contractRepository;

    @Override
    public List<Contract> findALl() {
        return contractRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }
}
