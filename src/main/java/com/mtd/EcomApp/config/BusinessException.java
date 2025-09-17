package com.mtd.EcomApp.config;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException{
	public BusinessException(String msg) {Super(msg);}private void Super(String msg) {
		// TODO Auto-generated method stub
		
	}
	{
	}

}
