package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String Name;
	private String Type;
	private int Rating;

	public FoodTruck() {

	}

	public FoodTruck(String Name, String Type, int Rating) {
		super();
		this.Name = Name;
		this.Type = Type;
		this.Rating = Rating;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int Rating) {
		this.Rating = Rating;
	}

	@Override
	public String toString() {
		return "FoodTruck: " + Name + " | Type: " + Type + " | Rating: " + Rating + "\n";
	}

}