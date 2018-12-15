package dto;

import java.math.BigInteger;

public class CustomerDto {

    private int customerId;
    private String name;
    private int password;
    private String email;
    private BigInteger mobile;
    private AddressDto address[];

    public CustomerDto(String name) {
        this.name = name;
    }

    public CustomerDto(int password, String email) {
        this.password = password;
        this.email = email;
    }

    public CustomerDto(int customerId, String name, int password, String email, BigInteger mobile) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public AddressDto[] getAddress() {
        return address;
    }

    public void setAddress(AddressDto[] address) {
        this.address = address;
    }

}
