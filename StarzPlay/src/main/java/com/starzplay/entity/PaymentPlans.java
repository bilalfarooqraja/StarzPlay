package com.starzplay.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment_plans")
public class PaymentPlans {

	
	
	@Id
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private float net_amount;
	
	@Column(nullable = false)
	private float tax_amount;
	
	@Column(nullable = false)
	private float gross_amount;
	
	@Column(nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private String duration;
	
	@Column(name="payment_type",nullable = false)
	private String payment_type;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "payment_type", insertable = false, updatable = false)
	private Payment payment_method;
	
	
	
	public Payment getPayment() {
		return payment_method;
	}
	public void setPayment(Payment payment) {
		this.payment_method = payment;
	}
	
	
	public PaymentPlans(int id, float net_amount, float tax_amount, float gross_amount, String currency,
			String duration, String payment_type) {
		super();
		this.id = id;
		this.net_amount = net_amount;
		this.tax_amount = tax_amount;
		this.gross_amount = gross_amount;
		this.currency = currency;
		this.duration = duration;
		this.payment_type = payment_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(float net_amount) {
		this.net_amount = net_amount;
	}
	public float getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(float tax_amount) {
		this.tax_amount = tax_amount;
	}
	public float getGross_amount() {
		return gross_amount;
	}
	public void setGross_amount(float gross_amount) {
		this.gross_amount = gross_amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	
	
	public PaymentPlans() {
		
	}
}
