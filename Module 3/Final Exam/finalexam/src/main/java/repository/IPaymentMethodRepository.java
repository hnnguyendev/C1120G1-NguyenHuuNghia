package repository;

import model.PaymentMethod;

import java.util.List;

public interface IPaymentMethodRepository {

    List<PaymentMethod> findAll();

    PaymentMethod findById(Long id);

}
