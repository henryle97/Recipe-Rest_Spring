package com.hisiter.recipe_rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="quantity")
public class Quantity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@Column(name="number")
	private float number;
	
	@JsonBackReference
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	
	@OneToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
	@OneToOne
	@JoinColumn(name="ingredient_measurement_id")
	private Measurement measurement;

	public Quantity() {}
	public Quantity(float number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public Measurement getMeasurement() {
		return measurement;
	}
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}
	
	
	
	
	
	
	
	
}
