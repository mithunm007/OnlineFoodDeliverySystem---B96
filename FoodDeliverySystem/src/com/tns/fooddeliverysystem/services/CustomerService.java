package com.tns.fooddeliverysystem.services;

import java.util.HashMap;
import java.util.Map;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;

public class CustomerService {
	
	 private Map<Integer, Customer> customers = new HashMap<>();

	    public Customer addCustomer(int userId, String username, long contactNo) {
	        Customer customer = new Customer(userId, username, contactNo);
	        customers.put(userId, customer);
	        System.out.println("Customer created successfully!");
	        return customer;
	    }

	    public Customer getCustomer(int userId) {
	        return customers.get(userId);
	    }

	    public void viewCart(Customer customer) {
	        System.out.println(customer.getCart());
	    }

	    public void addFoodToCart(Customer customer, FoodItem foodItem, int quantity) {
	        customer.getCart().addItem(foodItem, quantity);
	        System.out.println("Food item added to cart!");
	    }

}
