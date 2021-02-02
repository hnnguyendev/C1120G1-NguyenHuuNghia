package case_study.services;

import case_study.models.Customer;

import java.util.Queue;

public interface ICinemaService {

    Queue<Customer> findAll();
}
