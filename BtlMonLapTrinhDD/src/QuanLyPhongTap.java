import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyPhongTap {
    private List<PhongTap> danhSachPhongTap = new ArrayList<>();
    private List<HoiVien> danhSachHoiVien = new ArrayList<>();

    public void themPhongTap(PhongTap phongTap) {
        danhSachPhongTap.add(phongTap);
    }

    public PhongTap timPhongTap(String tuKhoa) {
        for (PhongTap phong : danhSachPhongTap) {
            if (phong.getMaPhong().equalsIgnoreCase(tuKhoa) ||
                    phong.getTenPhong().equalsIgnoreCase(tuKhoa)) {
                return phong;
            }
        }
        return null;
    }

    public List<PhongTap> timPhongTheoKhuVucVaThoiGian(String khuVuc, String thoiGian) {
        List<PhongTap> ketQua = new ArrayList<>();
        for (PhongTap phong : danhSachPhongTap) {
            if (phong.getDiaChi().contains(khuVuc) &&
                    phong.getThoiGianMoCua().compareTo(thoiGian) <= 0 &&
                    phong.getThoiGianDongCua().compareTo(thoiGian) >= 0) {
                ketQua.add(phong);
            }
        }
        return ketQua;
    }

    public void themHoiVien(HoiVien hoiVien) {
        danhSachHoiVien.add(hoiVien);
    }

    public void inDanhSachHoiVien() {
        System.out.println("Danh sách hội viên:");
        for (HoiVien hv : danhSachHoiVien) {
            System.out.println(hv);
        }
    }

    public void luuPhongTapVaoTep(String tenTep) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tenTep))) {
            out.writeObject(danhSachPhongTap);
        }
    }

    public void luuHoiVienVaoTep(String tenTep) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tenTep))) {
            out.writeObject(danhSachHoiVien);
        }
    }
}
