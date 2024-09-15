public class Main {
    public static void main(String[] args) {
        int tong = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                tong += i;
            }
        }
        System.out.println("Tong cac so la boi so cua 7 la: "+tong);
    }
}