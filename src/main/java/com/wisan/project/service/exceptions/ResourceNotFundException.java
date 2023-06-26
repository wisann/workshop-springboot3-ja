package com.wisan.project.service.exceptions;

public class ResourceNotFundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ResourceNotFundException(Object id) {
		super("resource not found. id " + id);
	}

}
