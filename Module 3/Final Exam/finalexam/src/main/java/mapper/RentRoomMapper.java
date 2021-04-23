package mapper;

import model.RentRoom;
import repository.IPaymentMethodRepository;
import repository.impl.PaymentMethodRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentRoomMapper implements IRowMapper<RentRoom> {

    IPaymentMethodRepository paymentMethodRepository = new PaymentMethodRepositoryImpl();

    @Override
    public RentRoom mapRow(ResultSet resultSet) {
        RentRoom rentRoom = new RentRoom();
        try {
            rentRoom.setId(resultSet.getLong("id"));
            rentRoom.setFullName(resultSet.getString("fullname"));
            rentRoom.setPhone(resultSet.getString("phone"));
            rentRoom.setStartDay(resultSet.getString("startday"));
            rentRoom.setNote(resultSet.getString("note"));
            rentRoom.setPaymentMethod(paymentMethodRepository.findById(resultSet.getLong("idpaymentmethod")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentRoom;
    }
}
