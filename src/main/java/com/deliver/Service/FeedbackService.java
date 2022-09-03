package com.deliver.Service;


import com.deliver.entities.Feedback;

public interface FeedbackService {


	public Feedback saveFeedback( Feedback feedback,Integer userId, Integer orderId);
	
}

