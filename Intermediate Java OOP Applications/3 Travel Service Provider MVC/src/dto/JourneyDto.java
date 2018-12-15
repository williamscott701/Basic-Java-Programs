package dto;

import java.time.LocalDate;

public class JourneyDto {

    private int jouneyid;
    private String passenger;
    private int age;
    private int userid;
    private String companyid;
    private int vehicleid;
    private LocalDate date;
    private int farePaid;
    private String coupon;
    private String velhicle;
    private int refundAmount;

    public JourneyDto(int jouneyid, String passenger, int age, int userid, String companyid, int vehicleid, LocalDate date, int farePaid, String coupon, String velhicle) {
        this.jouneyid = jouneyid;
        this.passenger = passenger;
        this.age = age;
        this.userid = userid;
        this.companyid = companyid;
        this.vehicleid = vehicleid;
        this.date = date;
        this.farePaid = farePaid;
        this.coupon = coupon;
        this.velhicle = velhicle;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public int getFarePaid() {
        return farePaid;
    }

    public void setFarePaid(int farePaid) {
        this.farePaid = farePaid;
    }

    public int getJouneyid() {
        return jouneyid;
    }

    public void setJouneyid(int jouneyid) {
        this.jouneyid = jouneyid;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getVelhicle() {
        return velhicle;
    }

    public void setVelhicle(String velhicle) {
        this.velhicle = velhicle;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

}
