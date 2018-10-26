package com.hisiter.recipe_rest.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hisiter.recipe_rest.entity.Quantity;
import com.hisiter.recipe_rest.entity.Recipe;
import com.hisiter.recipe_rest.entity.RecipeForSearch;

@Repository  // chiu trach nhiem business handle 
public class RecipeDAOImpl implements RecipeDAO{

	@Autowired
	SessionFactory sessionFactory; 
	
	public Recipe getRecipeById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Recipe recipe = null;
		try {
			Query<Recipe> theQuery = session.createQuery("select i from Recipe i "
					+ "JOIN FETCH i.quantities "
					+ "where i.id = :recipeID", Recipe.class);
			theQuery.setParameter("recipeID", id);
		
			 recipe = theQuery.getSingleResult();		// nếu không tìm thấy trả về ngoại lệ 
		} catch (NoResultException ex) {
			return null;
		}
		return recipe;		
	}

	// Search Recipe
	public List<RecipeForSearch> searchRecipe(String theSearcInput) {

		return searchRecipeByName(theSearcInput);
	}

	public List<RecipeForSearch> searchRecipeByName(String theSearchInput) {
		
		// Get session
		Session session = sessionFactory.getCurrentSession();

		// Create query
		Query<RecipeForSearch> theQuery = session.createQuery("from RecipeForSearch r where lower(r.name) like lower(:query)", RecipeForSearch.class);
		theQuery.setParameter("query", "%" + theSearchInput + "%");
		
		// Get result
		List<RecipeForSearch> recipes = theQuery.getResultList();
		
		System.out.println(recipes);
		return recipes;
	}

	public List<RecipeForSearch> searchRecipeByIngredient(String theSearcInput) {
		// TODO Auto-generated method stub
		return null;
	}

}
