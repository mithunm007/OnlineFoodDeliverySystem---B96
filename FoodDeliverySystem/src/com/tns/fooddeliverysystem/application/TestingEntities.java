package com.tns.fooddeliverysystem.application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tns.fooddeliverysystem.entities.*;

import java.util.HashMap;
import java.util.Map;

public class TestingEntities {

    private Customer customer;
    private DeliveryPerson deliveryPerson;
    private FoodItem foodItem;
    private Restaurant restaurant;
    private Cart cart;

    @BeforeEach
    public void setUp() {
        customer = new Customer(1, "John Doe", 1234567890L);
        deliveryPerson = new DeliveryPerson(101, "Jane Doe", 9876543210L);
        foodItem = new FoodItem(201, "Pizza", 12.99);
        restaurant = new Restaurant(301, "Test Restaurant");
        cart = new Cart();
    }

    // Testing Customer Entity
    @Test
    public void testCustomerCreation() {
        assertNotNull(customer);
        assertEquals(1, customer.getUserid());
        assertEquals("John Doe", customer.getUsername());
        assertEquals(1234567890L, customer.getContactno());
    }

    // Testing DeliveryPerson Entity
    @Test
    public void testDeliveryPersonCreation() {
        assertNotNull(deliveryPerson);
        assertEquals(101, deliveryPerson.getDeliveryPersonId());
        assertEquals("Jane Doe", deliveryPerson.getName());
        assertEquals(9876543210L, deliveryPerson.getContactNo());
    }

    // Testing FoodItem Entity
    @Test
    public void testFoodItemCreation() {
        assertNotNull(foodItem);
        assertEquals(201, foodItem.getId());
        assertEquals("Pizza", foodItem.getName());
        assertEquals(12.99, foodItem.getPrice());
    }

    // Testing Restaurant Entity
    @Test
    public void testRestaurantCreation() {
        assertNotNull(restaurant);
        assertEquals(301, restaurant.getId());
        assertEquals("Test Restaurant", restaurant.getName());
    }

    // Testing adding FoodItem to Restaurant's menu
    @Test
    public void testAddFoodItemToRestaurant() {
        restaurant.addFoodItem(foodItem);
        assertEquals(1, restaurant.getMenu().size());
        assertEquals("Pizza", restaurant.getMenu().get(0).getName());
    }

    // Testing Cart functionality
    @Test
    public void testCartFunctionality() {
        cart.addItem(foodItem, 2); // Adding 2 pizzas
        Map<FoodItem, Integer> items = cart.getItems();
        assertFalse(items.isEmpty());
        assertEquals(2, items.get(foodItem).intValue());
    }

    // Testing Order Entity
    @Test
    public void testOrderCreation() {
        Map<FoodItem, Integer> orderItems = new HashMap<>();
        orderItems.put(foodItem, 2);
        Order order = new Order(401, customer);
        order.setDeliveryPerson(deliveryPerson);
        assertEquals(401, order.getOrderId());
        assertEquals("Pending", order.getStatus());
        assertEquals(deliveryPerson, order.getDeliveryPerson());
    }
}

