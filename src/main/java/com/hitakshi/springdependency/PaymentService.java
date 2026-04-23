package com.hitakshi.springdependency;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;

@Component
//@Service
//@Controller
//@Repository
//@RestController
public class PaymentService {

    public void pay() {
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInitaaaaa() {
        //post init logic
        System.out.println("Before paying.");
    }

    @PreDestroy
    public void beforeDestroyaaa() {
        //cleanup logic
        System.out.println("After payment is done");
    }
}
