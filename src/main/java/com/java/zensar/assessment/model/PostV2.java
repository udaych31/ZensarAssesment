package com.java.zensar.assessment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PostV2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer userId;
	
	private List<PostDto> post;

	
}
