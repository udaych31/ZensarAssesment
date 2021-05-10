package com.java.zensar.assessment.exception;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ExceptionDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String errorMsg;
	
	private Integer errorcode;
	
	
}
