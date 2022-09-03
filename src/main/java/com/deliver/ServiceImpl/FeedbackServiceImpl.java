package com.deliver.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.Repository.ComplaintStatusSRepository;
import com.deliver.Repository.FeedbackRepository;
import com.deliver.Service.ComplaintStatusService;
import com.deliver.Service.FeedbackService;
import com.deliver.entities.ComplaintStatus;
import com.deliver.entities.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepository FeedbackDao;

	

	@Override
	public Feedback saveFeedback(Feedback feedback, Integer userId, Integer orderId) {
		feedback.setOrder_id(orderId);
		feedback.setUser_id(userId);
		return FeedbackDao.save(feedback);
	}
}
