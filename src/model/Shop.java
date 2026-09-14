package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Shop {
    private String id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public Shop(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String shopType();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(Scanner sc) {
        System.out.print("ID สินค้า: ");
        String productId = sc.nextLine().trim();

        System.out.print("ชื่อสินค้า: ");
        String productName = sc.nextLine().trim();

        System.out.print("ราคา: ");
        double price = Double.parseDouble(sc.nextLine().trim());

        addProduct(new Product(productId, productName, price));
        System.out.println("เพิ่มสินค้า \"" + productName + "\" ในร้าน " + this.name + " แล้ว");
    }

    public static void addShop(Scanner sc, List<Shop> shops) {
        System.out.print("ID ร้าน: ");
        String id = sc.nextLine().trim();

        System.out.print("ชื่อร้าน: ");
        String name = sc.nextLine().trim();

        System.out.println("ประเภทร้าน: 1=อาหาร  2=อิเล็กทรอนิกส์  3=ทั่วไป");
        System.out.print("เลือก: ");
        String type = sc.nextLine().trim();

        Shop shop = switch (type) {
            case "1" -> new FoodShop(id, name);
            case "2" -> new ElectronicsShop(id, name);
            default  -> new GeneralShop(id, name);
        };

        shops.add(shop);
        System.out.println("เพิ่มร้าน \"" + name + "\" เรียบร้อย");
    }

    public static void addProduct(Scanner sc, List<Shop> shops) {
        if (shops.isEmpty()) {
            System.out.println("ยังไม่มีร้านค้า กรุณาเพิ่มร้านก่อน");
            return;
        }

        System.out.println("เลือกร้านค้า:");
        for (int i = 0; i < shops.size(); i++) {
            System.out.println((i + 1) + ". " + shops.get(i).getName());
        }
        System.out.print("เลือก: ");

        int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
        if (idx < 0 || idx >= shops.size()) {
            System.out.println("ไม่พบร้านนี้");
            return;
        }

        shops.get(idx).addProduct(sc);
    }

    public void showInfo() {
        System.out.println("\n [" + id + "] " + name + " | ประเภท: " + shopType());
        if (products.isEmpty()) {
            System.out.println("  (ยังไม่มีสินค้า)");
        } else {
            products.forEach(Product::showInfo);
        }
    }

    public String getId()   { return id; }
    public String getName() { return name; }
}
