package com.furamavietnam.service;

import com.furamavietnam.entity.Contract;

import java.util.List;

public interface IContractService {

    List<Contract> findALl();

    Contract save(Contract contract);

}
