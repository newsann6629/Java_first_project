package model;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void showInfo() {
        System.out.printf("  [%s] %s - %.2f บาท%n", id, name, price);
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public double getPrice() { return price; }
}
