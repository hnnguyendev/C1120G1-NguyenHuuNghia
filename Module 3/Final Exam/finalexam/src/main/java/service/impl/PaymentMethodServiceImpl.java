package service.impl;

import model.PaymentMethod;
import repository.IPaymentMethodRepository;
import repository.impl.PaymentMethodRepositoryImpl;
import service.IPaymentMethodService;

import java.util.List;

public class PaymentMethodServiceImpl implements IPaymentMethodService {

    IPaymentMethodRepository paymentMethodRepository = new PaymentMethodRepositoryImpl();
    @Override
    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod findById(Long id) {
        return paymentMethodRepository.findById(id);
    }
}
