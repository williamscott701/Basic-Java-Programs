package dto;

import java.util.LinkedList;

public class CartDto {

    private LinkedList items;
    private String customerEmail;

    public CartDto(LinkedList item, String customerEmail) {
        this.items = item;
        this.customerEmail = customerEmail;
    }

    public CartDto(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LinkedList getItem() {
        return items;
    }

    public void setItem(LinkedList item) {
        this.items = item;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerName) {
        this.customerEmail = customerName;
    }

}
