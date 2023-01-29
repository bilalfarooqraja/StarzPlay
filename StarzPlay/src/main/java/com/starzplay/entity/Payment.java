package com.starzplay.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment_method")
public class Payment {

	@Id
	@Column(name="payment_type",nullable = false)
	private String Payment_type;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String display_name;
	
	
	@OneToMany(mappedBy = "payment_method",fetch = FetchType.LAZY)
	private List<PaymentPlans> paymentplans= new ArrayList<>();
	
	
	
	public List<PaymentPlans> getPaymentplans() {
		return paymentplans;
	}

	public void addPaymentplans(PaymentPlans paymentplans) {
		this.paymentplans.add(paymentplans);
	}
	
	public void removePaymentplans(PaymentPlans paymentPlans) {
		this.paymentplans.remove(paymentPlans);
	}

	
	
	public Payment() {
		
	}
	
	public Payment(String payment_type, String name, String display_name) {
		
		this.Payment_type = payment_type;
		this.name = name;
		this.display_name = display_name;
	}

	public String getPayment_type() {
		return Payment_type;
	}

	public void setPayment_type(String payment_type) {
		Payment_type = payment_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}


	
	
}
