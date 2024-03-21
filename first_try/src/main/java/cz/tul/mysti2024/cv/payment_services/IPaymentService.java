package cz.tul.mysti2024.cv.payment_services;

import cz.tul.mysti2024.cv.model.Payment;

public interface IPaymentService {

    void processPayment(Payment payment);
}
