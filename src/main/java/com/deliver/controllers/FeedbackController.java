package com.deliver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.deliver.Repository.FeedbackRepository;
import com.deliver.Service.FeedbackService;
import com.deliver.entities.Feedback;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FeedbackController {

	@Autowired
    FeedbackService feedbackService;
	
	@PostMapping("/user/feedback/submit/{userId}/{orderId}")
	public Feedback addFeedback(@RequestBody Feedback feedback, @PathVariable int userId, @PathVariable int orderId)
	{
		System.out.println(feedback);
		return this.feedbackService.saveFeedback(feedback, userId, orderId);
	}
	
}
