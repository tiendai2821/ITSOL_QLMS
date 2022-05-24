package entity;

import java.util.Scanner;


public class BanDoc {


    private static int AUTO_ID = -1;

    private int id;
    private String name;
    private String address;
    private String phoneNumber; // "0925687136"

    private String customerCategory;

    public BanDoc() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    @Override
    public String toString() {
        return "entity.Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void inputInfo() {
        System.out.print("Nhập tên cho bạn đọc: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ cho bạn đọc: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập SĐT cho bạn đọc: ");
        this.phoneNumber = new Scanner(System.in).nextLine();

    }

}
