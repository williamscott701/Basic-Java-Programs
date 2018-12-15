package controller;

import dto.CouponDto;
import java.util.HashMap;
import static oopdassignment3.OOPDAssignment3.in;

public class CouponController {

    public static void addCouponByAdmin() {
        System.out.println("\n*Note: give -1 in companies to make it applicable to all companies");
        System.out.println("else you have to specifically enter their email");
        System.out.println("Enter Coupon:");
        int coupon = in.nextInt();
        System.out.println("Enter coupon worth");
        int amount = in.nextInt();
        System.out.println("Enter Company");
        String companyEmail = in.next();

        CouponDto c = new CouponDto(companyEmail, amount, coupon);

        DatabaseController.addCoupon(c);

    }

    public static void addCouponByCompany(String companyEmail) {
        System.out.println("\n*Note: give -1 in companies to make it applicable to all companies");
        System.out.println("else you have to specifically enter their email");
        System.out.println("Enter Coupon:");
        int coupon = in.nextInt();
        System.out.println("Enter coupon worth");
        int amount = in.nextInt();

        CouponDto c = new CouponDto(companyEmail, amount, coupon);

        DatabaseController.addCoupon(c);
    }

    public static void displayAllCouponByAdmin() {
        System.out.println("\n*Note: -1 is for all companies");
        System.out.println("Coupon\tAmount\tCompany Email");
        HashMap j = DatabaseController.getAllCoupons();
        for (Object value : j.values()) {
            CouponDto b = (CouponDto) value;
            System.out.println(b.getCoupon() + "\t" + b.getAmount() + "\t" + b.getCompanyEmail());
        }
    }

    public static void displayAllCouponByCompany(String companyEmail) {
        System.out.println("\n*Note: -1 is for all companies");
        System.out.println("Coupon\tAmount");
        HashMap j = DatabaseController.getAllCoupons();
        for (Object value : j.values()) {
            CouponDto b = (CouponDto) value;
            if (b.getCompanyEmail().equals(companyEmail) || b.getCompanyEmail().equals("-1")) {
                System.out.println(b.getCoupon() + "\t" + b.getAmount());
            }
        }
    }

    public static void removeCouponByAdmin() {
        System.out.println("Remove Coupon");
        displayAllCouponByAdmin();
        System.out.println("Enter Coupon: ");
        int coupon = in.nextInt();
        HashMap j = DatabaseController.getAllCoupons();
        j.remove(coupon);
        System.out.println("Successfully removed");
    }

}
