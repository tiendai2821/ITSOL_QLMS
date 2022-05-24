package entity;

import java.util.Scanner;

public class Sach {
    private static int  AUTO_ID = -1;
    public static final String KHTN = "Khoa học tự nhiên";
    public static final String VHNT = "Văn học nghệ thuật";
    public static final String DTVT = "Điện tử viễn thông";
    public static final String CNTT = "Công nghệ thông tin";

   private int id;
   private String name;
   private String tacgia;
   private String chuyennganh;
   private String namxuatban;


    public Sach() {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public String getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(String namxuatban) {
        this.namxuatban = namxuatban;
    }



    public void inputInfor(){
        System.out.print("Nhập tên cho sách: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên tác giả cho sách: ");
        this.tacgia = new Scanner(System.in).nextLine();
        System.out.println("Nhập chuyên ngành cho sách: ");
        System.out.println("Nhập chuyên ngành là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn hóa nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");

        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.print("Lựa chọn chuyên ngành không hợp lệ, vui lòng chọn lại: ");
        } while (choice > 4 || choice < 1);
        switch (choice) {
            case 1:
                this.chuyennganh = Sach.KHTN;
                break;
            case 2:
                this.chuyennganh = Sach.VHNT;
                break;
            case 3:
                this.chuyennganh = Sach.DTVT;
                break;
            case 4:
                this.chuyennganh = Sach.CNTT;
                break;
        }
        System.out.print("Nhập năm xuất bản: ");
        this.namxuatban = new Scanner(System.in).nextLine();
    }
    public String toString() {
        return "entity.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tac gia='" +  + '\'' +
                ", chuyen nganh='" + chuyennganh + '\'' +
                ", nam xuat ban='" + namxuatban + '\'' +
                '}';
    }

}
