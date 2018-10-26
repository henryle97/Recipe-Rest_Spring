package com.hisiter.recipe_rest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		//~ auto_increment
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@Column(name="service")
	private int service;		// phuc vu so nguoi
	
	@Column(name="cook_time")
	private int cookTime;
	
	// Lien ket toi table food_category (foreign key)
	@OneToOne(cascade=CascadeType.ALL)			// anh huong voi table kia : cascade
	@JoinColumn(name="food_category_id")
	private FoodCategory foodCategory;
	
	// table quantity references den table recipe
	@JsonManagedReference			// child is @JsonBackReference ngan chan loop
	@OneToMany(mappedBy="recipe",
			fetch=FetchType.LAZY,				// EARGER : find all object relatition  | LAZY : get entity đầu tiên 
			cascade= { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Quantity> quantities;
	
	// convenient method for add quantity (BAT BUOC neu muon thiet lap quan he) : Dành cho insert data 
	public void add(Quantity quantity) {
		if (quantities == null) {
			quantities = new ArrayList<Quantity>();
		}
		//setting up relation
		quantity.setRecipe(this);
		quantities.add(quantity);
	}

	public Recipe() {}
	public Recipe(String name, int service, int cookTime) {
		super();
		this.name = name;
		this.service = service;
		this.cookTime = cookTime;
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
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public List<Quantity> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Quantity> quantities) {
		this.quantities = quantities;
	}
	
	
	
	
	
}
