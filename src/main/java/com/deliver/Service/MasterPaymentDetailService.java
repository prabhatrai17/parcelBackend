package com.deliver.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.entities.MasterPaymentDetail;
import com.deliver.entities.TempPaymentDetail;
import com.deliver.Repository.MasterPaymentDetailRepo;

@Service
public class MasterPaymentDetailService {
	
	@Autowired
	MasterPaymentDetailRepo masterPaymentDetailRepo;
	
   public MasterPaymentDetail checkCardDetail(TempPaymentDetail detail,double orderAmount) {
	   String cardNo=detail.getCardNo();
	   String expiry=detail.getExpiry();
	   int cvv=detail.getCvv();
	   int pin=detail.getPin();
	   
	   MasterPaymentDetail temp= masterPaymentDetailRepo.confirmDetail(cardNo,expiry,cvv,pin,orderAmount);
	   
	   
			   return temp;
	   
   }
}
