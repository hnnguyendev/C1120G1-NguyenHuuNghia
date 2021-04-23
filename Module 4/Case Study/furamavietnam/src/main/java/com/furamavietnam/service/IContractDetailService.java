package com.furamavietnam.service;

import com.furamavietnam.entity.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();

    ContractDetail save(ContractDetail contractDetail);
}
