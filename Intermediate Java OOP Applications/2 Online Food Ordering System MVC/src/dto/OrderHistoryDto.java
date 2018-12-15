package dto;

import java.util.Date;

public class OrderHistoryDto {

    private Date timestamp;
    private int total;
    private int customerId;
    private int restaurentId;
    private String status;
    private CartDto cart;

    public OrderHistoryDto(String status) {
        this.status = status;
    }

    public OrderHistoryDto(Date timestamp, int total, int customerId, int restaurentId, CartDto cart) {
        this.timestamp = timestamp;
        this.total = total;
        this.customerId = customerId;
        this.restaurentId = restaurentId;
        this.cart = cart;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    public int getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
