package com.java.zensar.assessment.service;

import java.util.List;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostV2;

public interface IPostService {

	public List<Post> fetchPosts();
	
	public List<PostV2> tallyPosts();
	
	public List<Post> modifyPosts();
	
	public Long getEndPointcount();
	
}
