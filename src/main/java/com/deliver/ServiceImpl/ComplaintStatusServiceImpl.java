package com.deliver.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.Repository.ComplaintStatusSRepository;
import com.deliver.Service.ComplaintStatusService;
import com.deliver.entities.ComplaintStatus;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

	@Autowired
	ComplaintStatusSRepository complaintStatusDao;
	
	public String getComplaintReceivedStatus(Integer userId, Integer complaintId)
	{
		return complaintStatusDao.getComplaintReceived(userId, complaintId);
		
	}
	public String getEnquiringStatus(Integer userId, Integer complaintId)
	{
		return complaintStatusDao.getEnquiring(userId, complaintId);
	}
	public String getActionTakenStatus(Integer userId, Integer complaintId)
	{
		return complaintStatusDao.getActionTaken(userId, complaintId);
	}
	@Override
	public ComplaintStatus saveComplaint(ComplaintStatus complaint, Integer userId, Integer orderId) {
		complaint.setOrder_id(orderId);
		complaint.setUser_id(userId);
		return complaintStatusDao.save(complaint);
	}
}
