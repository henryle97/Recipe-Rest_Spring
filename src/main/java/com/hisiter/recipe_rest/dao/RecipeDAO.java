package com.hisiter.recipe_rest.dao;

import java.util.List;

import com.hisiter.recipe_rest.entity.Recipe;
import com.hisiter.recipe_rest.entity.RecipeForSearch;

public interface RecipeDAO {
	Recipe getRecipeById(int id);
	
	List<RecipeForSearch> searchRecipe(String theSearcInput);
	
	List<RecipeForSearch> searchRecipeByName(String theSearcInput);
	List<RecipeForSearch> searchRecipeByIngredient(String theSearcInput);
}
