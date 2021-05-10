package com.java.zensar.assessment.repository;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class PostEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long postId;
	
	private String endPointUrl;
		
	private Long countEndPoint;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(String endPointUrl) {
		this.endPointUrl = endPointUrl;
	}

	public Long getCountEndPoint() {
		return countEndPoint;
	}

	public void setCountEndPoint(Long countEndPoint) {
		this.countEndPoint = countEndPoint;
	}

	

}
