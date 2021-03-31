package com.activos.fijos.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeanNotFoundException  extends RuntimeException {
	
    /**
	* 
	*/
	private static final long serialVersionUID = 4056137579181674571L;

	public BeanNotFoundException(String message) {
		super(message);
	}
}