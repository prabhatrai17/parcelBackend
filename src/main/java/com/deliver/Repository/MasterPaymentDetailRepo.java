package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.deliver.entities.MasterPaymentDetail;
import com.deliver.entities.Payment;

@Repository
public interface MasterPaymentDetailRepo extends JpaRepository <MasterPaymentDetail, Integer>{
	@Query(value="select * from parsola.master_payment_detail where card_no=?1 and card_expiry_date=?2 and cvv_no=?3 and card_pin=?4 and available_balance>=?5",nativeQuery=true)
	MasterPaymentDetail confirmDetail(String cardNo,String expiry,int cvv,int pin,int orderAmount);

}
