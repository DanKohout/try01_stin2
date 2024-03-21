package cz.tul.mysti2024.cv.payment_services;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceProcessing {
    public void pay(String payment){
        System.out.println(payment);
    }
}
