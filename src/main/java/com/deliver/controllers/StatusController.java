package com.deliver.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.Service.StatusService;


//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StatusController {
    
    @Autowired
    StatusService StatusService;

    @GetMapping("/user/pickup_status/{userId}/{orderId}")
    String getPickupStatus(@PathVariable Integer userId, @PathVariable Integer orderId)
    {
//    	System.out.println(userId);
//    	System.out.println(orderId);
        return this.StatusService.getPickupStatus(userId,orderId);
    }
    @GetMapping("/user/dispatch_status/{userId}/{orderId}")
    String getDispatchStatus(@PathVariable Integer userId ,@PathVariable Integer orderId)
    {
        return this.StatusService.getDispatchStatus(userId,orderId);
    }
    @GetMapping("/user/arriving_status/{userId}/{orderId}")
    String getArrivingStatus(@PathVariable Integer userId ,@PathVariable Integer orderId)
    {
        return this.StatusService.getArrivingStatus(userId,orderId);
    }
    @GetMapping("/user/delivery_status/{userId}/{orderId}")
    String getDeliverStatus(@PathVariable Integer userId ,@PathVariable Integer orderId)
    {
        return this.StatusService.getDeliverStatus(userId,orderId);
    }

}
