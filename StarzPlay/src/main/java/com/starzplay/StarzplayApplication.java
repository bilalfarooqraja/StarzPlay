package com.starzplay;

import java.net.URI;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.starzplay.controller.PaymentController;
import com.starzplay.entity.Payment;
import com.starzplay.repository.PaymentRepository;

@SpringBootApplication
public class StarzplayApplication {
	
	private org.slf4j.Logger logger =LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private PaymentRepository paymentrepository;
//	
//
//	@Autowired
//	private PaymentController paymentController;
//	
	RestTemplate restTemplate = new RestTemplate();
	
	URI uri = UriComponentsBuilder.fromUriString("http//localhost:8080/api/v1.0/configuration/payment-methods").build().encode().toUri();
	
//	List<Payment> payments = restTemplate.getForObject(uri, paymentController.getAllMethods());
//	
	public static void main(String[] args) {
		
		SpringApplication.run(StarzplayApplication.class, args);
	}

//	@Bean
//	public PaymentController pc() {
//		return (PaymentController) paymentController.getAllMethods();
//	}
//
//	

}
