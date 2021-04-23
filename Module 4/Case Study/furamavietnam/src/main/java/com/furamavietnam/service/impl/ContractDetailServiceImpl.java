package com.furamavietnam.service.impl;

import com.furamavietnam.entity.ContractDetail;
import com.furamavietnam.repository.IContractDetailRepository;
import com.furamavietnam.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {

    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {

        List<ContractDetail> contractDetailList = findAll();

        for (ContractDetail contractDetailItem : contractDetailList) {
            if (contractDetail.getContract().getId().equals(contractDetailItem.getContract().getId())
                    && contractDetail.getExtraService().getId().equals(contractDetailItem.getExtraService().getId())) {
                contractDetail.setQuantity(contractDetail.getQuantity() + contractDetailItem.getQuantity());
                contractDetail.setId(contractDetailItem.getId());
            }

        }
        return contractDetailRepository.save(contractDetail);

    }
}
