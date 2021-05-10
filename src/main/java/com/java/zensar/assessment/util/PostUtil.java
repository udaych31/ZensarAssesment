package com.java.zensar.assessment.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.java.zensar.assessment.model.Post;
import com.java.zensar.assessment.model.PostDto;
import com.java.zensar.assessment.model.PostV2;

@Component
public class PostUtil {

	public ArrayList<PostV2> filterPosts(List<Post> fetchPosts){
		ArrayList<PostV2> posList=new ArrayList<>();
		if(!fetchPosts.isEmpty()) {
			Map<Integer, List<Post>> collect = fetchPosts.stream().collect(Collectors.groupingBy(Post::getUserId));
			
			collect.entrySet().stream().forEach(x->{
				PostV2 p=new PostV2();
				
				p.setUserId(x.getKey());
				p.setPost(convertToDto(x.getValue()));
				posList.add(p);
			});

			
		}
		return posList;
	}
	
	public List<PostDto> convertToDto(List<Post> value){
		
		List<PostDto> list=new ArrayList<PostDto>();
		if(!value.isEmpty()) {
			
			value.forEach(x->{
				PostDto dto=new PostDto();
				dto.setId(x.getId());
				dto.setTitle(x.getTitle());
				dto.setBody(x.getBody());
				list.add(dto);
			});
		}
		return list;
	}
	
	
}
