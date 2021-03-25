package repository.impl;

import mapper.ContractMapper;
import model.Contract;
import repository.IContractRepository;

import java.util.List;

public class ContractRepositoryImpl extends BaseRepositoryImpl<Contract> implements IContractRepository {

    public static final String INSERT_CONTRACT = "insert into contracts (startdate, enddate, deposit, totalpay, " +
            "employeeid, customerid, serviceid) values (?,?,?,?,?,?,?);";
    public static final String SELECT_ALL_CONTRACTS = "select * from contracts;";
    public static final String SELECT_CONTRACT_BY_ID = "select * from contracts where id = ?;";

    @Override
    public void save(Contract contract) {
        update(INSERT_CONTRACT,
                contract.getStartDay(),
                contract.getEndDay(),
                contract.getDeposit(),
                contract.getTotalPay(),
                contract.getEmployee().getId(),
                contract.getCustomer().getId(),
                contract.getService().getId()
        );
    }

    @Override
    public List<Contract> findAll() {
        return select(SELECT_ALL_CONTRACTS, new ContractMapper());
    }

    @Override
    public Contract findById(Long id) {
        List<Contract> contractList = select(SELECT_CONTRACT_BY_ID, new ContractMapper(), id);

        return contractList.isEmpty() ? null : contractList.get(0);
    }
}
