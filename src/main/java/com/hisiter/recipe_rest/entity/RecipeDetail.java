package com.hisiter.recipe_rest.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for convert JSON 
 * @author hisiter
 *
 */
public class RecipeDetail {
	private int id;
	private String name;
	private String imgUrl;
	private int service;
	private int cookTime;
	private String foodCategory;

	private List<String> fullIngredients;
	
	private List<String> steps;
	
	public RecipeDetail() {}
	
	public RecipeDetail(Recipe recipe) {
		this.id = recipe.getId();
		this.name = recipe.getName();
		this.imgUrl = recipe.getImgUrl();
		this.service = recipe.getService();
		this.cookTime = recipe.getCookTime();
		this.foodCategory = recipe.getFoodCategory().getName();
		this.fullIngredients = new ArrayList<String>();
		this.steps = new ArrayList<String>();
		
		for (Quantity quantity : recipe.getQuantities()) {
			fullIngredients.add(createFullIngredient(quantity));
		}
		
		for(RecipeStep step: recipe.getRecipeSteps()) {
			steps.add(step.getDescription());
		}
	}

	// Create Full Ingredient String  
	public String createFullIngredient(Quantity quantity) {
		String fullIngredient;
		float theNumber = quantity.getNumber();
		
		// Conver float : 20.0 -> 20, 20.5 -> 20.5
        if (theNumber - (int) theNumber == 0.0) {
            fullIngredient = ""+(int) theNumber;
        } else {
            fullIngredient = ""+theNumber;
        }
  
		fullIngredient += " " + quantity.getMeasurement().getName() + " " + quantity.getIngredient().getName();
		
		return fullIngredient;			// demo : 20 gr Ức gà
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public List<String> getFullIngredients() {
		return fullIngredients;
	}

	public void setFullIngredients(List<String> fullIngredients) {
		this.fullIngredients = fullIngredients;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	
	
	
	
	
}
