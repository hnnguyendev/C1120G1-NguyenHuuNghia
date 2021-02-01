package case_study.services.impl;

import case_study.models.Customer;
import case_study.services.ICinemaService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CinemaServiceImpl implements ICinemaService {

    static Queue<Customer> customerQueue = new LinkedList<>();

    static {
        customerQueue.add(new Customer("001", "Lionel Messi", "0", "0", "0","0", "0", "0", "0", "0"));
        customerQueue.add(new Customer("002", "David Beckham", "0", "0", "0","0", "0", "0", "0", "0"));
        customerQueue.add(new Customer("003", "Juan Mata", "0", "0", "0","0", "0", "0", "0", "0"));
        customerQueue.add(new Customer("004", "Cristiano Ronaldo", "0", "0", "0","0", "0", "0", "0", "0"));
        customerQueue.add(new Customer("005", "Kenvin De Bruyne", "0", "0", "0","0", "0", "0", "0", "0"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerQueue);
    }
}
