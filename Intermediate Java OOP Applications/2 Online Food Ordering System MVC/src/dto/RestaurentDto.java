package dto;

import java.math.BigInteger;

public class RestaurentDto {

    private int restaurentId;
    private String name;
    private String address;
    private BigInteger mobile;
    private BigInteger landline;
    private String timings;
    private int password;
    private String email;
    private int minimumOrder;
    private int deliveryFee;

    public RestaurentDto(String name) {
        this.name = name;
    }

    public RestaurentDto(int password, String email) {
        this.password = password;
        this.email = email;
    }

    public RestaurentDto(int restaurentId, String name, String address, BigInteger mobile, String timings, int password, String email, int minimumOrder, int deliveryFee) {
        this.restaurentId = restaurentId;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.timings = timings;
        this.password = password;
        this.email = email;
        this.minimumOrder = minimumOrder;
        this.deliveryFee = deliveryFee;
    }

    public RestaurentDto() {
    }

    public int getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public BigInteger getLandline() {
        return landline;
    }

    public void setLandline(BigInteger landline) {
        this.landline = landline;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMinimumOrder() {
        return minimumOrder;
    }

    public void setMinimumOrder(int minimumOrder) {
        this.minimumOrder = minimumOrder;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

}
