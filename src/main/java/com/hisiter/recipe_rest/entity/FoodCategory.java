package com.hisiter.recipe_rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_category")
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public FoodCategory() {}
	public FoodCategory(String name) {
		super();
		this.name = name;
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
	
	
	
	
}
