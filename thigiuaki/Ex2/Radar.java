package thigiuaki.Ex2;

public class Radar {
    private double[] x;

    // Khởi tạo tín hiệu Radar theo công thức
    public Radar() {
        x = new double[16]; // Mảng lưu giá trị tín hiệu từ n=0 đến n=15
        for (int n = 0; n <= 15; n++) {
            x[n] = 1 - (double)n / 15;
        }
    }

    // Phương thức trả về giá trị tín hiệu Radar tại vị trí n
    public double getValueAt(int n) {
        if (n >= 0 && n <= 15) {
            return x[n];
        } else {
            return 0; // Trả về 0 nếu n ngoài phạm vi (0 <= n <= 15)
        }
    }

    // Phương thức hiển thị toàn bộ tín hiệu Radar
    public void displayRadarSignal() {
        for (int i = 0; i < x.length; i++) {
            System.out.println("X(" + i + ") = " + getValueAt(i));
        }
    }

    public static void main(String[] args) {
        Radar radarSignal = new Radar();
        radarSignal.displayRadarSignal(); // Hiển thị tín hiệu Radar
        
        // Lấy giá trị tín hiệu tại n=4
        System.out.println("X(4) = " + radarSignal.getValueAt(4));
    }
}

