package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	 private int id;
	    private String name;
	    private List<FoodItem> menu;

	    public Restaurant(int id, String name) {
	        this.id = id;
	        this.name = name;
	        this.menu = new ArrayList<>();
	    }

	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public void addFoodItem(FoodItem item) {
	        menu.add(item);
	    }

	    public void removeFoodItem(int foodItemId) {
	        menu.removeIf(item -> item.getId() == foodItemId);
	    }

	    public List<FoodItem> getMenu() {
	        return menu;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("Restaurant{id=" + id + ", name='" + name + "', \nMenu:\n");
	        for (FoodItem item : menu) {
	            sb.append(item).append("\n");
	        }
	        return sb.toString();
	    }

}
