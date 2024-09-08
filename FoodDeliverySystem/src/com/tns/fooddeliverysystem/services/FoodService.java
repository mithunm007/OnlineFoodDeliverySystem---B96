package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;

import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class FoodService {
	
	private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(int restaurantId, String restaurantName) {
        Restaurant restaurant = new Restaurant(restaurantId, restaurantName);
        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant(int restaurantId, int foodItemId, String foodItemName, double foodItemPrice) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            FoodItem foodItem = new FoodItem(foodItemId, foodItemName, foodItemPrice);
            restaurant.addFoodItem(foodItem);
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
            System.out.println("Food item removed successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public void viewRestaurantsAndMenus() {
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }

    public Restaurant findRestaurantById(int restaurantId) {
        return restaurants.stream().filter(r -> r.getId() == restaurantId).findFirst().orElse(null);
    }

    public FoodItem findFoodItemById(int restaurantId, int foodItemId) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            return restaurant.getMenu().stream().filter(f -> f.getId() == foodItemId).findFirst().orElse(null);
        }
        return null;
    }

}
