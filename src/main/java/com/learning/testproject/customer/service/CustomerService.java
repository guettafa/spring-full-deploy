package com.learning.testproject.customer.service;

import com.learning.testproject.customer.dto.CustomerInfo;
import com.learning.testproject.customer.dto.CustomerSignUp;
import com.learning.testproject.customer.exception.CustomerNotFound;
import com.learning.testproject.customer.model.Customer;
import com.learning.testproject.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerInfo getCustomerByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(CustomerNotFound::new);

        return CustomerInfo.fromCustomer(customer);
    }

    public CustomerInfo createCustomer(CustomerSignUp signupInfo) {
        return CustomerInfo.fromCustomer(
            customerRepository.save(Customer
                    .builder()
                        .email(signupInfo.email())
                        .username(signupInfo.username())
                        .pwd(signupInfo.pwd())
                    .build())
        );
    }
}
