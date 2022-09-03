package com.deliver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.Repository.ComplaintStatusSRepository;
import com.deliver.Service.ComplaintStatusService;
import com.deliver.entities.ComplaintStatus;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ComplaintStatusController {

	@Autowired
	ComplaintStatusService ComplaintStatusService;
	
	@Autowired
	ComplaintStatusSRepository ComplaintStatusSRepository;
	
	@GetMapping("/user/complaint_received/{userId}/{complaintId}")
	String getComplaintReceivedStatus(@PathVariable Integer userId,@PathVariable Integer complaintId)
	{
		return this.ComplaintStatusService.getComplaintReceivedStatus(userId,complaintId);
	}
	 	
	@GetMapping("/user/enquiring/{userId}/{complaintId}")
	String getEnquiringStatus( @PathVariable Integer userId,@PathVariable Integer complaintId)
	{
		return this.ComplaintStatusService.getEnquiringStatus(userId,complaintId);
	}
	
	@GetMapping("/user/action_taken/{userId}/{complaintId}")
	String getActionTakenStatus(@PathVariable  Integer userId,@PathVariable  Integer complaintId)
	{
		return this.ComplaintStatusService.getActionTakenStatus(userId,complaintId);
	}
	
	@PostMapping("/user/submit/{userId}/{orderId}")
	public  ComplaintStatus addComplaint(@RequestBody ComplaintStatus complaint, @PathVariable int userId, @PathVariable int orderId)
	{
		System.out.println("inside backend add comaplaint "+userId+" "+orderId);
		System.out.println(complaint);
		
		return this.ComplaintStatusService.saveComplaint(complaint, userId, orderId);
	}

}
