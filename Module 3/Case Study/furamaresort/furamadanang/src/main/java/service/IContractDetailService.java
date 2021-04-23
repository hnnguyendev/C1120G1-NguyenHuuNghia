package service;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    void save(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
