package com.starzplay.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starzplay.entity.Payment;
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
		
		return em.createQuery("select p From Payment p",Payment.class).getResultList();
	}
	
//	public List<Payment> GetAll() {
//		
//		// select p From Payment
//		
//		// 1 Use Criteria Builder to Crete a Criteria Query
//		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
//		
//		// 2 Define Roots of Tables involved in query
//		Root<Payment> courseRoot = cq.from(Payment.class);
//		
//		//3 Define Predicates using Criteria Query
//		
//		//4 Add Predicates to Criteria Query
//		
//		//5 Build The Typed Query using the entity manager and criteria query
//		
//		TypedQuery<Payment> query = em.createQuery(cq.select(courseRoot));
//		
//		List<Payment> list = query.getResultList();
//		
//		return list;
//	}

	public void addPaymentandPaymentPlans(Payment payment) {
	
		em.persist(payment);
	}
	
	public void put(Payment payment) {
		em.merge(payment);
	}

	}

