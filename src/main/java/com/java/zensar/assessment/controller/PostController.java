package com.java.zensar.assessment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostV2;
import com.java.zensar.assessment.service.PostServiceImpl;

@RestController
public class PostController {
	
	private Logger logger=LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostServiceImpl postServiceImpl;	
	
	
	@GetMapping("/getcount")
	public Long getEndPointCount() {
		logger.info("START ::"+this.getClass().getName()+"-getEndPointCount");
		return postServiceImpl.getEndPointcount();
	}
	
	@GetMapping(value="/fetch",produces="application/json")
	public List<Post> fetchResponse(){
		logger.info("START ::"+this.getClass().getName()+"-fetchResponse");
		return postServiceImpl.fetchPosts();
	}
	
	@GetMapping(value="/tallyuserids",produces="application/json")
	public List<PostV2> tallyUserIds(){
		logger.info("START ::"+this.getClass().getName()+"-tallyUserIds");
		return postServiceImpl.tallyPosts();
	}
	
	@GetMapping(value="/updatepost",produces="application/json")
	public List<Post> updatedList(){
		logger.info("START ::"+this.getClass().getName()+"-updatedList");
		return postServiceImpl.modifyPosts();
	}
	
	
	
	
	
	

}
