package com.java.zensar.assessment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostV2;
import com.java.zensar.assessment.repository.PostEntity;
import com.java.zensar.assessment.repository.PostRepository;
import com.java.zensar.assessment.util.PostUtil;

@Service
public class PostServiceImpl implements IPostService {
	
	private Logger logger=LoggerFactory.getLogger(PostServiceImpl.class);
	
	private static final Integer INDEX=3;
	private static final String FLOWER="1800Flowers";
	
	
	@Value("${endpointUrl}")
	private String endPointUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PostRepository repo;

	@Autowired
	private PostUtil postUtil;
	
	@Override
	public List<Post> fetchPosts() {
		List<Post> posts=null;
		logger.info("START::PostServiceImpl - fetchPosts() method ..!");
		logger.info("endopoint url : "+endPointUrl);
		try {
			Post[] res= restTemplate.getForObject(endPointUrl, Post[].class);
			posts=Arrays.stream(res).collect(Collectors.toList());
			
			List<PostEntity> findCount = repo.findAll();
			if(findCount.isEmpty()) {
				PostEntity p=new PostEntity();
				p.setCountEndPoint(1L);
				p.setEndPointUrl(endPointUrl);
				repo.save(p);
			}else {
				PostEntity postEntity = findCount.get(0);
				postEntity.setCountEndPoint(postEntity.getCountEndPoint()+1);
				repo.save(postEntity);
				
			}
			
			
		} catch (Exception e) {
			logger.error("ERROR ::PostServiceImpl-fetchPosts() - "+e.getMessage());
		}
		
		return posts;
	}

	@Override
	public List<PostV2> tallyPosts(){		
		logger.info("START::PostServiceImpl-tallyPosts() method ..!");
		try {
			List<Post> fetchPosts = fetchPosts();		
			return postUtil.filterPosts(fetchPosts);
		} catch (Exception e) {
			logger.error("ERROR ::PostServiceImpl-tallyPosts() - "+e.getMessage());
		}
		return new ArrayList<>();
	}
	
	
	@Override
	public List<Post> modifyPosts() {
		
		
		logger.info("START::PostServiceImpl-modifyPosts() method ..!");
		try {
			List<Post> fetchPosts = fetchPosts();	
			Post post = fetchPosts.get(INDEX);
			post.setBody(FLOWER);
			post.setTitle(FLOWER);
			fetchPosts.set(INDEX, post);
			return fetchPosts;
		} catch (Exception e) {
			logger.error("ERROR ::PostServiceImpl-modifyPosts() method - "+e.getMessage());
		}
		return new ArrayList<>();
		
		
	}
	
	@Override
	public Long getEndPointcount() {
		
		logger.info("START::PostServiceImpl-getEndPointcount() method ..!");
		try {
			return repo.getCount();
		} catch (Exception e) {
			logger.error("ERROR ::PostServiceImpl-getEndPointcount() method - "+e.getMessage());
		}
		return 0L;
	}
	
	
	
	
	
}
