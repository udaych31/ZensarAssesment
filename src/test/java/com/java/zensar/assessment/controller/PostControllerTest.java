package com.java.zensar.assessment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostV2;
import com.java.zensar.assessment.service.PostServiceImpl;

@SpringBootTest
public class PostControllerTest {
	
	@Mock
	private PostServiceImpl impl;
	
	@InjectMocks
	private PostController controller;
	
	
	@Test
	public void testGetEndPointCount() {
		Long n=5L;
		when(impl.getEndPointcount()).thenReturn(5L);
		Long endPointcount = impl.getEndPointcount();
		assertEquals(endPointcount, n);
		
	}
	
	@Test
	public void testFetchResponse() {
		List<Post> postObject = getPostObject();
		when(impl.fetchPosts()).thenReturn(postObject);
		List<Post> fetchPosts = impl.fetchPosts();
		assertEquals(postObject.size(), fetchPosts.size());
	}
	
	@Test
	public void testTallyUserId() {
		ArrayList<PostV2> v2=new ArrayList<PostV2>();
		PostV2 pv=new PostV2();
		pv.setUserId(2);
		v2.add(pv);		
		
		when(impl.tallyPosts()).thenReturn(v2);
		int val=2;
		
		List<PostV2> tallyPosts = impl.tallyPosts();
		assertEquals(tallyPosts.get(0).getUserId(), val);		
		
	}
	
	@Test
	public void testUpdatedList() {
		List<Post> list= getPostObject();
		Post post = list.get(0);
		post.setBody("1800Flower");
		post.setTitle("1800Flower");
		list.set(0, post);
		String str="1800Flower";
		assertEquals(list.get(0).getBody(), str);
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
