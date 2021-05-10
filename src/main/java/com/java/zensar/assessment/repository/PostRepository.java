package com.java.zensar.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	
	
	@Query(value="select countEndPoint from PostEntity")
	public Long getCount();
	
	

}
