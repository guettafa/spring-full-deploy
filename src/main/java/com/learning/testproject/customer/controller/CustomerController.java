package com.learning.testproject.customer.controller;

import com.learning.testproject.customer.dto.CustomerSignUp;
import com.learning.testproject.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
             return new ResponseEntity<>(
                     customerService.getAllCustomers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        try {
            return new ResponseEntity<>(
                    customerService.getCustomerByUsername(username),
                    HttpStatus.FOUND
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerSignUp signUpInfo) {
        try {
            return new ResponseEntity<>(
                    customerService.createCustomer(signUpInfo),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
