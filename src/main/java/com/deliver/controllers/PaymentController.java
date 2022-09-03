package com.deliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.entities.MasterPaymentDetail;
import com.deliver.entities.Payment;
import com.deliver.entities.TempPaymentDetail;
import com.deliver.Service.MasterPaymentDetailService;
import com.deliver.Service.PaymentService;

@CrossOrigin
@RestController
public class PaymentController {
  @Autowired
	private PaymentService service;
  
  @Autowired
  private MasterPaymentDetailService masterPaymentDetailService;

	@PostMapping("/savepayment")
	public Payment savePayment (@RequestBody Payment payment) {
		return service.savePayment(payment);
	}

	@GetMapping("/payment/{id}")
	public Payment getPaymentById(@PathVariable int id) {
		return service.getPaymentById(id);
	}

	@GetMapping("/payments")
	public List<Payment> getPayments() {
		return service.getPayments();
	}
	
	@PostMapping("/payment_validate/{orderAmount}")
	public boolean validatePayment(@RequestBody TempPaymentDetail tempPaymentDetail,@PathVariable int orderAmount) {
		System.out.println(tempPaymentDetail);
		MasterPaymentDetail temp=masterPaymentDetailService.checkCardDetail(tempPaymentDetail,orderAmount);
		System.out.println(temp);
		
		if(temp==null)
			return false;
		else
			return true;
	}
	
}
