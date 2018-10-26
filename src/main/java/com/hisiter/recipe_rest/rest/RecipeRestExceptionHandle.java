package com.hisiter.recipe_rest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class  xu ly tat ca cac ngoai le duoc nem ra tu cac component spring
 * @author hisiter
 *
 */
@ControllerAdvice
public class RecipeRestExceptionHandle {
	
	//Handle for not found recipe 
	@ExceptionHandler
	public ResponseEntity<RecipeErrorResponse> handleForNotFoundRecipe(RecipeNotFoundException ex) {
		RecipeErrorResponse error = new RecipeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<RecipeErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Handle cho cac exception con lai
	@ExceptionHandler
	public  ResponseEntity<RecipeErrorResponse> handleExceptionRecipe(Exception ex) {
		RecipeErrorResponse error  = new RecipeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<RecipeErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
