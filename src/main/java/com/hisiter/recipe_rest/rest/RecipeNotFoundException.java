package com.hisiter.recipe_rest.rest;

/** 
 * Exception class for not found recipe
 *
 */
public class RecipeNotFoundException extends RuntimeException{
	
	// Override Constructor
	public RecipeNotFoundException() {}
	public RecipeNotFoundException(String message) {
		super(message);
	}
	
	
}
