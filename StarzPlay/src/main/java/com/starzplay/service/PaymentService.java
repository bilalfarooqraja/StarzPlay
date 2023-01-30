package com.starzplay.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starzplay.entity.Payment;
import com.starzplay.entity.PaymentPlans;
import com.starzplay.repository.PaymentRepository;


@Service
public class PaymentService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaymentRepository paymentRepository;
	

	
    public List<Payment> GetAll() {
    	
    	return paymentRepository.GetAll();
    }
    
     public void SaveAll(Payment payment) {
    	
   	 paymentRepository.addPaymentandPaymentPlans(payment);
    	
    	
    }
     
     public void Update(Payment payment) {
     	
       	 paymentRepository.put(payment);
        	 	
        }

}
