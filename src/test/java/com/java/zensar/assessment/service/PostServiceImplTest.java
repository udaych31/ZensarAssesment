package com.java.zensar.assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostV2;
import com.java.zensar.assessment.repository.PostEntity;
import com.java.zensar.assessment.repository.PostRepository;
import com.java.zensar.assessment.util.PostUtil;

@SpringBootTest
public class PostServiceImplTest {
	
	
	public String endPointUrl="http://jsonplaceholder.typicode.com/posts";
	
	private Post[] posts=new Post[2];
	
	@Mock
	private PostRepository repository;

	@InjectMocks
	private PostServiceImpl impl;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private PostUtil postUtil;
	
	@BeforeEach
	public void setMockOutput() {
		List<Post> list = getPostObject();
		posts[0]=list.get(0);
		posts[1]=list.get(1);
		
		when(restTemplate.getForObject(endPointUrl, Post[].class)).thenReturn(posts);
		
	}
	
	@Test
	public void testFetchPosts() {
		Post[] pos = restTemplate.getForObject(endPointUrl, Post[].class);
		List<Post> list= getPostObject();
		when(Arrays.stream(pos).collect(Collectors.toList())).thenReturn(list);
		int n=2;
		List<Post> collect = Arrays.stream(posts).collect(Collectors.toList());
		
		assertEquals(collect.size(), n);
		
		List<PostEntity> entity=new ArrayList<PostEntity>();
		PostEntity pe=new PostEntity();
		pe.setPostId(1L);
		pe.setEndPointUrl(endPointUrl);
		pe.setCountEndPoint(1L);
		when(repository.findAll()).thenReturn(entity);
		
		List<PostEntity> findAll = repository.findAll();
		int actual=0;
		assertEquals(findAll.size(), actual);
		
	}
	
	@Test
	public void testTallyPosts() {
		
		List<Post> list= getPostObject();
		ArrayList<PostV2> v2=new ArrayList<PostV2>();
		PostV2 pv=new PostV2();
		pv.setUserId(2);
		v2.add(pv);		
		
		when(postUtil.filterPosts(list)).thenReturn(v2);
		int val=2;
		int n=1;
		ArrayList<PostV2> filterPosts = postUtil.filterPosts(list);
		assertEquals(filterPosts.get(0).getUserId(), val);
		assertNotEquals(filterPosts.get(0).getUserId(), n);
		
	}
	
	@Test
	public void testModifyPost() {
		List<Post> list= getPostObject();
		Post post = list.get(0);
		post.setBody("1800Flower");
		post.setTitle("1800Flower");
		list.set(0, post);
		String str="1800Flower";
		assertEquals(list.get(0).getBody(), str);
	}
	
	@Test
	public void testGetEndPointCount() {
		Long val=2L;
		when(repository.getCount()).thenReturn(val);
		Long count = repository.getCount();
		assertEquals(count, 2L);
		
	}
	
	private List<Post> getPostObject(){
		List<Post> list=new ArrayList<Post>();
		Post p=new Post();
		p.setId(1);
		p.setUserId(1);
		p.setTitle("title");
		p.setBody("body");
		
		Post p1=new Post();
		p1.setId(2);
		p1.setUserId(1);
		p1.setTitle("title");
		p1.setBody("body");
		list.add(p);
		list.add(p1);
		return list;
	}
	
	
}
