import entity.MuonSach;
import entity.QLMuonSach;
import entity.Sach;
import entity.BanDoc;

import java.util.Scanner;


public class MainRun {
    private static int sophieumuon = 0;
    private static Sach[] sachList = new Sach[100];
    private static BanDoc[] bandocList = new BanDoc[100];
    private static QLMuonSach[] qlMuonSachList = new QLMuonSach[100];
    public static void main(String[] args) {
        showMenu();// menu console
    }

    private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewBook();
                    break;
                case 2:
                    showAllBook();
                    break;
                case 3:
                    inputNewReader();
                    break;
                case 4:
                    showAllReader();
                    break;
                case 5:
                    callCart();
                    showAllCallCart();
                    break;
                case 6:
                    sortOrderByCustomerName();
                    showAllCallCart();
                    break;
                case 7:
                    sortOrderByBookRentNum();
                    showAllCallCart();
                    break;
                case 8:
                    findByNameReader();
                    break;

                case 9:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
            }
        }
    }


    private static int functionChoice() {
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ MƯỢN SÁCH =====\n\n");
        System.out.println("1. Nhập danh sách đầu sách mới.");
        System.out.println("2. In ra danh sách đầu sách trong hệ thống.");
        System.out.println("3. Nhập danh sách bạn đọc.");
        System.out.println("4. In ra danh sách bạn đọc trong hệ thống.");
        System.out.println("5. Lập bảng quản lý mượn sách.");
        System.out.println("6. Sắp xếp bảng quản lý mượn sách theo tên bạn đọc");
        System.out.println("7. Sắp xếp bảng quản lý mượn sách theo giảm dần lượt mượn");
        System.out.println("8. Hiển thị danh sách mượn sách theo tên bạn đọc");
        System.out.println("9. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
                int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 9) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 9 || functionChoice < 1);
        return functionChoice;
    }

    private static void inputNewBook() {
        // xử lý nhập khách hàng mới
        System.out.print("Nhập số lượng khách đầu sách mới muốn thêm: ");
        int newBookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newBookNumber; i++) {
            System.out.println("Nhập thông tin cho đầu sách thứ " + (i + 1));
            // thực hiện nhập thông tin cho sách
             Sach sach = new Sach();
            sach.inputInfor();

            // lưu vào hệ thống ==> thêm vào mảng CUSTOMERS đã khai báo bên trên
            saveBook(sach);
        }
    }
    private static void saveBook(Sach sach) {
        for (int j = 0; j < sachList.length; j++) {
            if (sachList[j] == null) {
                sachList[j] = sach;
                break;
            }
        }
    }
    private static void showAllBook(){
        for (int i = 0; i < sachList.length; i++) {
            if (sachList[i] == null) {
                continue;
            }
            System.out.println(sachList[i]);
        }
    }
    private static void inputNewReader(){
        System.out.print("Nhập số lượng bạn đọc: ");
        int readerNum = new Scanner(System.in).nextInt();
        for(int i = 0; i<readerNum; i++){
            System.out.println("Nhập thông tin cho bạn đọc thứ "+(i+1));
            BanDoc banDoc = new BanDoc();
            banDoc.inputInfo();
            saveReader(banDoc);
        }
    }
    private static void saveReader(BanDoc banDoc){
        for (int j = 0; j < bandocList.length; j++) {
            if (bandocList[j] == null) {
                bandocList[j] = banDoc;
                break;
            }
        }
    }
    private static void showAllReader(){
        for (int i = 0; i < bandocList.length; i++) {
            if (bandocList[i] == null) {
                continue;
            }
            System.out.println(bandocList[i]);
        }
    }
    public  static BanDoc searchReaderById(int id){
        for(int i=0;i< bandocList.length;i++){
            if(bandocList[i]!=null) {
                if (bandocList[i].getId() == id)
                    return bandocList[i];
            }
        }
        return null ;
    }
    public  static Sach searchBookById(int id){
        for(int i=0;i< sachList.length;i++){
            if(sachList[i]!=null) {
                if (sachList[i].getId() == id)
                    return sachList[i];
            }
        }
        return null ;
    }
    private static boolean checkSameCode(int id,MuonSach[] msl){
        for(int i=0;i< msl.length;i++){
            if(msl[i]!=null) {
                if (id == msl[i].getSach().getId())
                    return false;
            }

        }
        return true;
    }
    private static void callCart(){
        // check du lieu ban doc va sach

        if(sachList[0] == null){
            System.out.println("Chưa có dữ liệu sách");
            return;
        }
        if(bandocList[0] == null){
            System.out.println("Chưa có dữ liệu bạn đọc ");
            return;
        }
        QLMuonSach ql=new QLMuonSach();
// nhap dau sach cho 1 ban doc


        BanDoc bd;
        do{
            System.out.print("Nhập mã bạn đọc muốn thêm: ");
            int idbd = new Scanner(System.in).nextInt();
            // tim ten ban doc
            bd=searchReaderById(idbd);
            if(bd!=null)
                break;
            System.out.println("Mã bạn đọc không tồn tại, mời nhập lại mã bạn đọc từ 10000 trở lên");

        }while(true);
        // set name bạn đọc
        ql.setBanDoc(bd);

        int n;
        do{
            System.out.print("Nhập số lượng đầu sách muốn mượn: ");
            n=new Scanner(System.in).nextInt();
            if(n<=5)
                break;
            System.out.println("Số lượng đầu sách phải < 5");

        }while (true);
        // set danh sách bạn muốn mượn

        MuonSach[] msl=new MuonSach[n];
        for(int i=0;i<n;i++){

            int idsach;
            do {
                System.out.print("Nhập mã sách thứ "+(i+1)+" muốn thêm: ");
                idsach=new Scanner(System.in).nextInt();
                // kiem tra masach trong ds da muon
                if(searchBookById(idsach)!=null&&checkSameCode(idsach,msl))
                    break;
                System.out.println("Mã sách không tồn tại hoặc mã sách trùng. Mời nhập lại: ");
            }while (true);
            Sach s=searchBookById(idsach);
            MuonSach ms=new MuonSach();
            ms.setSach(s);
            int sl;
            do {
                System.out.print("Nhập số lượng sách có mã "+idsach+" : ");
                sl=new Scanner(System.in).nextInt();
                if(sl<=3)
                    break;
                System.out.println("Số lượng mã sách không được lớn hơn 3");
            }while (true);

            ms.setSoluong(sl);
            msl[i]=ms;
        }
        ql.setMuonSach(msl);

        for(int i = 0; i<100; i++){
            if (qlMuonSachList[i] == null){
                qlMuonSachList[i] = ql;
                sophieumuon ++;
                break;
            }
        }
    }
    private static void showAllCallCart(){
        for(int i=0;i<qlMuonSachList.length;i++){
            if(qlMuonSachList[i]!=null){
                System.out.print("Ban doc "+qlMuonSachList[i].getBanDoc().getName()+" đã mượn các sách: ");
                for(int j=0;j<qlMuonSachList[i].getMuonSach().length;j++){
                    System.out.println(qlMuonSachList[i].getMuonSach()[j].getSach().getName()+"  Số lượng: "+qlMuonSachList[i].getMuonSach()[j].getSoluong());
                }
            }
        }
    }
    private static void sortOrderByCustomerName() {

        if (qlMuonSachList[0] == null) {
            System.out.println("Chưa có dữ liệu về phiếu mượn nào, vui lòng kiểm tra lại danh sách phiếu mượn");
            return;
        }

        for (int i = 0; i < sophieumuon; i++) {
            for (int j = i + 1; j < sophieumuon; j++) {
                if (qlMuonSachList[i].getBanDoc().getName().compareTo(qlMuonSachList[j].getBanDoc().getName()) > 0) {
                    QLMuonSach tmp = qlMuonSachList[i];
                    qlMuonSachList[i] = qlMuonSachList[j];
                    qlMuonSachList[j] = tmp;
                }
            }
        }
    }
    public static int getTotal(QLMuonSach ql){
        int sum=0;
        for(int i=0;i<ql.getMuonSach().length;i++){
            MuonSach ms=ql.getMuonSach()[i];
            if(ms!=null){
                sum+=ms.getSoluong();
            }
        }
        return sum;
    }
    public static void sortOrderByBookRentNum(){
        boolean checkData=false;
        for(int i=0;i<qlMuonSachList.length;i++){
            if(qlMuonSachList[i]!=null){
                checkData=true;
                break;
            }
        }
        if(!checkData){
            System.out.println("Chưa có dữ liệu về phiếu mượn nào, vui lòng kiểm tra lại danh sách phiếu mượn");
            return;
        }
        for(int i=0;i<sophieumuon;i++){
            for(int j=i+1;j<sophieumuon;j++){
                if(getTotal(qlMuonSachList[i])<getTotal(qlMuonSachList[j])){
                    QLMuonSach tmp=qlMuonSachList[i];
                    qlMuonSachList[i]=qlMuonSachList[j];
                    qlMuonSachList[j]=tmp;
                }
            }
        }
    }
    private static void findByNameReader(){
        System.out.println("Mời nhập tên bạn đọc");
        String nameReader = new Scanner(System.in).nextLine();

        for(int i = 0 ; i<sophieumuon; i++){
            if(qlMuonSachList[i].getBanDoc().getName().equals(nameReader)){
                System.out.print("Bạn đọc "+qlMuonSachList[i].getBanDoc().getName()+" đã mượn các sách: ");
                for(int j=0;j<qlMuonSachList[i].getMuonSach().length;j++){
                    System.out.println(qlMuonSachList[i].getMuonSach()[j].getSach().getName()+"  Số lượng: "+qlMuonSachList[i].getMuonSach()[j].getSoluong());
                }
            }
        }
    }
}
