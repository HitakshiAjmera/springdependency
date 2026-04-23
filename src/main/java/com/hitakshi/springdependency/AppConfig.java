package com.hitakshi.springdependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("request")
    public PaymentService paymentService() {
        // more logic
        return new PaymentService();
    }
}
