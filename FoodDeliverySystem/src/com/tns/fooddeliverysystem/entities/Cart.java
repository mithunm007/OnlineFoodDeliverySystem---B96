package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<FoodItem, Integer> items = new HashMap<>();

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double totalCost = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            sb.append("Food Item: ").append(item.getName()).append(", Quantity: ").append(quantity)
              .append(", Cost: ").append(item.getPrice() * quantity).append("\n");
            totalCost += item.getPrice() * quantity;
        }
        sb.append("Total Cost: Rs. ").append(totalCost);
        return sb.toString();
    }
}
