package com.hisiter.recipe_rest.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hisiter.recipe_rest.entity.Quantity;
import com.hisiter.recipe_rest.entity.Recipe;
import com.hisiter.recipe_rest.entity.RecipeDetail;
import com.hisiter.recipe_rest.entity.RecipeForSearch;
import com.hisiter.recipe_rest.service.RecipeService;
@RestController
@RequestMapping("/api")
public class RecipeRestController {
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/search")		// /search?q=...
	public List<RecipeForSearch> searchRecipe(@RequestParam(name="q") String theSearchInput){
		
		// Decode URL to unicode
		try {
			theSearchInput = URLDecoder.decode(theSearchInput, "UTF-8");
			System.out.println(theSearchInput);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		List<RecipeForSearch> recipes = recipeService.searchRecipe(theSearchInput);
		if (recipes.size() == 0) {
			throw new RecipeNotFoundException("Không tìm thấy kết quả nào");		// sẽ được xử lý bởi RecipeRestExceptionHandle
		}
		
		return recipes;
		
	}
	
	@GetMapping("/recipe")			// /recipe?id=...
	public RecipeDetail getRecipe(@RequestParam(name="id") int theId) {

		// Get recipe from DB
		Recipe recipe = recipeService.getRecipeById(theId);
		if(recipe == null ) {
			throw new RecipeNotFoundException("Không tìm thấy món ăn với id " + theId);
		}
		// Return lớp RecipeDetail để JACKSON convert thành JSON cho user dễ sử dụng 
		return new RecipeDetail(recipe);
		
	}

}
