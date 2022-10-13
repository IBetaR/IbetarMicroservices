package com.ibetar.customer.entity;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email) {
}
