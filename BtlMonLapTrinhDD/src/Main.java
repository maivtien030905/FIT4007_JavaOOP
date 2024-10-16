import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyPhongTap quanLy = new QuanLyPhongTap();
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            System.out.println("\n----- Quản Lý Phòng Tập -----");
            System.out.println("1. Tìm kiếm phòng tập");
            System.out.println("2. Thêm hội viên");
            System.out.println("3. Chọn khu vực và thời gian tập");
            System.out.println("4. Xem danh sách hội viên");
            System.out.println("5. Lưu danh sách phòng tập vào tệp");
            System.out.println("6. Lưu danh sách hội viên vào tệp");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã hoặc tên phòng cần tìm: ");
                    String tuKhoa = scanner.nextLine();
                    PhongTap phong = quanLy.timPhongTap(tuKhoa);
                    if (phong != null) {
                        System.out.println("Tìm thấy phòng tập:");
                        System.out.println(phong);
                    } else {
                        System.out.println("Không tìm thấy phòng tập.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên hội viên: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int tuoi = scanner.nextInt();
                    scanner.nextLine();

                    String goiTap = chonGoiTap(scanner);
                    HoiVien hoiVien = new HoiVien(ten, tuoi, goiTap);
                    quanLy.themHoiVien(hoiVien);
                    System.out.println("Đã thêm hội viên: " + ten + " với gói " + goiTap);

                    System.out.print("Bạn có muốn thanh toán hóa đơn cho hội viên này không? (y/n): ");
                    String xacNhanThanhToan = scanner.nextLine();
                    if (xacNhanThanhToan.equalsIgnoreCase("y")) {
                        System.out.print("Nhập số tiền thanh toán: ");
                        double soTien = scanner.nextDouble();
                        scanner.nextLine();

                        if (hoiVien.thanhToan(soTien)) {
                            System.out.println("Thanh toán thành công cho hội viên: " + ten);
                        } else {
                            System.out.println("Thanh toán không thành công. Kiểm tra số tiền hoặc thông tin hội viên.");
                        }
                    } else {
                        System.out.println("Không thanh toán hóa đơn cho hội viên.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập khu vực: ");
                    String khuVuc = scanner.nextLine();
                    System.out.print("Nhập thời gian tập (HH:mm): ");
                    String thoiGian = scanner.nextLine();
                    List<PhongTap> ketQua = quanLy.timPhongTheoKhuVucVaThoiGian(khuVuc, thoiGian);
                    if (ketQua.isEmpty()) {
                        System.out.println("Không tìm thấy phòng tập phù hợp.");
                    } else {
                        System.out.println("Danh sách phòng tập:");
                        for (PhongTap p : ketQua) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    quanLy.inDanhSachHoiVien();
                    break;
                case 5:
                    System.out.print("Nhập tên tệp: ");
                    String tenTepPhong = scanner.nextLine();
                    try {
                        quanLy.luuPhongTapVaoTep(tenTepPhong);
                        System.out.println("Đã lưu danh sách phòng tập.");
                    } catch (IOException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên tệp: ");
                    String tenTepHoiVien = scanner.nextLine();
                    try {
                        quanLy.luuHoiVienVaoTep(tenTepHoiVien);
                        System.out.println("Đã lưu danh sách hội viên.");
                    } catch (IOException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
    private static String chonGoiTap(Scanner scanner) {
        System.out.println("Chọn gói tập:");
        System.out.println("1. Gói ngày 15,000/N");
        System.out.println("2. Gói tháng 300,000/N");
        System.out.println("3. Gói năm 2,000,000/N");
        System.out.print("Lựa chọn của bạn: ");
        int luaChonGoiTap = scanner.nextInt();
        scanner.nextLine();

        switch (luaChonGoiTap) {
            case 1:
                return "Gói ngày 15,000/N";
            case 2:
                return "Gói tháng 300,000/N";
            case 3:
                return "Gói năm 2,000,000/N";
            default:
                System.out.println("Lựa chọn không hợp lệ! Sử dụng mặc định: Gói ngày.");
                return "Gói ngày";
        }
    }
}
