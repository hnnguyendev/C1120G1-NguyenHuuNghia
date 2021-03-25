package repository.impl;

import mapper.ContractDetailMapper;
import model.ContractDetail;
import repository.IContractDetailRepository;

import java.util.List;

public class ContractDetailRepositoryImpl extends BaseRepositoryImpl<ContractDetail> implements IContractDetailRepository {

    public static final String INSERT_CONTRACTDETAIL = "insert into contractdetails (quantity, contractid, " +
            "extraserviceid) values (?,?,?);";
    public static final String SELECT_ALL_CONTRACTDETAILS = "select * from contractdetails;";

    @Override
    public void save(ContractDetail contractDetail) {
        update(INSERT_CONTRACTDETAIL,
                contractDetail.getQuantity(),
                contractDetail.getContract().getId(),
                contractDetail.getExtraService().getId()
        );
    }

    @Override
    public List<ContractDetail> findAll() {
        return select(SELECT_ALL_CONTRACTDETAILS, new ContractDetailMapper());
    }
}
