import java.io.Serializable;
import java.util.List;

public class PhongTap implements Serializable {
    private String maPhong;
    private String tenPhong;
    private String diaChi;
    private String thoiGianMoCua;
    private String thoiGianDongCua;

    public PhongTap(String maPhong, String tenPhong, String diaChi,
                    String thoiGianMoCua, String thoiGianDongCua) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.diaChi = diaChi;
        this.thoiGianMoCua = thoiGianMoCua;
        this.thoiGianDongCua = thoiGianDongCua;
    }

    public String getMaPhong() { return maPhong; }
    public String getTenPhong() { return tenPhong; }
    public String getDiaChi() { return diaChi; }
    public String getThoiGianMoCua() { return thoiGianMoCua; }
    public String getThoiGianDongCua() { return thoiGianDongCua; }

    @Override
    public String toString() {
        return "PhongTap{" +
                "maPhong='" + maPhong + '\'' +
                ", tenPhong='" + tenPhong + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", moCua='" + thoiGianMoCua + '\'' +
                ", dongCua='" + thoiGianDongCua + '\'' +
                '}';
    }
}
