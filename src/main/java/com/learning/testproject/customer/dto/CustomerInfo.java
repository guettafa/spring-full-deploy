package com.learning.testproject.customer.dto;

import com.learning.testproject.customer.model.Customer;
import lombok.Builder;

@Builder
public record CustomerInfo(
        String email,
        String username
) {

    public static CustomerInfo fromCustomer (Customer customer) {
        return CustomerInfo
                .builder()
                    .email(customer.getEmail())
                    .username(customer.getUsername())
                .build();
    }
}
