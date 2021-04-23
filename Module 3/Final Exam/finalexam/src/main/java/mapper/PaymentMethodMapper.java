package mapper;

import model.PaymentMethod;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodMapper implements IRowMapper<PaymentMethod> {
    @Override
    public PaymentMethod mapRow(ResultSet resultSet) {
        PaymentMethod paymentMethod = new PaymentMethod();
        try {
            paymentMethod.setId(resultSet.getLong("id"));
            paymentMethod.setName(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paymentMethod;
    }
}
