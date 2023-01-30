package com.starzplay.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="paymentplans")
public class PaymentPlans {

	
	
	@Id
	@Column(nullable = false)
	private int id;
	
	@Column(name="net_amount",nullable = false)
	private float netAmount;
	
	@Column(name="tax_amount",nullable = false)
	private float taxAmount;
	
	@Column(name="gross_amount",nullable = false)
	private float grossAmount;
	
	@Column(nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private String duration;
		
	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JsonBackReference
	 @JoinColumn(name = "payment_type", insertable = false, updatable = false)
	private Payment payment;
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	public PaymentPlans(int id, float net_amount, float tax_amount, float gross_amount, String currency,
			String duration, String payment_type) {
		super();
		this.id = id;
		this.netAmount = net_amount;
		this.taxAmount = tax_amount;
		this.grossAmount = gross_amount;
		this.currency = currency;
		this.duration = duration;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNet_amount() {
		return netAmount;
	}
	public void setNet_amount(float net_amount) {
		this.netAmount = net_amount;
	}
	public float getTax_amount() {
		return taxAmount;
	}
	public void setTax_amount(float tax_amount) {
		this.taxAmount = tax_amount;
	}
	public float getGross_amount() {
		return grossAmount;
	}
	public void setGross_amount(float gross_amount) {
		this.grossAmount = gross_amount;
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
	
	public PaymentPlans() {
		
	}
}
