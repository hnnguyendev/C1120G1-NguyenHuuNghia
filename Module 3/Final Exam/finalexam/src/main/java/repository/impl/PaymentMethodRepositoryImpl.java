package repository.impl;

import mapper.PaymentMethodMapper;
import model.PaymentMethod;
import repository.IPaymentMethodRepository;

import java.util.List;

public class PaymentMethodRepositoryImpl extends BaseRepositoryImpl<PaymentMethod> implements IPaymentMethodRepository {
    @Override
    public List<PaymentMethod> findAll() {
        return select("select * from paymentmethods;", new PaymentMethodMapper());
    }

    @Override
    public PaymentMethod findById(Long id) {
        List<PaymentMethod> paymentMethodList = select("select * from paymentmethods where id = ?;", new PaymentMethodMapper(), id);

        return paymentMethodList.isEmpty() ? null : paymentMethodList.get(0);
    }
}
