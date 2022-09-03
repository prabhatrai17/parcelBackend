package com.delivery.deliveryStatusImplt;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.deliveryStatusRepository.StatusRepository;
import com.delivery.deliveryStatusService.StatusService;


@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    StatusRepository StatusRepository;

    public String getPickupStatus(Integer userId,Integer orderId)
    {
        return StatusRepository.getPickupQuery(userId,orderId);  
    }
    public String getDispatchStatus(Integer userId , Integer orderId)
    {
        return StatusRepository.getDispatchQuery(userId,orderId); 
    }
    public String getArrivingStatus(Integer userId , Integer orderId)
    {
        return StatusRepository.getArrivingQuery(userId,orderId); 
    }
    public String getDeliverStatus(Integer userId , Integer orderId)
    {
        return StatusRepository.getDeliveryQuery(userId,orderId); 
    }

}
