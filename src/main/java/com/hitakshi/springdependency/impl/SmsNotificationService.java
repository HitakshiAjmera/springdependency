package com.hitakshi.springdependency.impl;

import com.hitakshi.springdependency.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("smsNotif")
//@ConditionalOnProperty(name = "notification.type", havingValue = "sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sms sending... "+message);
    }
}
