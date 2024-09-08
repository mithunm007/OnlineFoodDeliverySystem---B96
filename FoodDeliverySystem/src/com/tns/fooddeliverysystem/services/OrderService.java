package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.Order;

public class OrderService {
	
	 private List<Order> orders = new ArrayList<>();
	    private int orderIdCounter = 1;

	    public void placeOrder(Customer customer) {
	        Order order = new Order(orderIdCounter++, customer);
	        orders.add(order);
	        System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
	    }

	    public void viewOrders() {
	        for (Order order : orders) {
	            System.out.println(order);
	        }
	    }

	    public Order findOrderById(int orderId) {
	        return orders.stream().filter(o -> o.getOrderId() == orderId).findFirst().orElse(null);
	    }

	    public void assignDeliveryPersonToOrder(int orderId, DeliveryPerson deliveryPerson) {
	        Order order = findOrderById(orderId);
	        if (order != null) {
	            order.assignDeliveryPerson(deliveryPerson);
	            System.out.println("Delivery person assigned to order successfully!");
	        } else {
	            System.out.println("Order not found!");
	        }
	    }

}
