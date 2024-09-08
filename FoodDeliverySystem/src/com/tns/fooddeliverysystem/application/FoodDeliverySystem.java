package com.tns.fooddeliverysystem.application;
import java.util.List;
import java.util.Scanner;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.services.CustomerService;
import com.tns.fooddeliverysystem.services.FoodService;
import com.tns.fooddeliverysystem.services.OrderService;

public class FoodDeliverySystem {
	
	private static Functions functions = new Functions();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("WELCOME TO B96 RESTAURANT\n");
            System.out.println("1. Admin Menu\n2. Customer Menu\n3. Exit");
            System.out.println("Enter the Option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> customerMenu();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu: \n1. Add Restaurant\n2. Add Food Item to Restaurant\n3. Remove Food Item\n" +
                    "4. View Restaurants and Menus\n5. View Orders\n6. Add Delivery Person\n7. Assign Delivery Person to Order\n8. Exit");
            System.out.println("Enter the Option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> functions.addRestaurant();
                case 2 -> functions.addFoodItemToRestaurant();
                case 3 -> functions.removeFoodItemFromRestaurant();
                case 4 -> functions.viewRestaurantsAndMenus();
                case 5 -> functions.viewOrders();
                case 6 -> functions.addDeliveryPerson();
                case 7 -> functions.assignDeliveryPersonToOrder();
                case 8 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void customerMenu() {
        System.out.println("Enter Customer ID: ");
        int customerId = sc.nextInt();
        Customer customer = functions.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Enter Customer Name: ");
            String name = sc.next();
            System.out.println("Enter Contact No: ");
            long contactNo = sc.nextLong();
            customer = functions.addCustomer(customerId, name, contactNo);
        }

        while (true) {
            System.out.println("Customer Menu: \n1. View Food Items\n2. Add Food to Cart\n3. View Cart\n4. Place Order\n5. View Orders\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> functions.viewRestaurantsAndMenus();
                case 2 -> functions.addFoodToCart(customer);
                case 3 -> functions.viewCart(customer);
                case 4 -> functions.placeOrder(customer);
                case 5 -> functions.viewCustomerOrders(customer);
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
