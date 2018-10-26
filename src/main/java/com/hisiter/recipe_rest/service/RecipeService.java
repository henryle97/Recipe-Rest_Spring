package com.hisiter.recipe_rest.service;

import java.util.List;

import com.hisiter.recipe_rest.entity.Recipe;
import com.hisiter.recipe_rest.entity.RecipeForSearch;

public interface RecipeService {
	Recipe getRecipeById(int id);
	
	List<RecipeForSearch> searchRecipe(String theSearcInput);
}
