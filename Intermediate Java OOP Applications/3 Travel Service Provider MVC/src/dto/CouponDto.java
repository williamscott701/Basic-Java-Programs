package dto;

public class CouponDto {

    private String companyEmail;
    private int amount;
    private int coupon;

    public CouponDto(String companyEmail, int amount, int coupons) {
        this.companyEmail = companyEmail;
        this.amount = amount;
        this.coupon = coupons;
    }

    public CouponDto(int coupons) {
        this.coupon = coupons;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupons) {
        this.coupon = coupons;
    }

}
