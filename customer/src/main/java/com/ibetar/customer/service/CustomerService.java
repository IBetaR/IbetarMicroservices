package com.ibetar.customer.service;

import com.ibetar.customer.entity.Customer;
import com.ibetar.customer.entity.CustomerRegistrationRequest;
import com.ibetar.customer.entity.FraudCheckResponse;
import com.ibetar.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        //todo: check if email is valid
        //todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        //todo: check if email fraudster
        //Service to connect to
        String httpLocalHost = "http://localhost:8081";
        String httpHostServer = "http://FRAUD";
        String apiEndPointUrl = "/api/v1/fraud-check/";
        String customerIdRequest = "{customerId}";
        String url = httpHostServer + apiEndPointUrl + customerIdRequest;
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                url, FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("This customer is a fraudster");
        }

        //todo: send notification
    }
}
