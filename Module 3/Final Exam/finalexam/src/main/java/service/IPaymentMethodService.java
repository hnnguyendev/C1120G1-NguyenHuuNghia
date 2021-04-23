package service;

import model.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {

    List<PaymentMethod> findAll();

    PaymentMethod findById(Long id);

}
