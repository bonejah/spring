package com.cruzeirodosul.cielo.ecommerce.sdk;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Sale implements Serializable {
	private static final long serialVersionUID = 4031062902948447213L;

	@SerializedName("MerchantOrderId")
	private String merchantOrderId;

	@SerializedName("Customer")
	private Customer customer;

	@SerializedName("Payment")
	private Payment payment;
	
	public Sale() {}

	public Sale(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public Customer customer(String name) {
		setCustomer(new Customer(name));

		return getCustomer();
	}

	public Payment payment(Integer amount, Integer installments) {
		setPayment(new Payment(amount, installments));

		return getPayment();
	}

	public Payment payment(Integer amount) {
		return payment(amount, 1);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Sale setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public Sale setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
		return this;
	}

	public Payment getPayment() {
		return payment;
	}

	public Sale setPayment(Payment payment) {
		this.payment = payment;
		return this;
	}

	@Override
	public String toString() {
		return "Sale [merchantOrderId=" + merchantOrderId + ", customer=" + customer + ", payment=" + payment + "]";
	}
}