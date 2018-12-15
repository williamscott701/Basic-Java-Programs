package dto;

import java.math.BigInteger;

public class CompanyDto {

    private String name;
    private BigInteger companyContactNumber;
    private BigInteger customerCareNumber;
    private String service;
    private String email;
    private int password;

    public CompanyDto(int companyId, String name, BigInteger companyContactNumber, BigInteger customerCareNumber, String service, String email, int password) {
        this.name = name;
        this.companyContactNumber = companyContactNumber;
        this.customerCareNumber = customerCareNumber;
        this.service = service;
        this.email = email;
        this.password = password;
    }

    public CompanyDto(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public BigInteger getCompanyContactNumber() {
        return companyContactNumber;
    }

    public void setCompanyContactNumber(BigInteger companyContactNumber) {
        this.companyContactNumber = companyContactNumber;
    }

    public BigInteger getCustomerCareNumber() {
        return customerCareNumber;
    }

    public void setCustomerCareNumber(BigInteger customerCareNumber) {
        this.customerCareNumber = customerCareNumber;
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

}
