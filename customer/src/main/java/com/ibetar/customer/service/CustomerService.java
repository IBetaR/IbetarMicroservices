package com.ibetar.customer.service;

import com.ibetar.customer.entity.Customer;
import com.ibetar.customer.entity.CustomerRegistrationRequest;
import com.ibetar.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        //todo: check if email is valid
        //todo: check if email is not taken
        //todo: store customer in db
        customerRepository.save(customer);
    }
}
