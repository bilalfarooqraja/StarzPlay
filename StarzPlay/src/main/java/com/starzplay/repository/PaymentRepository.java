package com.starzplay.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.starzplay.entity.Payment;
import com.starzplay.entity.PaymentPlans;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentRepository{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//Save
	public Payment save(Payment pm) {
	    
		em.persist(pm);
		
		return pm;
	}
	
	//GetAll
	public List<Payment> GetAll() {
		return em.createQuery("SELECT p FROM Payment p",Payment.class).getResultList();
	}
	
//	//AddPayment with PaymentPlans
//	public void addPaymentandPaymentPlans(Payment payment,PaymentPlans paymentplans) {
//	
//		
//		payment.addPaymentplans(paymentplans);
//		paymentplans.setPayment(payment);
//
//		em.persist(paymentplans);
//		em.persist(payment);
//		
//	}
//	
//	//Get Payment with PaymentPlans
//	public Payment getPaymentwithPaymentPlans(String paymentType ) {
//		Payment payment = em.find(Payment.class, paymentType);
//		return (Payment) payment.getPaymentplans();
//	}
	
//	public void addPaymentPlansByPaymentType(String paymenttype,List<PaymentPlans> paymentplans) {
//		
//		Payment payment = em.find(Payment.class, paymenttype);
//		
//		for(PaymentPlans pp:paymentplans) {
//			payment.addPaymentplans(paymentplans);
//			pp.setPayment(payment);
//			em.persist(pp);	
//		}
//		
	}

