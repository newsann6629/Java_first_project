package model;

public class ElectronicsShop extends Shop {
    public ElectronicsShop(String id, String name) { super(id, name); }

    @Override
    public String shopType() { return "ร้านอิเล็กทรอนิกส์"; }
}
