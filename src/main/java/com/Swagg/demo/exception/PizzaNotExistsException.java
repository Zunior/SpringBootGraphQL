package com.Swagg.demo.exception;

import com.Swagg.demo.util.ExceptionConstants;

public class PizzaNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PizzaNotExistsException() {
		super(ExceptionConstants.PIZZA_NOT_EXIST);
	}

	public String getExceptionMessage() {
		return new PizzaNotExistsException().getMessage();
	}
}
