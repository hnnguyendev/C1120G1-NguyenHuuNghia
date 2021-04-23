package repository;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {

    void save(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
