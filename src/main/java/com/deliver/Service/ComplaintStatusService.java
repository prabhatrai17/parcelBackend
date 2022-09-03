package com.deliver.Service;

import com.deliver.entities.ComplaintStatus;

public interface ComplaintStatusService {

	public String getComplaintReceivedStatus(Integer userId, Integer complaintId);
	public String getEnquiringStatus(Integer userId, Integer complaintId);
	public String getActionTakenStatus(Integer userId, Integer complaintId);
	public ComplaintStatus saveComplaint( ComplaintStatus complaint,Integer userId, Integer orderId);
	
}

