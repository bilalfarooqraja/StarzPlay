package com.starzplay.entity;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment")
@NamedEntityGraph(name="payment_entity_graph", attributeNodes = @NamedAttributeNode("paymentPlans"))
public class Payment {

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Id
	@Column(name="payment_type",nullable = false)
	private String paymentType;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name="display_name",nullable = false)
	private String displayName;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "payment",cascade = CascadeType.ALL)
//	@JsonIgnore
	@JsonManagedReference
	private Set<PaymentPlans> paymentPlans;
	
	
	
	public Set<PaymentPlans> getPaymentplans() {
		return paymentPlans;
	}

	public void addPaymentplans(PaymentPlans paymentplans) {
		this.paymentPlans.add(paymentplans);
	}
	
	public void removePaymentplans(PaymentPlans paymentPlans) {
		this.paymentPlans.remove(paymentPlans);
	}


    public void setPaymentPlans(Set<PaymentPlans> paymentplans) {
        this.paymentPlans = paymentplans;
    }

	
	public Payment() {
		
	}
	
	public Payment(String paymentType, String name, String displayName) {
		
		this.paymentType = paymentType;
		this.name = name;
		this.displayName = displayName;
	}



	
	
}
