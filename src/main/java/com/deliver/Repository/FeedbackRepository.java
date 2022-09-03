package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.deliver.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
