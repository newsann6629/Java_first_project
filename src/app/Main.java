package app;

import model.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Shop> shops = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== ระบบร้านค้า =====");
            System.out.println("1. เพิ่มร้านค้า");
            System.out.println("2. เพิ่มสินค้าในร้าน");
            System.out.println("3. ดูข้อมูลร้านทั้งหมด");
            System.out.println("0. ออก");
            System.out.print("เลือก: ");

            switch (sc.nextLine().trim()) {
                case "1" -> Shop.addShop(sc, shops);
                case "2" -> Shop.addProduct(sc, shops);
                case "3" -> viewAllShops();
                case "0" -> running = false;
                default  -> System.out.println("ไม่มีตัวเลือกนี้");
            }
        }
        System.out.println("----------ออกจากโปรแกรม----------");
    }

    static void viewAllShops() {
        if (shops.isEmpty()) {
            System.out.println("ยังไม่มีร้านค้า");
            return;
        }
        shops.forEach(Shop::showInfo);
    }
}