Readme
This doc just has a very skeletal detilas
Please read the assumptions doc for full info

Classes:
- Admin
- Bus
- Company
- Coupon
- Flight
- Journey
- Train

Interfaces:
- Planner
- UserOperations
- Vehicle

Relationships:
- Admin interacts with Coupon
- Admin interacts with Flight
- Admin interacts with Bus
- Admin interacts with Train
- Admin interacts with Company
- Company interacts with Vehicle
- Company interacts with Journey
- Company interacts with Customer
- Vehicle interacts with Customer
- Vehicle interacts with Admin
- Vehicle interacts with Journey
- Vehicle interacts with Company
- Customer interacts with Vehicle
- Customer interacts with Journey

Interactions:
- Customer can Login
- Customer can Signup
- Customer can Book a Bus
- Customer can Book a Train
- Customer can Book a Flight
- Customer can cancel a booking
- Customer can print his booking history
- Customer can print cancelled booking history
- Customer can check his profile
- Customer can Logout
- Company can Login
- Company can Logout
- Company can Signup
- Company can Add a new Bus/Flight/Train
- Company can Check all his vehicles
- Company can check his booking history
- Company can add a coupon
- Company can view all his coupons
- Company can check his profile
- Admin can login
- Admin can logout
- Admin can view all users
- Admin can view all companies
- Admin can view all buses
- Admin can view all trains
- Admin can view all flights
- Admin can view all journies
- Admin can view all cancelled journies
- Admin can view all coupons
- Admin can add coupon
- Admin can remove coupons