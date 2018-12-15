package dto;

import java.math.BigInteger;

public class CustomerDto {

    private int customerId;
    private String name;
    private String email;
    private BigInteger mobile;
    private int password;
    private int balance;

    public CustomerDto() {
    }

    public CustomerDto(String email) {
        this.email = email;
    }

    public CustomerDto(int customerId, String name, String email, BigInteger mobile, int password) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.balance = 0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
