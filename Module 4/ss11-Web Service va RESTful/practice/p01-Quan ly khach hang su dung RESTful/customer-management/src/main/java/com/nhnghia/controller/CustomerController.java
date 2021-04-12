package com.nhnghia.controller;

import com.nhnghia.entity.Customer;
import com.nhnghia.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getOne(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(id);
        if (currentCustomer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}
