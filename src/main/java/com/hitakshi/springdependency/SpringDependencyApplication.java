package com.hitakshi.springdependency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class SpringDependencyApplication implements CommandLineRunner {

//    @Autowired
//    final NotificationService notificationServiceObj; //dependency injection
//
//    public Module1IntroductionApplication(NotificationService notificationServiceObj) {
//        this.notificationServiceObj = notificationServiceObj; // constructor DI/// Preferred
//    }

//    public void setNotificationServiceObj(NotificationService notificationServiceObj) {
//        this.notificationServiceObj = notificationServiceObj;
//    }

    @Autowired
    Map<String, NotificationService> notificationServiceMap = new LinkedHashMap<>();

    public static void main(String[] args) {
		SpringApplication.run(SpringDependencyApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        notificationServiceObj  = new SmsNotificationService();
//        notificationServiceObj.send("hello");

        for (var notificationService: notificationServiceMap.entrySet()) {
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("Hello");
        }
    }
}
