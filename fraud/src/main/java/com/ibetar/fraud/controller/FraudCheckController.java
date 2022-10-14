package com.ibetar.fraud.controller;

import com.ibetar.fraud.entity.FraudCheckResponse;
import com.ibetar.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudCheckController(FraudCheckService fraudCheckService) {

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Fraudulent check request for customer {}",customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
