package mapper;

import model.ContractDetail;
import repository.IContractRepository;
import repository.IExtraServiceRepository;
import repository.impl.ContractRepositoryImpl;
import repository.impl.ExtraServiceRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractDetailMapper implements IRowMapper<ContractDetail> {

    IContractRepository contractRepository = new ContractRepositoryImpl();
    IExtraServiceRepository extraServiceRepository = new ExtraServiceRepositoryImpl();

    @Override
    public ContractDetail mapRow(ResultSet resultSet) {
        ContractDetail contractDetail = new ContractDetail();
        try {
            contractDetail.setId(resultSet.getLong("id"));
            contractDetail.setQuantity(resultSet.getInt("quantity"));
            contractDetail.setContract(contractRepository.findById(resultSet.getLong("contractid")));
            contractDetail.setExtraService(extraServiceRepository.findById(resultSet.getLong("extraserviceid")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetail;
    }
}
