package com.dfernandez.ecommercedist.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
}
