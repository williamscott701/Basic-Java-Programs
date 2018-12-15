Classes:
Restaurant
Customer
Cart
OrderHistory
Payments
RestaurentMenu
Admin

Relationships:
Customer interacts with Restaurant
Customer interacts with Cart
Customer interacts with OrderHistory
Customer interacts with Payments
Customer interacts with RestaurentMenu
Restaurant interacts with Customer
Restaurant interacts with OrderHistory
Restaurant interacts with Payments
Restaurant interacts with RestaurentMenu


Interactions
Admin adds Restaurant 
Admin can Login
Admin can Logout
Customer can Login
Customer can addToCart
Customer can CheckMenu
Customer can removeFromCart
Customer can checkCart
Customer can placeOrder
Customer can check orderHistory
Customer can Logout
Restaurant can Login
Restaurant can addMenu
Restaurant can checkMenu
Restaurant can checkOrderHistory
Restaurant can Logout


Assumptions & Additional Features:
- Customer can order multiple items
- Admin cannot check customer and admins details
- Checking for Minimum Order while Placing Order
- Checking if the item entered is a valid itemId and if it is there in his cart
- Implemented using DTO’s and Controllers for better workability
- Used DatabaseController to mimic Database, by using global static objects
- Used proper Getters and Setters in DTO’s
- Saved HashCode for Password instead of actual password, for security reasons.