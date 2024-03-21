package cz.tul.mysti2024.cv.payment_services;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.tul.mysti2024.cv.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class CashPaymentService implements IPaymentService {

    private final PaymentServiceProcessing paymentServiceProcessing;
    private final PaymentTransformations paymentTransformations;

    public CashPaymentService(PaymentServiceProcessing paymentServiceProcessing, PaymentTransformations paymentTransformations) {
        this.paymentServiceProcessing = paymentServiceProcessing;
        this.paymentTransformations = paymentTransformations;
    }

    @Override
    public void processPayment(Payment payment) {
        try {
            paymentServiceProcessing.pay(paymentTransformations.transformXMLFromPayment(payment));
        } catch (JsonProcessingException jsonProcessingException) {
            //handle here
        }
    }
}
