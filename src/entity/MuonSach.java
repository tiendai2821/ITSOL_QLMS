package entity;

public class MuonSach {
    private Sach sach;
    private int soluong;

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "MuonSach{" +
                "sach=" + sach +
                ", soluong=" + soluong +
                '}';
    }
}
