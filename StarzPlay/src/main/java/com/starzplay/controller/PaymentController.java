package com.starzplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.starzplay.entity.Payment;
import com.starzplay.service.PaymentService;

import ch.qos.logback.classic.pattern.Util;

@RestController
@RequestMapping("/api/v1.0/configuration/payment-methods")
@Validated
public class PaymentController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	private PaymentService paymentService;
	
	 
	  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Object> getAllMethods() {
	        try {
	        	List<Payment> payments = paymentService.GetAll();
	        	return new ResponseEntity<Object>(payments, HttpStatus.OK);
	        } catch (Exception ex) { 	
	            logger.error(null, Util.match(null, null));
	        	return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	  
//	  @PostMapping()
}
