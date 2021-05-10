package com.java.zensar.assessment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class PostResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private List<PostDto> posts;

}
