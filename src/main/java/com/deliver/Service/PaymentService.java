package com.deliver.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.entities.Payment;
import com.deliver.Repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	public Payment savePayment(Payment payment) {
		return repository.save(payment);
	}

	public Payment getPaymentById (int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Payment> getPayments () {
		return repository.findAll();
	}

}
