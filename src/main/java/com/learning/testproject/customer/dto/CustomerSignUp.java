package com.learning.testproject.customer.dto;

import lombok.Builder;

@Builder
public record CustomerSignUp(
        String email,
        String username,
        String pwd
) {}
