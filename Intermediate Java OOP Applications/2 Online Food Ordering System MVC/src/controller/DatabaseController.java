package controller;

import dto.CartDto;
import dto.CustomerDto;
import dto.MenuItemDto;
import dto.OrderHistoryDto;
import dto.RestaurentDto;
import java.math.BigInteger;
import java.util.ArrayList;

public class DatabaseController {

    private static CustomerDto customers[] = new CustomerDto[300];
    private static int customerCount = 0;

    private static RestaurentDto restaurents[] = new RestaurentDto[300];
    private static int restaurentsCount = 0;

    private static MenuItemDto menuItems[] = new MenuItemDto[300];
    private static int menuItemsCount = 0;

    private static CartDto cart[] = new CartDto[300];
    private static int cartCount = 0;

    private static OrderHistoryDto orderHistory[] = new OrderHistoryDto[300];
    private static int orderHistoryCount = 0;

    public static void addCart(CartDto c) {
        cart[cartCount++] = c;
    }

    public static void addOrderHistory(OrderHistoryDto c) {
        orderHistory[orderHistoryCount++] = c;
    }

    public static ArrayList getOrderHistoryCustomer(int customerID) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < orderHistoryCount; i++) {
            if (orderHistory[i].getCustomerId() == customerID) {
                a.add(orderHistory[i]);
            }
        }
        return a;
    }

    public static ArrayList getOrderHistoryRestaurent(int restaurentId) {
        System.out.println(restaurentId);
        ArrayList a = new ArrayList();
        for (int i = 0; i < orderHistoryCount; i++) {
            if (orderHistory[i].getRestaurentId() == restaurentId) {
                a.add(orderHistory[i]);
            }
        }
        return a;
    }

    public static CartDto getCart(String email) {
        CartDto c = new CartDto("failed");
        for (int i = 0; i < cartCount; i++) {
            if (cart[i].getCustomerEmail().equals(email)) {
                c = cart[i];
            }
        }
        return c;
    }

    public static CustomerDto addCustomer(CustomerDto customer) {
        customers[customerCount++] = customer;
        return customer;
    }

    public static CustomerDto getCustomer(CustomerDto customer) {
        CustomerDto c = new CustomerDto("failed");
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getEmail().equals(customer.getEmail()) && customers[i].getPassword() == customer.getPassword()) {
                c = customers[i];
            }
        }
        return c;
    }

    public static void addMenuItem(MenuItemDto item) {
        menuItems[menuItemsCount++] = item;
    }

    public static MenuItemDto getMenuItem(int itemId) {
        MenuItemDto r = new MenuItemDto("failed");
        for (int i = 0; i < menuItemsCount; i++) {
            if (menuItems[i].getItemId() == itemId) {
                r = menuItems[i];
            }
        }
        return r;
    }

    public static MenuItemDto[] getMenu() {
        return menuItems;
    }

    public static void addRestaurent(RestaurentDto restaurent) {
        restaurents[restaurentsCount++] = restaurent;
    }

    public static RestaurentDto getRestaurent(RestaurentDto restaurent) {
        RestaurentDto r = new RestaurentDto("failed");
        for (int i = 0; i < restaurentsCount; i++) {
            if (restaurents[i].getEmail().equals(restaurent.getEmail()) && restaurents[i].getPassword() == restaurent.getPassword()) {
                r = restaurents[i];
            }
        }
        return r;
    }

    public static RestaurentDto getRestaurentA(String email) {
        RestaurentDto r = new RestaurentDto();
        for (int i = 0; i < restaurentsCount; i++) {
            if (restaurents[i].getEmail().equals(email)) {
                r = restaurents[i];
            }
        }
        return r;
    }

    public static RestaurentDto getRestaurentB(int restId) {
        RestaurentDto r = new RestaurentDto();
        for (int i = 0; i < restaurentsCount; i++) {
            if (restaurents[i].getRestaurentId() == restId) {
                r = restaurents[i];
            }
        }
        return r;
    }

    public static int getRestaurentDeliveryFee(int restId) {
        int del = 0;
        for (int i = 0; i < restaurentsCount; i++) {
            if (restaurents[i].getEmail().hashCode() == restId) {
                del = restaurents[i].getDeliveryFee();
            }
        }
        return del;
    }

    public static void generateData() {
        customers[customerCount++] = new CustomerDto(1, "William", "1".hashCode(), "1", new BigInteger("7845108300"));

        restaurents[restaurentsCount++] = new RestaurentDto("123".hashCode(), "1", "a", BigInteger.ONE, "Timings", "1".hashCode(), "1", 10, 10);
        restaurents[restaurentsCount++] = new RestaurentDto("12".hashCode(), "2", "a", BigInteger.ONE, "Timings", "2".hashCode(), "2", 10, 10);

        addMenuItem(new MenuItemDto(123, "1".hashCode(), "A", 100, "Hell", "Veg", "1"));
        addMenuItem(new MenuItemDto(124, "1".hashCode(), "A", 100, "Hell", "Veg", "1"));
        addMenuItem(new MenuItemDto(134, "2".hashCode(), "A", 100, "Hell", "Veg", "2"));
        addMenuItem(new MenuItemDto(234, "2".hashCode(), "A", 100, "Hell", "Veg", "2"));

    }

    static void removeCart(String email) {
   
    }

}
