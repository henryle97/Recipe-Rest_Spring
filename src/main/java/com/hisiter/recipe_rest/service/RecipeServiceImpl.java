package com.hisiter.recipe_rest.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisiter.recipe_rest.dao.RecipeDAO;
import com.hisiter.recipe_rest.entity.Recipe;
import com.hisiter.recipe_rest.entity.RecipeForSearch;

@Service
@Transactional(rollbackFor=Exception.class)		//auto commit or rollback if see SLQ exception 
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeDAO recipeDAO;
	

	public Recipe getRecipeById(int id) {

		return recipeDAO.getRecipeById(id);
	}


	public List<RecipeForSearch> searchRecipe(String theSearcInput) {
		
 		return recipeDAO.searchRecipe(theSearcInput);
	}

}
