package model;

public class GeneralShop extends Shop {
    public GeneralShop(String id, String name) { super(id, name); }

    @Override
    public String shopType() { return "ร้านทั่วไป"; }
}
