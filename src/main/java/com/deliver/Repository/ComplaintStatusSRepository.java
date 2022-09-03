package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deliver.entities.ComplaintStatus;

@Repository
public interface ComplaintStatusSRepository extends JpaRepository<ComplaintStatus,Integer>{

	@Query(value = "select complaint_recieved from complaintdb where user_id = ?1 and complaint_id = ?2",nativeQuery=true)
	String getComplaintReceived(Integer user_id,Integer complaint_id);
	@Query(value = "select enquiring from complaintdb where user_id = ?1 and complaint_id = ?2",nativeQuery=true)
	String getEnquiring(Integer userId,Integer complainId);
	@Query(value = "select action_taken from complaintdb where user_id = ?1 and complaint_id = ?2",nativeQuery=true)
	String getActionTaken(Integer userId,Integer complaintId);

	
}
	