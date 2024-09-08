package com.tns.fooddeliverysystem.application;

import java.util.*;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class Functions {
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<DeliveryPerson> deliveryPeople = new ArrayList<>();
    private Map<Integer, Customer> customers = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private int orderIdCounter = 1;

    public void addRestaurant() {
        System.out.println("Enter Restaurant ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Restaurant Name: ");
        String name = sc.next();
        restaurants.add(new Restaurant(id, name));
        System.out.println("Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant() {
        System.out.println("Enter Restaurant ID: ");
        int restaurantId = sc.nextInt();
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.println("Enter Food Item ID: ");
        int foodItemId = sc.nextInt();
        System.out.println("Enter Food Item Name: ");
        String name = sc.next();
        System.out.println("Enter Food Item Price: ");
        double price = sc.nextDouble();
        restaurant.addFoodItem(new FoodItem(foodItemId, name, price));
        System.out.println("Food item added successfully!");
    }

    public void removeFoodItemFromRestaurant() {
        System.out.println("Enter Restaurant ID: ");
        int restaurantId = sc.nextInt();
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.println("Enter Food Item ID: ");
        int foodItemId = sc.nextInt();
        restaurant.removeFoodItem(foodItemId);
        System.out.println("Food item removed successfully!");
    }

    public void viewRestaurantsAndMenus() {
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }

    public void viewOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void addDeliveryPerson() {
        System.out.println("Enter Delivery Person ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Delivery Person Name: ");
        String name = sc.next();
        System.out.println("Enter Contact No: ");
        long contactNo = sc.nextLong();
        deliveryPeople.add(new DeliveryPerson(id, name, contactNo));
        System.out.println("Delivery person added successfully!");
    }

    public void assignDeliveryPersonToOrder() {
        System.out.println("Enter Order ID: ");
        int orderId = sc.nextInt();
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("Enter Delivery Person ID: ");
        int deliveryPersonId = sc.nextInt();
        DeliveryPerson deliveryPerson = deliveryPeople.stream().filter(dp -> dp.getDeliveryPersonId() == deliveryPersonId).findFirst().orElse(null);
        if (deliveryPerson == null) {
            System.out.println("Delivery person not found!");
            return;
        }

        order.assignDeliveryPerson(deliveryPerson);
        System.out.println("Delivery person assigned to order successfully!");
    }

    public Customer addCustomer(int userId, String username, long contactNo) {
        Customer customer = new Customer(userId, username, contactNo);
        customers.put(userId, customer);
        System.out.println("Customer created successfully!");
        return customer;
    }

    public Customer getCustomer(int userId) {
        return customers.get(userId);
    }

    public void addFoodToCart(Customer customer) {
        System.out.println("Enter Restaurant ID: ");
        int restaurantId = sc.nextInt();
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        System.out.println("Enter Food Item ID: ");
        int foodItemId = sc.nextInt();
        FoodItem foodItem = restaurant.getMenu().stream().filter(f -> f.getId() == foodItemId).findFirst().orElse(null);
        if (foodItem == null) {
            System.out.println("Food item not found!");
            return;
        }
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();
        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food item added to cart!");
    }

    public void viewCart(Customer customer) {
        System.out.println(customer.getCart());
    }

    public void placeOrder(Customer customer) {
        Order order = new Order(orderIdCounter++, customer);
        orders.add(order);
        System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
    }

    public void viewCustomerOrders(Customer customer) {
        for (Order order : orders) {
            if (order.getCustomer().equals(customer)) {
                System.out.println(order);
            }
        }
    }

    private Restaurant findRestaurantById(int restaurantId) {
        return restaurants.stream().filter(r -> r.getId() == restaurantId).findFirst().orElse(null);
    }

    private Order findOrderById(int orderId) {
        return orders.stream().filter(o -> o.getOrderId() == orderId).findFirst().orElse(null);
    }
}
