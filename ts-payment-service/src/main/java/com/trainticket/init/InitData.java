package com.trainticket.init;

import com.trainticket.domain.Payment;
import com.trainticket.repository.PaymentRepository;
import com.trainticket.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/23.
 */
@Component
public class InitData implements CommandLineRunner {
    @Autowired
    PaymentService service;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception{

//        PaymentInfo info2 = new PaymentInfo();
//        info2.setOrderId("5ad7750b-a68b-49c0-a8c0-32776b067703");
//        info2.setTripId("G1234");
//        info2.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
//        service.pay(info2);
        Payment payment = new Payment();
        payment.setOrderId("5ad7750b-a68b-49c0-a8c0-32776b067701");
        payment.setPrice("100.0");
        payment.setUserId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
        paymentRepository.save(payment);
    }
}
