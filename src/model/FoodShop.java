package model;

public class FoodShop extends Shop {
    public FoodShop(String id, String name) { super(id, name); }

    @Override
    public String shopType() { return "ร้านอาหาร"; }
}
