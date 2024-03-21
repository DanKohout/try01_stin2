package cz.tul.mysti2024.cv.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.tul.mysti2024.cv.model.Payment;
import cz.tul.mysti2024.cv.payment_services.PaymentProcessingHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;

@RestController
public class PaymentController {

    @Autowired
    private ObjectMapper objectMapper;

    private PaymentProcessingHandler paymentProcessingHandler;

    public PaymentController(PaymentProcessingHandler paymentProcessingHandler){
        this.paymentProcessingHandler = paymentProcessingHandler;
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/time")
    public String getTime() {
        return new Date(System.currentTimeMillis()).toString();
        //XmlMapper mapper = new XmlMapper();
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String paymentProcessing(String payload) {
        try {
            paymentProcessingHandler.processPayment(payload);
            return "Payment accepted";
        }catch(JsonProcessingException jsonProcessingException){
            return "Payment rejected";
        }
    }

    /*
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String paymentProcessing(String payload) throws JsonProcessingException {
        //pozor na thread safe!!! (zámky)
        //udělat spíše třídu payment service

        Payment payment = objectMapper.readValue(payload, Payment.class);
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        PaymentService paymentService = new PaymentService();

        pay(toPay);

        return "test";
    }*/


    /*
    /**
     * otestuje se pomoci metod ktera ji volá -> paymentProcessing
     * *//*
    private void pay(String payment){
        System.out.println(payment);
    }*/


}
