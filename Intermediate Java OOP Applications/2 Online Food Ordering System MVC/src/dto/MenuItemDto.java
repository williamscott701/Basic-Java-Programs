package dto;

public class MenuItemDto {

    private int restaurentId;
    private int itemId;
    private String itemName;
    private int price;
    private String description;
    private String veg;
    private String restaurentName;

    public MenuItemDto(int itemId, int restaurentId, String itemName, int price, String description, String veg, String restaurentName) {
        this.restaurentId = restaurentId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.veg = veg;
        this.restaurentName = restaurentName;
    }

    public MenuItemDto(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public int getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

}
