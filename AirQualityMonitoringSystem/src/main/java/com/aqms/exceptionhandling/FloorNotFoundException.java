package com.aqms.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class FloorNotFoundException extends RuntimeException {

	// method to handle the exception when there is no data
	public FloorNotFoundException() {
		super("Data not Found ! ");
	}

}
