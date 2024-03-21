package cz.tul.mysti2024.cv.controller;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    PaymentController paymentController;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world")));
    }

    /*@Test
    void testPayment() throws IOException {
        PaymentController paymentController = new PaymentController();
        String payload = Files.readString(new ClassPathResource("input_data/input_valid.json").getFile().toPath());
        //paymentController.paymentProcessing(payload);
        Assertions.assertEquals("test", paymentController.paymentProcessing(payload));
    }*/

    @Test
    void testCardPayment() throws IOException {
        String payload = Files.readString(new ClassPathResource("input_data/card_valid_payment.json").getFile().toPath());
        paymentController.paymentProcessing(payload);
    }
    @Test
    void testCashPayment() throws IOException {
        String payload = Files.readString(new ClassPathResource("input_data/cash_valid_payment.json").getFile().toPath());
        paymentController.paymentProcessing(payload);
    }

}
