import java.io.Serializable;

public class HoiVien implements Serializable {
    private String ten;
    private int tuoi;
    private String goiTap;
    private double soDu;

    public HoiVien(String ten, int tuoi, String goiTap) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.goiTap = goiTap;
        this.soDu = soDu;
    }
    public boolean thanhToan(double soTien) {
        if (soDu >= soTien) {
            soDu -= soTien;
            System.out.println("Thanh toán thành công! Số dư còn lại: " + soDu);
            return true;
        } else {
            System.out.println("Thanh toán thất bại. Số dư không đủ.");
            return false;
        }
    }
    @Override
    public String toString() {
        return "HoiVien{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", goiTap='" + goiTap + '\'' +
                ", soDu='" + soDu + '\'' +
                '}';
    }
}
